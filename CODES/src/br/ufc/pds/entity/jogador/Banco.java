package br.ufc.pds.entity.jogador;

import br.ufc.pds.entity.campo.propriedade.Propriedade;
import br.ufc.pds.pojo.ContaBancaria;

import java.util.ArrayList;

public class Banco extends Jogador {
	private static Banco banco  = new Banco();

	private Banco() {
		this.contaBancaria = new ContaBancaria(15000);
		this.propriedades = new ArrayList<>();
	}

	public static synchronized Banco getInstance() {
		return banco;
	}

	public ContaBancaria getContaBancaria() {
		return this.contaBancaria;
	}
	public ArrayList<Propriedade> getPropriedades() {
		return propriedades;
	}


}
