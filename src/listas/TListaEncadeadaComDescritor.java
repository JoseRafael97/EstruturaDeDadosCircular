package listas;

import excecoes.ElementoInexistenteException;
import excecoes.EstruturaCheiaException;
import excecoes.EstruturaVaziaException;
import excecoes.PosicaoInvalidaException;

public class TListaEncadeadaComDescritor<T> implements TLista<T> {
	private int tam = 0;
	private TNo<T> ultimo;
	private TNo<T> primeiro;

	@Override
	public void inserirNoFinal(T valor) throws EstruturaCheiaException {
		TNo<T> novo = new TNo<T>(valor);
		
		if (isVazia()) {
			primeiro = novo;
			ultimo = novo;
		} else {
			ultimo.prox = novo;
			novo.ante = ultimo;
			novo.prox = null;
			ultimo = novo;
		}
		tam++;
	}

	@Override
	public void inserirNoInicio(T valor) throws EstruturaCheiaException {
		TNo<T> novo = new TNo<T>(valor);
		if (isVazia()) {
			primeiro = novo;
			ultimo = novo;

		} else {
			novo.prox = primeiro;
			primeiro.ante = novo;
			primeiro = novo;
		}
		tam++;
	}

	@Override
	public void inserirNumaPosicao(T valor, int posicao)
			throws EstruturaCheiaException, PosicaoInvalidaException {
		if (posicao < 1 || posicao > tam) {
			throw new PosicaoInvalidaException();
		}
		TNo<T> aux = primeiro;
		if (posicao == 1) {
			inserirNoInicio(valor);
		
		} else if (posicao == tam) {
			inserirNoFinal(valor);
		
		} else {
			for (int i = 1; i < posicao - 1; i++) {
				aux = aux.prox;
			}
			TNo<T> novo = new TNo<T>(valor);
			TNo<T> temp = aux.prox;
			temp.ante = novo;
			novo.prox = temp;
			novo.ante = aux;
			aux.prox = novo;
			tam++;
		}
	}

	@Override
	public T removerDoFinal() throws EstruturaVaziaException {
		if (isVazia()) {
			throw new EstruturaVaziaException();
		}
		TNo<T> aux = ultimo.ante;
		TNo<T> lixo = aux.prox;
		aux.prox = null;
		ultimo = aux;
		tam--;
		return lixo.dado;
	}

	@Override
	public T removerDoInicio() throws EstruturaVaziaException {
		if (isVazia())
			throw new EstruturaVaziaException();
		TNo<T> aux = primeiro;
		primeiro = aux.prox;
		primeiro.ante = null;
		tam--;
		return aux.dado;
	}

	@Override
	public T removerDaPosicao(int posicao) throws EstruturaVaziaException,
			PosicaoInvalidaException {
		if (isVazia()) {
			throw new EstruturaVaziaException();
		}
		if (posicao < 1 || posicao > tam) {
			throw new PosicaoInvalidaException();
		}
		if (posicao == 1) {
			return removerDoInicio();
		}
		if (posicao == tam) {
			return removerDoFinal();
		}
		TNo<T> aux = primeiro;
		for (int i = 1; i < posicao - 1; i++) {
			aux = aux.prox;
		}
		TNo<T> lixo = aux.prox;
		aux.prox = aux.prox.prox;
		aux.prox.ante = aux;
		tam--;
		return lixo.dado;
	}

	@Override
	public T removerElemento(T valor) throws EstruturaVaziaException,
			ElementoInexistenteException, PosicaoInvalidaException {
		if (isVazia())
			throw new EstruturaVaziaException();
		if (!existe(valor))
			throw new ElementoInexistenteException();
		int posicao = posicaoDoElemento(valor);

		if (posicao == 1)
			return removerDoInicio();
		if (posicao == tam)
			return removerDoFinal();

		return removerDaPosicao(posicao);
	}

	@Override
	public boolean existe(T valor) {
		TNo<T> aux = primeiro;
		for (int i = 1; i <= tam; i++) {
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
		TNo<T> aux = primeiro;
		for(int i =1 ; i<=posicao-1; i++){
			aux = aux.prox;
		}
		return aux.dado;
	}

	@Override
	public int posicaoDoElemento(T valor) throws EstruturaVaziaException,
			ElementoInexistenteException {
		int cont = 0;
		TNo<T> aux = primeiro;
		for (int i = 1; i <= tam; i++) {
			if (aux.dado == valor || aux.dado.equals(valor)) {
				return cont;
			}
			aux = aux.prox;
			cont++;
		}
		return 0;
	}

	@Override
	public boolean isCheia() {
		return false;
	}

	@Override
	public boolean isVazia() {
		return (tam == 0);
	}

	@Override
	public int tamanho() {
		return tam;
	}
//opcional somente imprimi
	@Override
	public void todosElementos() throws EstruturaVaziaException {
		TNo<T> aux = primeiro;
		for (int i = 1; i <= tam; i++) {
			System.out.println(aux.dado);
			aux = aux.prox;
		}
	}
	//opcional somente imprimi

	public void imprimiNo(){
		TNo<T> aux = ultimo;
		while(aux.ante != null){
			System.out.println(aux.dado);
			aux = aux.ante;
		}
		System.out.println(aux.dado);
	}
}
