package principal;

import excecoes.ElementoInexistenteException;
import excecoes.EstruturaCheiaException;
import excecoes.EstruturaVaziaException;
import excecoes.PosicaoInvalidaException;
import listas.TListaDuplamenteEncadeadaCircular;

public class TestEncadeadoComDescritor {
	public static void main(String[] args) throws EstruturaCheiaException,
			EstruturaVaziaException, PosicaoInvalidaException, ElementoInexistenteException {
		TListaDuplamenteEncadeadaCircular<Integer> descritor = new TListaDuplamenteEncadeadaCircular<Integer>();
		descritor.inserirNoInicio(9);
		descritor.inserirNoInicio(10);
		descritor.inserirNoInicio(3);
		descritor.inserirNoInicio(1);
		descritor.inserirNoFinal(11);
		descritor.inserirNumaPosicao(30, 3);
		System.out.println("---------------------------");
		descritor.todosElementos();
		System.out.println("REMOVIDO: "+descritor.removerDaPosicao(3));
		System.out.println("---------------------------");
		descritor.imprimiNo();
		System.out.println("---------------------------");
		descritor.todosElementos();
		System.out.println("TAM: "+ descritor.tamanho());
	}
}
