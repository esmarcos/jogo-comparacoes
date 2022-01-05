package main.controler;

import main.model.JogoDatabase;

import java.util.List;

import main.model.Jogo;

public class JogoControler {
	
	private final JogoDatabase jogoDatabase = new JogoDatabase();
	
	public void adicionarJogo(int pontos) {
		Jogo jogo = new Jogo();
		jogo.setPontos(pontos);
		int numeroJogos = jogoDatabase.contarTodos();
		jogo.setNumero(numeroJogos + 1);
		this.calcularRecordes(jogo);
		jogoDatabase.salvar(jogo);	
	}
	
	private void calcularRecordes(Jogo jogo) {
		int maiorPontuacao = jogoDatabase.buscarMaiorPontuacao();		
		int menorPontuacao = jogoDatabase.buscarMenorPontuacao();
		Jogo ultimoJogo = jogoDatabase.buscarUltimoJogo();
		if (ultimoJogo != null) {			
			if (jogo.getPontos() > maiorPontuacao) {
				int quantidadeRecordeMaximo = ultimoJogo.getRecordMaximo();
				jogo.setRecordMaximo(quantidadeRecordeMaximo + 1);
			} 
			else {
				jogo.setRecordMaximo(ultimoJogo.getRecordMaximo());
			}
			if (jogo.getPontos() < menorPontuacao) {
				int quantidadeRecordeMinimo = ultimoJogo.getRecordMinimo();
				jogo.setRecordMinimo(quantidadeRecordeMinimo + 1);
			}
			else {
				jogo.setRecordMinimo(ultimoJogo.getRecordMinimo());
			}
		} else {
			jogo.setRecordMaximo(0);
			jogo.setRecordMinimo(0);
		}
	}
	
	public List<Jogo> buscarTodos() {
		return jogoDatabase.buscarTodos();
	}
	public void remover(int numero) {
		List<Jogo> recalculaveis= jogoDatabase.buscarNumerosMaioresQueORemovido(numero);
		jogoDatabase.remover(numero);
		this.removerDesatulizados(recalculaveis);
		
	}
	public void removerDesatulizados(List<Jogo> recalculaveis) {
		for  (Jogo jogo : recalculaveis ) {
			int numeroJogo = jogo.getNumero();
			jogoDatabase.remover(numeroJogo);
			this.recalcular(recalculaveis);
			
			
		}
	}
	public void recalcular(List<Jogo> recalculaveis) {
		for  (Jogo jogo : recalculaveis ) {
		int pontos = jogo.getPontos();
		this.adicionarJogo(pontos);
		}
	}
		
		
	
}
