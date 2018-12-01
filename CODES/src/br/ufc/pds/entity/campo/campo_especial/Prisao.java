package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Prisao extends CampoEspecial implements EfeitoEspecial {

	public Prisao(int indice) {
		this.listaJogadores = new ArrayList<>();
		this.nome = "Prisão";
		this.indice = indice;
	}

	public void aplicarEfeito(JogadorHumano jogador) {

	}

}
