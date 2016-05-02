package principal;

import excecoes.ElementoInexistenteException;
import excecoes.EstruturaCheiaException;
import excecoes.EstruturaVaziaException;
import excecoes.PosicaoInvalidaException;
import listas.TListaEncadeadaSimples;

public class TestEncadeadaSimples {
	public static void main(String[] args) throws EstruturaCheiaException,
			PosicaoInvalidaException, EstruturaVaziaException,
			ElementoInexistenteException {
		TListaEncadeadaSimples<String> encadeada = new TListaEncadeadaSimples<String>();
		encadeada.inserirNoInicio("Rafael");
		encadeada.inserirNoFinal("Joao");
		encadeada.inserirNoFinal("Jose");
		encadeada.inserirNoFinal("Feitosa");
		encadeada.inserirNoFinal("Marcelo");
		encadeada.inserirNumaPosicao("Prv", 6);
		encadeada.todosElementos();
		System.out.println("Removido:  " + encadeada.elementoDaPosicao(6));
		System.out.println("_-----------------------------------------_");
		encadeada.todosElementos();
	}
}
