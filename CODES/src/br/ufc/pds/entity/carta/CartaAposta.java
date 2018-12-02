package br.ufc.pds.entity.carta;

import br.ufc.pds.controller.ControlBancoImobiliario;
import br.ufc.pds.entity.jogador.JogadorHumano;

public class CartaAposta extends Carta {

	private float valor;

	public CartaAposta(String titulo, String descricao, float valor) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.isCoringa = false;
	}

	public void acao(JogadorHumano jogador) {
//		ControlBancoImobiliario.getInstance().getJogadoresAtivos().forEach((key, value) -> {
//			System.out.println(value.+" jogando, saldo: "+value.getContaBancaria().getSaldo() + " Num Propriedades: " + value.getPropriedades().size());
//
//		});
		System.out.println("Implementar Ação!!!");
	}

}
