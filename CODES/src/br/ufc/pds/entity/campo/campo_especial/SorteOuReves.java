package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.controller.ControlSorteOuReves;
import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.carta.Carta;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class SorteOuReves extends CampoEspecial implements EfeitoEspecial {

	private ControlSorteOuReves controlSorteOuReves = ControlSorteOuReves.getInstance();

	public SorteOuReves(int indice) {
		super("Sorte ou Revés", indice);
		this.controlSorteOuReves.criarCartas();
	}

	public void aplicarEfeito(JogadorHumano jogador) {
		Carta sorteda = this.controlSorteOuReves.sortearCarta();
		System.out.println("Carta " + sorteda.getTitulo() + "\nDescricao: " + sorteda.getDescricao());
		sorteda.acao(jogador);
	}

}
