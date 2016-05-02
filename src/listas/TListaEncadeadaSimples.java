package listas;

import excecoes.ElementoInexistenteException;
import excecoes.EstruturaCheiaException;
import excecoes.EstruturaVaziaException;
import excecoes.PosicaoInvalidaException;

public class TListaEncadeadaSimples<T> implements TLista<T> {

	private TNo<T> lista;

	@Override
	public void inserirNoFinal(T valor) throws EstruturaCheiaException {
		TNo<T> novo = new TNo<T>(valor);

		if (isVazia()) {
			lista = novo;
		} else {
			TNo<T> aux = lista;
			while (aux.prox != null) {
				aux = aux.prox;
			}
			aux.prox = novo;
		}
	}

	@Override
	public void inserirNoInicio(T valor) throws EstruturaCheiaException {
		TNo<T> novo = new TNo<T>(valor);
		novo.prox = lista;
		lista = novo;
	}

	@Override
	public void inserirNumaPosicao(T valor, int posicao)
			throws EstruturaCheiaException, PosicaoInvalidaException {
		if (posicao < 1 || posicao > (tamanho() + 1)) {
			throw new PosicaoInvalidaException();
		}
		if (posicao == 1)
			inserirNoInicio(valor);
		else if (posicao == tamanho())
			inserirNoFinal(valor);
		else {
			TNo<T> novo = new TNo<T>(valor);
			TNo<T> aux = lista;
			for (int i = 1; i < posicao - 1; i++) {
				aux = aux.prox;
			}
			novo.prox = aux.prox;
			aux.prox = novo;
		}

	}

	@Override
	public T removerDoFinal() throws EstruturaVaziaException {

		if (isVazia())
			throw new EstruturaVaziaException();
		TNo<T> aux = lista;
		for (int i = 1; i < tamanho() - 1; i++) {
			aux = aux.prox;
		}
		TNo<T> lixo = aux.prox;
		aux.prox = null;
		return lixo.dado;
	}

	@Override
	public T removerDoInicio() throws EstruturaVaziaException {
		if (isVazia())
			throw new EstruturaVaziaException();
		TNo<T> aux = lista;
		lista = aux.prox;
		aux.prox = null;
		return aux.dado;
	}

	@Override
	public T removerDaPosicao(int posicao) throws EstruturaVaziaException,
			PosicaoInvalidaException {
		if (isVazia())
			throw new EstruturaVaziaException();
		if (posicao < 1 || posicao > (tamanho() + 1)) {
			throw new PosicaoInvalidaException();
		}
		if (posicao == 1) {
			return removerDoInicio();
		}
		if (posicao == tamanho()) {
			return removerDoFinal();
		}

		TNo<T> aux = lista;

		for (int i = 1; i < posicao - 1; i++) {
			aux = aux.prox;
		}
		TNo<T> lixo = aux.prox;
		aux.prox = aux.prox.prox;
		return lixo.dado;

	}

	@Override
	public T removerElemento(T valor) throws EstruturaVaziaException,
			ElementoInexistenteException {
		if (isVazia())
			throw new EstruturaVaziaException();
		if (!existe(valor))
			throw new ElementoInexistenteException();
		int posicao = posicaoDoElemento(valor);
		TNo<T> aux = lista;
		for (int i = 1; i < posicao - 1; i++)
			aux = aux.prox;
		TNo<T> lixo = aux.prox;
		aux.prox = aux.prox.prox;
		return lixo.dado;
	}

	@Override
	public boolean existe(T valor) {
		TNo<T> aux = lista;
		for (int i = 1; i <= tamanho(); i++) {
			if (aux.dado == valor || aux.dado.equals(valor)) {
				return true;
			}
			aux = aux.prox;
		}

		return false;
	}

	@Override
	public T elementoDaPosicao(int posicao) throws EstruturaVaziaException,
			PosicaoInvalidaException {
		if(isVazia())
			throw new EstruturaVaziaException();
		if(posicao <1 || posicao>tamanho()){
			throw new PosicaoInvalidaException();
		}
		TNo<T> aux = lista;
		for(int i =1 ; i<=posicao; i++){
			if(i == posicao)
				return aux.dado;
			aux = aux.prox;
		}
		return null;
	}

	@Override
	public int posicaoDoElemento(T valor) throws EstruturaVaziaException,
			ElementoInexistenteException {
		if (isVazia())
			throw new EstruturaVaziaException();
		TNo<T> aux = lista;
		
		for (int i = 1; i <= tamanho(); i++) {
			if (aux.dado == valor || aux.dado.equals(valor))
				return i;
			aux = aux.prox;
		}
		throw new ElementoInexistenteException();
	}

	@Override
	public boolean isCheia() {
		return false;
	}

	@Override
	public boolean isVazia() {
		return (lista == null);
	}

	@Override
	public int tamanho() {
		int tamanho = 0;
		TNo<T> aux = lista;
		while (aux != null) {
			tamanho++;
			aux = aux.prox;
		}
		return tamanho;
	}

	@Override
	public void todosElementos() throws EstruturaVaziaException {
		TNo<T> aux = lista;
		if (isVazia())
			throw new EstruturaVaziaException();

		while (aux.prox != null) {
			System.out.println(aux.dado);
			aux = aux.prox;
		}
		System.out.println(aux.dado);
	}

}
