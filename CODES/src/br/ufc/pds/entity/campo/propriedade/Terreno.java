package br.ufc.pds.entity.campo.propriedade;

import br.ufc.pds.entity.jogador.Jogador;

import java.util.ArrayList;

public class Terreno extends Propriedade {

	private String cor;
	private float aluguel;
	private int numCasas;
	private float precoCasa;
	private float precoHotel;
	private boolean hasHotel;
	private float aluguel1Casas;
	private float aluguel2Casas;
	private float aluguel3Casas;
	private float aluguel4Casas;
	private float aluguelHotel;

	public Terreno(String nome, int indice, Jogador dono, float preco, String cor, float aluguel, float precoCasa, float precoHotel, float aluguel1Casas, float aluguel2Casas, float aluguel3Casas, float aluguel4Casas, float aluguelHotel) {
        super(nome, indice, preco, dono);
		this.cor = cor;
		this.aluguel = aluguel;
		this.numCasas = 0;
		this.precoCasa = precoCasa;
		this.precoHotel = precoHotel;
		this.hasHotel = false;
		this.aluguel1Casas = aluguel1Casas;
		this.aluguel2Casas = aluguel2Casas;
		this.aluguel3Casas = aluguel3Casas;
		this.aluguel4Casas = aluguel4Casas;
		this.aluguelHotel = aluguelHotel;
	}

	public float getAluguel() {
	    if (this.hasHotel) {
	        return this.aluguelHotel;
        } else if (this.numCasas == 1) {
			return this.aluguel1Casas;
		} else if (this.numCasas == 2) {
			return this.aluguel2Casas;
		} else if (this.numCasas == 3) {
			return this.aluguel3Casas;
		} else if (this.numCasas == 4) {
			return this.aluguel4Casas;
		} else {
			return this.aluguel;
		}
	}
}
