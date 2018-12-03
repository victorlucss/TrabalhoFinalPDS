package br.ufc.pds.pojo;

import br.ufc.pds.entity.campo.Campo;

public class Peca {

	private String cor;
	private Campo localizacao;

	public Peca(String cor, Campo localizacao) {
		this.cor = cor;
		this.localizacao = localizacao;
	}

	public Campo obterLocalizacao() {
		return this.localizacao;
	}

	public void mudarLocalizacao(Campo campo) {
		this.localizacao = campo;
	}

	public String getCor() {
		return cor;
	}
}
