package br.ufc.pds.entity.jogador;

import br.ufc.pds.pojo.ContaBancaria;
import entity.campo.propriedade.Propriedade;

import java.util.ArrayList;

public abstract class Jogador {

	protected ContaBancaria contaBancaria;
	protected ArrayList<Propriedade> propriedades;

	public void pagar(float valor) {

	}

	public void receber(float valor) {

	}

	public void comprarPropriedade() {

	}

	public void venderPropriedade() {

	}

}
