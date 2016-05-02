package listas;

import excecoes.ElementoInexistenteException;
import excecoes.EstruturaCheiaException;
import excecoes.EstruturaVaziaException;
import excecoes.PosicaoInvalidaException;

public class TListaDuplamenteEncadeadaCircular<T> implements TLista<T> {
	TNo<T> lista;

	@Override
	public void inserirNoFinal(T valor) throws EstruturaCheiaException {
		if (isVazia()) {
			inserirNoInicio(valor);
		} else {
			TNo<T> novo = new TNo<T>(valor);
			TNo<T> aux = lista;
			while (aux.prox != lista) {
				aux = aux.prox;
			}
			novo.prox = lista;
			lista.ante = novo;
			novo.ante = aux;
			aux.prox = novo;
		}
	}

	@Override
	public void inserirNoInicio(T valor) throws EstruturaCheiaException {
		TNo<T> novo = new TNo<T>(valor);
		if (isVazia()) {
			lista = novo;
			novo.prox = novo;
			novo.ante = novo;

		} else {
			TNo<T> aux = lista;
			while (aux.prox != lista) {
				aux = aux.prox;
			}
			novo.prox = lista;
			aux.prox = novo;
			novo.ante = aux;
			lista = novo;
			lista.prox.ante = novo;
		}

	}

	@Override
	public void inserirNumaPosicao(T valor, int posicao)
			throws EstruturaCheiaException, PosicaoInvalidaException {
		if (posicao < 1 || posicao > tamanho()) {
			throw new PosicaoInvalidaException();
		}
		if (posicao == 1) {
			inserirNoInicio(valor);
		} else if (posicao == tamanho()) {
			inserirNoFinal(valor);
		} else {
			TNo<T> aux = lista;
			for (int i = 1; i < posicao - 1; i++) {
				aux = aux.prox;
			}
			TNo<T> novo = new TNo<T>(valor);
			TNo<T> temp = aux.prox;
			aux.prox = novo;
			novo.ante = aux;
			novo.prox = temp;
			temp.ante = novo;
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
		aux.prox = lista;
		lista.ante = aux;
		return lixo.dado;
	}

	@Override
	public T removerDoInicio() throws EstruturaVaziaException {
		if (isVazia()) {
			throw new EstruturaVaziaException();
		}
		TNo<T> aux = lista;
		while(aux.prox != lista){
			aux = aux.prox;
		}
		TNo<T> lixo = lista;
		lista = lista.prox;
		aux.prox = lista;
		lista.ante = aux;
		return lixo.dado;
	}

	@Override
	public T removerDaPosicao(int posicao) throws EstruturaVaziaException,
			PosicaoInvalidaException {
		if(isVazia()){
			throw new EstruturaVaziaException();
		}
		if(posicao<1 || posicao>tamanho()){
			throw new PosicaoInvalidaException();
		}
		if(posicao == 1){
			return removerDoInicio();
		}else if(posicao==tamanho()){
			return removerDoFinal();
		}else{
			TNo<T> aux = lista;
			for(int i =1 ;i<posicao-1;i++){
				aux = aux.prox;
			}
			TNo<T> lixo = aux.prox;
			TNo<T> temp = aux.prox.prox;
			aux.prox =temp;
			temp.ante = aux;
			return lixo.dado;
		}
	}

	@Override
	public T removerElemento(T valor) throws EstruturaVaziaException,
			ElementoInexistenteException, PosicaoInvalidaException {
		if(isVazia()){
			throw new EstruturaVaziaException();
		}
		if(!existe(valor)){
			throw new ElementoInexistenteException();
		}
		
		return null;
	}

	@Override
	public boolean existe(T valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T elementoDaPosicao(int posicao) throws EstruturaVaziaException,
			PosicaoInvalidaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int posicaoDoElemento(T valor) throws EstruturaVaziaException,
			ElementoInexistenteException {
		
		return 0;
	}

	@Override
	public boolean isCheia() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVazia() {
		return (lista == null);
	}

	@Override
	public int tamanho() {
		int cont = 0;
		if (isVazia())
			return cont;
		TNo<T> aux = lista;
		while (aux.prox != lista) {
			cont++;
			aux = aux.prox;
		}
		return cont + 1;
	}

	// opcional somente imprimi
	@Override
	public void todosElementos() throws EstruturaVaziaException {
		TNo<T> aux = lista;
		while (aux.prox != lista) {
			System.out.println(aux.dado);
			aux = aux.prox;
		}
		System.out.println(aux.dado);
	}

	// opcional somente imprimi

	public void imprimiNo() {
		TNo<T> aux = lista;
		while (aux.ante != lista) {
			System.out.println(aux.dado);
			aux = aux.ante;
		}
		System.out.println(aux.dado);
	}

}
