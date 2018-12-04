package br.ufc.pds.entity.carta;

import br.ufc.pds.entity.jogador.JogadorHumano;
import br.ufc.pds.view.MensagemSorteReves;

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

	public void showCarta(String titulo, String mensagem, String acao) {
		MensagemSorteReves ms = new MensagemSorteReves(titulo, mensagem, acao);
		ms.setVisible(true);
	}
}
