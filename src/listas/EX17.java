package listas;

import excecoes.EstruturaCheiaException;

public class EX17 {
	public int menor(TListaEncadeadaCircular<Integer> lista) {
		if (lista == null) {
			return 0;
		} else {
			int menor = 0;
			TNo<Integer> aux = lista.getLista();
			for (int i =1 ; i<lista.tamanho()-1; i++) {
				if (aux.dado < aux.prox.dado) {
					menor = aux.dado;
				} else {
					menor = aux.prox.dado;
				}
				aux = aux.prox;
			}
			
			return menor;
		}

	}
	
	public static void main(String[] args) throws EstruturaCheiaException {
		TListaEncadeadaCircular<Integer> lista = new TListaEncadeadaCircular<Integer>();
		lista.inserirNoInicio(2);
		lista.inserirNoInicio(-1);
		lista.inserirNoInicio(0);
		lista.inserirNoInicio(23);
		
		EX17 ex = new EX17();
		System.out.println(ex.menor(lista));

	}
}
