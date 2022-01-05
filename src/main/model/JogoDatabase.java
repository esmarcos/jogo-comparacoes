package main.model;

import java.util.ArrayList;
import java.util.List;

public class JogoDatabase {

	private List<Jogo> jogos = new ArrayList<>();
	
	
	/**
	 * Salvar os jogos no banco de dados.
	 *  
	 * @param jogo
	 * @return jogo
	 */
	public Jogo salvar(Jogo jogo) {
		this.jogos.add(jogo);
		return jogo;
	}

	/**
 	* Remove um jogo de acordo com o numero do jogo.
 	* 
	* @param numero Numero do jogo
	*/
	public void remover(int numero) {
		int i = 0;
		while (i < this.jogos.size()) {
			Jogo jogo = this.jogos.get(i);
			if (numero == jogo.getNumero()) {
				this.jogos.remove(jogo);
				break;
			}
			i++;
		}
	}

	/**
	 * Vai listar todos os jogos.
	 * 
	 * @return A lista de jogos.
	 */
	public List<Jogo> buscarTodos() {
		return this.jogos;
	}
	
	/**
	 * Buscar a maior pontuação e comparar com o novo jogo para cehcar se a um novo recorde.
	 * 
	 * @return A maior pontuação.
	 */
	public int buscarMaiorPontuacao() {
		int maior = 0;
		for(Jogo jogo : this.jogos) {
			if(jogo.getPontos() > maior) {
				maior = jogo.getPontos();
			}
		}
		return maior;
	}

	/**
	 * Buscar a menor pontuação e comparar com o novo jogo para cehcar se a um novo recorde.
	 * 
	 * @return A menor puntuação.
	 */
	public int buscarMenorPontuacao() {
		int menor = Integer.MAX_VALUE;
		for(Jogo jogo : this.jogos) {
			if(jogo.getPontos() < menor) {
				menor = jogo.getPontos();
			}
		}
		return menor;
	}
	
	/**
	 * Conta todos elementos da lista.
	 * 
	 * @return O numero de elementos na lista.
	 */
	public int contarTodos() {
		return this.jogos.size();
	}
	
	/**
	 *  Busca o ultimo jogo realizado.
	 *  
	 * @return O ultimo jogo e se n tiver um jogo anterior retorna nulo.
	 */
	public Jogo buscarUltimoJogo() {
		int numeroJogos = this.contarTodos();
		if (numeroJogos > 0) {
			return this.jogos.get(numeroJogos - 1);						
		}
		return null;
	}
	
	/**
	 *  Ira checar se o numero jo jogo é maior que o numero do parametro.
	 *  
	 * @param numero
	 * @return Uma lista só com numeros maiores que o numero parametro. 
	 */
	public List<Jogo> buscarNumerosMaioresQueORemovido(int numero){
		List<Jogo> nljogos = new ArrayList<>();
		for (Jogo jogo : this.jogos ) {
			if (jogo.getNumero() > numero) {
				nljogos.add(jogo);
			}
		}return nljogos;
	}
}