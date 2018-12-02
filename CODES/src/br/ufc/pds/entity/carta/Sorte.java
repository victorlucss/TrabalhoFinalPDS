package br.ufc.pds.entity.carta;

import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.JogadorHumano;

public class Sorte extends CartaSorteOuReves {


	public Sorte(String titulo, String descricao, float valor) {
		super(titulo, descricao, valor);
	}

	public void acao(JogadorHumano jogador) {
		Banco.getInstance().pagar(this.valor);
		jogador.receber(this.valor);
		System.out.println(jogador.getNome() + " recebeu R$ " + this.valor);
	}

}
