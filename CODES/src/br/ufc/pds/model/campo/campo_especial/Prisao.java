package br.ufc.pds.model.campo.campo_especial;

import br.ufc.pds.model.campo.EfeitoEspecial;
import br.ufc.pds.model.jogador.JogadorHumano;

public class Prisao extends CampoEspecial implements EfeitoEspecial {

	public Prisao(int indice) {
		super("Prisão", indice, 21, 638);
	}

	public void aplicarEfeito(JogadorHumano jogador) {

	}

}