package listas;

import excecoes.ElementoInexistenteException;
import excecoes.EstruturaCheiaException;
import excecoes.EstruturaVaziaException;
import excecoes.PosicaoInvalidaException;

public class TListaEncadeadaCircular<T> implements TLista<T>{
	
	private TNo<T> lista;
	
	@Override
	public void inserirNoFinal(T valor) throws EstruturaCheiaException {
		
		TNo<T> novo = new TNo<T>(valor);
		
		if(isVazia()){
			novo.prox = novo;
			lista = novo;
		
		}else{
			TNo<T> aux = lista;
			
			while(aux.prox != lista ){
				aux = aux.prox;
			}
			
			novo.prox = lista;
			aux.prox = novo;
		}
	}

	@Override
	public void inserirNoInicio(T valor) throws EstruturaCheiaException {
		TNo<T> novo = new TNo<T>(valor);
		TNo<T> aux = lista;
		
		if(isVazia()){
			novo.prox = novo;
			lista = novo;
			
		}else{
			
			while(aux.prox != lista){
				aux = aux.prox;
			}
			
			aux.prox = novo;
			novo.prox = lista;
			lista = novo;
		}
	}

	@Override
	public void inserirNumaPosicao(T valor, int posicao)
			throws EstruturaCheiaException, PosicaoInvalidaException {
		int tamanho = tamanho();
		
		if(posicao >(tamanho+1))
			throw new PosicaoInvalidaException();
		
		if (posicao < 1)
			throw new PosicaoInvalidaException();
		
		if((posicao-1) == tamanho)
			inserirNoFinal(valor);
		
		else if(posicao == 1)
			inserirNoInicio(valor);
		
		else{
			TNo<T> aux = lista;
		
			int i;
			for(i = 1; i< posicao-1; i++){
				aux = aux.prox;
			}
			TNo<T> novo = new TNo<T>(valor);
			novo.prox = aux.prox;
			aux.prox = novo;
		}
	}

	@Override
	public T removerDoFinal() throws EstruturaVaziaException {
		if(isVazia())
			throw new EstruturaVaziaException();
		
		int tamanho = tamanho();
		
		if(tamanho == 1)
			removerDoInicio();
		
		TNo<T> aux = lista;
		
		while (aux.prox.prox != lista) {
			aux = aux.prox;
		}
		
		TNo<T> lixo = aux.prox;
		aux.prox = lista;
		return lixo.dado;
	}

	@Override
	public T removerDoInicio() throws EstruturaVaziaException {
		if(isVazia())
			throw new EstruturaVaziaException();
		
		TNo<T> aux = lista;
		
		while(aux.prox != lista){
			aux = aux.prox;
		}
		
		TNo<T> lixo = lista;
		aux.prox = lista.prox;
		lista = lista.prox;
		
		return lixo.dado;
	}

	@Override
	public T removerDaPosicao(int posicao) throws EstruturaVaziaException,
			PosicaoInvalidaException {
		
		if(isVazia())
			throw new EstruturaVaziaException();
		
		int tamanho = tamanho();
		
		if (posicao < 1 || posicao > tamanho)
			throw new PosicaoInvalidaException();
		
		
		TNo<T> aux = lista;
	
		if(posicao == tamanho)
			return removerDoFinal();
		
		if(posicao == 1)
			return removerDoInicio();
		
		for(int i = 1 ; i<posicao-1 ; i++){
			aux = aux.prox;
		}
		
		TNo<T> lixo = aux.prox;
		aux.prox = aux.prox.prox;
		return lixo.dado;
	
	}

	@Override
	public T removerElemento(T valor) throws EstruturaVaziaException,
			ElementoInexistenteException {
		if(isVazia())
			throw new EstruturaVaziaException();
		
		if(!existe(valor))
			throw new ElementoInexistenteException();
		
		TNo<T> aux = lista;
		int cont = posicaoDoElemento(valor);
		
		if(cont == tamanho())
			return removerDoFinal();
		
		if(cont == 1)
			return removerDoInicio();
		
		for(int i = 1 ; i<cont-1 ; i++){
			aux = aux.prox;
		}
		
		TNo<T> lixo = aux.prox;
		aux.prox = aux.prox.prox;
		return lixo.dado;
		
	}

	@Override
	public boolean existe(T valor) {
		TNo<T> aux = lista;
		
		while(aux.prox != lista){
			if(aux.dado == valor || aux.dado.equals(valor)){
				return true;
			}
			aux = aux.prox;
		}
		if(aux.dado == valor || aux.dado.equals(valor))
			return true;
		
		return false;
	}

	@Override
	public T elementoDaPosicao(int posicao) throws EstruturaVaziaException, PosicaoInvalidaException {

		if(isVazia())
			throw new EstruturaVaziaException();
		
		if (posicao < 1 || posicao > tamanho())
			throw new PosicaoInvalidaException();
		
		TNo<T> aux = lista;		
		
		for (int i = 1 ; i<posicao ; i++){
			aux = aux.prox;
		}
		return aux.dado;
	}

	@Override
	public int posicaoDoElemento(T valor) throws EstruturaVaziaException,
			ElementoInexistenteException {
		
		if(isVazia())
			throw new EstruturaVaziaException();
		
		int cont = 1;
		TNo<T> aux = lista;
			
		while(aux.prox != lista){
			
			if(aux.dado == valor || aux.dado.equals(valor))
				return cont;
				
			cont++;
			aux = aux.prox;
			
		}
		if(aux.dado == valor || aux.dado.equals(valor))
			return cont++;
		
		
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
		int cont = 0;
		TNo<T> aux = lista;
		
		if(isVazia()){
			return cont;
		
		}else{
			while(aux.prox != lista){
				cont++;
				aux = aux.prox;
			}
		
			return cont+1;
		}
	}
	//metodo utilizado somente pra imprimir os valores não faz parte da interface;
	public void todosElementos() throws EstruturaVaziaException{
		TNo<T> aux = lista;
		if(isVazia())
			throw new EstruturaVaziaException();
		
		while(aux.prox != lista){
			System.out.println(aux.dado);
			aux = aux.prox;
		}
		System.out.println(aux.dado);
	}

	public TNo<T> getLista() {
		return lista;
	}

	public void setLista(TNo<T> lista) {
		this.lista = lista;
	}
	
	

}	