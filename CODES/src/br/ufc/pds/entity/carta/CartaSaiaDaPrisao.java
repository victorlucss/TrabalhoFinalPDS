package br.ufc.pds.entity.carta;

import br.ufc.pds.controller.ControlBancoImobiliario;
import br.ufc.pds.entity.jogador.JogadorHumano;

public class CartaSaiaDaPrisao extends Carta {

	public CartaSaiaDaPrisao(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.isCoringa = true;
	}

	public void acao(JogadorHumano jogador) {
		if(ControlBancoImobiliario.getInstance().getJogadoresPresos().containsValue(jogador)) {
			ControlBancoImobiliario.getInstance().soltarJogador(jogador);
			//System.out.println(jogador.getNome() + " foi solto da Prisão.");
			this.showCarta(this.titulo, this.descricao, jogador.getNome() + " foi solto da Prisão.");
		} else {
			jogador.setCartaPrisao(this);
			//System.out.println(jogador.getNome() + " guardou a carta de 'Saída Livre da Prisão'");
			this.showCarta(this.titulo, this.descricao, jogador.getNome() + " ganhou: 'Saída Livre da Prisão'");
		}
	}

}
