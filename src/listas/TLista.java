package listas;

import excecoes.ElementoInexistenteException;
import excecoes.EstruturaCheiaException;
import excecoes.EstruturaVaziaException;
import excecoes.PosicaoInvalidaException;

public interface TLista <T>{

	public void inserirNoFinal(T valor) throws EstruturaCheiaException;
	
	public void inserirNoInicio(T valor) throws EstruturaCheiaException;
	
	public void inserirNumaPosicao(T valor, int posicao) throws EstruturaCheiaException, PosicaoInvalidaException;
	
	public T removerDoFinal() throws EstruturaVaziaException;
	
	public T removerDoInicio() throws EstruturaVaziaException;
	
	/**
	 * 
	 * @param posicao
	 * @return o elemento removido
	 */
	public T removerDaPosicao(int posicao) throws EstruturaVaziaException, PosicaoInvalidaException;
	
	/**
	 * 
	 * @param valor
	 * @return o elemento removido
	 * @throws PosicaoInvalidaException 
	 */
	public T removerElemento(T valor) throws EstruturaVaziaException, ElementoInexistenteException, PosicaoInvalidaException;
	
	public boolean existe(T valor);
	
	public T elementoDaPosicao(int posicao) throws EstruturaVaziaException, PosicaoInvalidaException;
	
	public int posicaoDoElemento(T valor) throws EstruturaVaziaException, ElementoInexistenteException;
	
	public boolean isCheia();
	
	public boolean isVazia();
	
	public int tamanho();
	
	public void todosElementos() throws EstruturaVaziaException;
	
	
}
