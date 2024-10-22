package br.ufc.pds.model.carta;

import br.ufc.pds.model.jogador.Banco;
import br.ufc.pds.model.jogador.JogadorHumano;

public class Sorte extends CartaSorteOuReves {
	public Sorte(String titulo, String descricao, float valor) {
		super(titulo, descricao, valor);
	}

	public void acao(JogadorHumano jogador) {
		Banco.getInstance().pagar(this.valor);
		jogador.receber(this.valor);
		this.showCarta(this.titulo, this.descricao, jogador.getNome() + " recebeu R$ " + this.valor);
	}

}
