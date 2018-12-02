package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.controller.ControlSorteOuReves;
import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class SorteOuReves extends CampoEspecial implements EfeitoEspecial {

	private ControlSorteOuReves controlSorteOuReves = ControlSorteOuReves.getInstance();

	public SorteOuReves(int indice) {
		this.listaJogadores = new ArrayList<>();
		this.nome = "Sorte ou Revés";
		this.indice = indice;
	}

	public void aplicarEfeito(JogadorHumano jogador) {

	}

}
