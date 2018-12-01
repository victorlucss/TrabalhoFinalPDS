package br.ufc.pds.entity.carta;

import br.ufc.pds.entity.jogador.JogadorHumano;

public abstract class Carta {

	private String titulo;

	private String descricao;

	private boolean isCoringa;

	public void acao(JogadorHumano jogador) {

	}

}
