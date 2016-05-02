package principal;

import java.util.Scanner;







import excecoes.ElementoInexistenteException;
import excecoes.EstruturaCheiaException;
import excecoes.EstruturaVaziaException;
import excecoes.PosicaoInvalidaException;
import listas.TLista;
import listas.TListaEncadeadaCircular;

public class EncadeadaCirculaTest {


	public static void main(String[] args) throws PosicaoInvalidaException {
		
		Scanner ler = new Scanner(System.in);
		boolean entrar = true;
		
		TLista<String> lista = new TListaEncadeadaCircular<String>();
		
		do{
			System.out.println("1 - Inserir No Final"+"\n"+"2 - Inserir no Inicio"+
			"\n"+ "3 - Inserir numa posição "+"\n"+ "4 - Remover do Final"+"\n"+ "5 - Remover do Inicio"+ 
						"\n"+ "6 - Remover da Posição" + "\n"+ "7 - Remover Elemento"+ "\n"
			+"8 - Verificar se Elemento existe"+ "\n"+"9 - Elemento da posição"+ "\n"+
					"10 - Posição do elemento"+"\n"+"11 - Tamanho"+ "\n"+ "12 - Imprimir Lista"+"\n"+ "13 - Sair");
			
			System.out.print("Escolha uma opcão: ");
			String opcao = ler.nextLine();
						
			if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("7") || opcao.equals("8") || opcao.equals("10")){
				System.out.print("Digite o  valor a ser inserido: ");
				String valor = ler.nextLine();
				if(opcao.equals("1")){
					try {
						lista.inserirNoFinal(valor);
					} catch (EstruturaCheiaException e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				}if(opcao.equals("2")){
					try {
						lista.inserirNoInicio(valor);
					} catch (EstruturaCheiaException e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				}if(opcao.equals("3")){
					System.out.print("Digite uma posição: ");
					String pos = ler.nextLine();
					int posicao = Integer.parseInt(pos);
					
					try {
						lista.inserirNumaPosicao(valor, posicao);
					} catch (EstruturaCheiaException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					} catch (PosicaoInvalidaException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}if(opcao.equals("7")){
					try {
						System.out.println(lista.removerElemento(valor));
					} catch (EstruturaVaziaException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					} catch (ElementoInexistenteException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}if(opcao.equals("8")){
					System.out.println(lista.existe(valor));
				
				}if(opcao.equals("10")){
					try {
						System.out.println(lista.posicaoDoElemento(valor));
					} catch (EstruturaVaziaException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					} catch (ElementoInexistenteException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
				
				
			}else if(opcao.equals("4")){
				try {
					System.out.println(lista.removerDoFinal());
				} catch (EstruturaVaziaException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
			}else if(opcao.equals("5")){
				try {
					System.out.println(lista.removerDoInicio());
				} catch (EstruturaVaziaException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
			}else if(opcao.equals("6") || opcao.equals("9")){
				System.out.print("Digite uma posição: ");
				String pos = ler.nextLine();
				int posicao = Integer.parseInt(pos);
				
				if(opcao.equals("6")){
					try {
						System.out.println(lista.removerDaPosicao(posicao));
					} catch (EstruturaVaziaException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					} catch (PosicaoInvalidaException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}else if(opcao.equals("9")){
					try {
						System.out.println(lista.elementoDaPosicao(posicao));
					} catch (EstruturaVaziaException e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					} catch (PosicaoInvalidaException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
			
			}else if(opcao.equals("11")){
				System.out.println(lista.tamanho());
			
			}else if(opcao.equals("12")){
				try {
					lista.todosElementos();
				} catch (EstruturaVaziaException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}else if(opcao.equals("13"))
				entrar=false;

			System.out.println("--------------------------------");
		}while(entrar);
			
		
		
	}
	
}
