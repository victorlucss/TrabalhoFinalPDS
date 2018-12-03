package br.ufc.pds.entity.carta;

import br.ufc.pds.controller.ControlBancoImobiliario;
import br.ufc.pds.entity.jogador.JogadorHumano;

public class CartaVaParaPrisao extends Carta {

	public CartaVaParaPrisao(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.isCoringa = false;
	}

	public void acao(JogadorHumano jogador) {
		ControlBancoImobiliario.getInstance().prenderJogador(jogador);
		System.out.println(jogador.getNome()+" foi Preso!");
	}

}