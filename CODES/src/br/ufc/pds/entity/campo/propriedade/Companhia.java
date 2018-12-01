package br.ufc.pds.entity.campo.propriedade;

import br.ufc.pds.entity.jogador.Jogador;

import java.util.ArrayList;

public class Companhia extends Propriedade {

	private float taxa;

	public void Companhia(String nome, int indice, float preco, Jogador dono, float taxa) {
		this.nome = nome;
		this.indice = indice;
		this.preco = preco;
		this.dono = dono;
		this.listaJogadores = new ArrayList<>();
		this.taxa = taxa;
	}

}
