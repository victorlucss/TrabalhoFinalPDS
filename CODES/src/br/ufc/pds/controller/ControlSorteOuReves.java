package br.ufc.pds.controller;

import br.ufc.pds.entity.carta.Carta;
import br.ufc.pds.entity.carta.Reves;
import br.ufc.pds.entity.carta.Sorte;

import java.util.ArrayList;

public class ControlSorteOuReves {

	private ArrayList<Sorte> cartaSorte;
	private ArrayList<Reves> cartaReves;
	private static ControlSorteOuReves controlSorteOuReves = new ControlSorteOuReves();

	private ControlSorteOuReves(){}

	public static synchronized ControlSorteOuReves getInstance() {
		return controlSorteOuReves;
	}

	public Carta sortearCarta() {
		return null;
	}

	public void criarCartas() {

	}

}
