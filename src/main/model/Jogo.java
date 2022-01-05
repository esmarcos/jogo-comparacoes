package main.model;

public class Jogo {
	
	private int pontos;
	private int recordMaximo;
	private int recordMinimo;
	private int numero;
	
	public Jogo(int pontos, int recordMaximo, int recordMinimo, int numero) {
		this.pontos = 0;
		this.recordMaximo = 0;
		this.recordMinimo = 0;
		this.numero = 0;
	
	}

	public Jogo() {
		this.recordMaximo = 0;
		this.recordMinimo = 0;
	}

	@Override
	public String toString() {
		return "Jogo [pontos=" + pontos + ", recordMaximo=" + recordMaximo + ", recordMinimo=" + recordMinimo
				+ ", numero=" + numero + "]";
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getRecordMaximo() {
		return recordMaximo;
	}

	public void setRecordMaximo(int recordMaximo) {
		this.recordMaximo = recordMaximo;
	}

	public int getRecordMinimo() {
		return recordMinimo;
	}

	public void setRecordMinimo(int recordMinimo) {
		this.recordMinimo = recordMinimo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	

}
