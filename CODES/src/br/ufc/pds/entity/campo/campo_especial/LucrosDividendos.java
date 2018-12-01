package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class LucrosDividendos extends CampoEspecial implements EfeitoEspecial {

	public LucrosDividendos(int indice) {
		this.listaJogadores = new ArrayList<>();
		this.nome = "Lucros e Dividendos";
		this.indice = indice;
	}

	public void aplicarEfeito(JogadorHumano jogador) {
		jogador.receber(200);
	}

}
