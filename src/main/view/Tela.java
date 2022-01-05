package main.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.controler.JogoControler;
import main.model.Jogo;
import main.model.JogoDatabase;

public class Tela {
	
	
	private JogoControler jogoControler = new JogoControler();
	private Scanner sc = new Scanner(System.in);
	
	
	
	
	public void mostrarOpcoes() {
		
		while(true) {
			
			
			System.out.println("1 - Adicionar jogo;");
			System.out.println("2 - Remover jogo;");
			System.out.println("3 - Consultar lista de jogos;");
			System.out.print("Digite o número da opção: ");
			int numero = sc.nextInt();
		
			switch(numero) {
				case 1:
					int pontos = this.pedirNumero("Digite o numero de pontos: ");
					jogoControler.adicionarJogo(pontos);
					System.out.println("Jogo Adicionado. ");
					break;
				case 2:
					int numeroDoJogo = this.pedirNumero("Digite o número do jogo: ");
					jogoControler.remover(numeroDoJogo);
					System.out.println("Numero do jogo removido. ");
					break;
				case 3:
					List<Jogo> consultarJogos = jogoControler.buscarTodos();
					this.mostrarLista(consultarJogos); 
					
					break;
				default:
					System.out.println("Opção inválida");
			}
		}
		
	}

	private int pedirNumero(String pergunta) {
		System.out.println(pergunta);
		int pontos = sc.nextInt();
		return pontos;
		
	}
	
	private void mostrarLista(List<Jogo> jogos){
		System.out.println("Jogo | Pontos | RecMax | RecMin");
		for ( Jogo jogo : jogos) {
			System.out.println("" + jogo.getNumero() +  "        " + jogo.getPontos() + "         " + jogo.getRecordMaximo() + "         " + jogo.getRecordMinimo());
		}
	}
}
