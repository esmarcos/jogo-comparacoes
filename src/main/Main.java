package main;

import java.util.List;

import main.controler.JogoControler;
import main.model.Jogo;
import main.view.Tela;

public class Main {

	public static void main(String[] args) {
		JogoControler jogoControler = new JogoControler();
		
		
		Tela tela = new Tela();
		tela.mostrarOpcoes();	
		
		
		List<Jogo> jogos = jogoControler.buscarTodos();
		jogos.forEach(jogo -> System.out.println(jogo + "\n-------\n"));
	}
	
	
	
	
	

}
