package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class PontoDePartida extends CampoEspecial implements EfeitoEspecial {

	public PontoDePartida(int indice) {
		this.listaJogadores = new ArrayList<>();
		this.nome = "Ponto de Partida";
		this.indice = indice;
	}

	public void aplicarEfeito(JogadorHumano jogador) {
		jogador.receber(200);
	}

}
