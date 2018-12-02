package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class PontoDePartida extends CampoEspecial implements EfeitoEspecial {

	public PontoDePartida(int indice) {
		super("Ponto de Partida", indice);
	}

	public void aplicarEfeito(JogadorHumano jogador) {
		Banco.getInstance().pagar(200);
		jogador.receber(200);
	}

}
