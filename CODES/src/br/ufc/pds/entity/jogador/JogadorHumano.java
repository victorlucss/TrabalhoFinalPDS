package br.ufc.pds.entity.jogador;

import br.ufc.pds.pojo.Peca;
import br.ufc.pds.pojo.Dado;
import br.ufc.pds.entity.campo.Campo;

public class JogadorHumano extends Jogador {

	private int id;
	private String nome;
	private Peca peca;
	private Dado[] dados;

	public JogadorHumano(int id, String nome, Peca peca, Dado[] dados) {
		this.id = id;
		this.nome = nome;
		this.peca = peca;
		this.dados = dados;
	}

	public void pagar(float valor) {

	}

	public void receber(float valor) {

	}

	public void comprarPropiedade() {

	}

	public void venderPropriedade() {

	}

	public void lancarDados() {

	}

	public Campo obterLocalizacao() {
		return null;
	}

}
