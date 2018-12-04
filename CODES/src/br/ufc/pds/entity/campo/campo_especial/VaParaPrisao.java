package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.controller.ControlBancoImobiliario;
import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class VaParaPrisao extends CampoEspecial implements EfeitoEspecial {

	public VaParaPrisao(int indice) {
		super("Vá Para Prisão", indice, 640, 15);
	}

	public void aplicarEfeito(JogadorHumano jogador) {
		ControlBancoImobiliario.getInstance().prenderJogador(jogador);
		String titulo = this.nome;
		String acao = jogador.getNome()+" foi Preso!";

		this.showMensagem(titulo, acao);
	}

}
