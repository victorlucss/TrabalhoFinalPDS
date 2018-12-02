package br.ufc.pds.entity.carta;

import br.ufc.pds.entity.jogador.JogadorHumano;

public abstract class Carta {

	protected String titulo;
	protected String descricao;
	protected boolean isCoringa;

	public abstract void acao(JogadorHumano jogador);

	public String getTitulo() {
		return this.titulo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public boolean isCoringa() {
		return this.isCoringa;
	}
}
