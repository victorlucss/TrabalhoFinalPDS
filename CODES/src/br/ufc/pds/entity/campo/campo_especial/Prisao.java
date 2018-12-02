package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Prisao extends CampoEspecial implements EfeitoEspecial {

	public Prisao(int indice) {
		super("Prisão", indice);
	}

	public void aplicarEfeito(JogadorHumano jogador) {

	}

}
