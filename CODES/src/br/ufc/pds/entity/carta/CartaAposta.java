package br.ufc.pds.entity.carta;

import br.ufc.pds.controller.ControlBancoImobiliario;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.Map;

public class CartaAposta extends Carta {

	private float valor;

	public CartaAposta(String titulo, String descricao, float valor) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.isCoringa = false;
	}

	public void acao(JogadorHumano jogador) {
		Map<Integer, JogadorHumano> listaJogadores = ControlBancoImobiliario.getInstance().getJogadoresAtivos();
		listaJogadores.forEach((key, value) -> {
			if (jogador != value) {
				value.pagar(this.valor);
				jogador.receber(this.valor);
				System.out.println(jogador.getNome() + " recebeu R$" + this.valor + " de " + value.getNome());
			}
		});
		this.showCarta(this.titulo, this.descricao, jogador.getNome() + " Recebeu R$ 50 de cada Jogador.");
	}
}
