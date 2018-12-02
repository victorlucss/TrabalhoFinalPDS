package br.ufc.pds.entity.jogador;

import br.ufc.pds.entity.campo.propriedade.Propriedade;
import br.ufc.pds.entity.carta.Carta;
import br.ufc.pds.pojo.ContaBancaria;
import br.ufc.pds.pojo.Peca;
import br.ufc.pds.pojo.Dado;

import java.util.ArrayList;

public class JogadorHumano extends Jogador {

	private int id;
	private String nome;
	private Peca peca;
	private Carta cartaPrisao;
	private Dado[] dados;

	public JogadorHumano(int id, String nome, Peca peca, Dado[] dados) {
		this.id = id;
		this.nome = nome;
		this.peca = peca;
		this.dados = dados;
		this.cartaPrisao = null;
		this.contaBancaria = new ContaBancaria(1500);
		this.propriedades = new ArrayList<>();
	}

	public int lancarDados() {
		this.dados[0].lancar();
		this.dados[1].lancar();
		System.out.println("Valor do Dado: " + (dados[0].obterValorDaFace() + dados[1].obterValorDaFace()));
		return dados[0].obterValorDaFace() + dados[1].obterValorDaFace();
	}

	public String getNome() {
		return this.nome;
	}

	public Peca getPeca() {
		return this.peca;
	}

	public ContaBancaria getContaBancaria() {
		return this.contaBancaria;
	}

	public Dado[] getDados() {
		return this.dados;
	}

	public ArrayList<Propriedade> getPropriedades() {
		return propriedades;
	}

	public Carta getCartaPrisao() {
		return this.cartaPrisao;
	}

	public void setCartaPrisao(Carta carta) {
		this.cartaPrisao = carta;
	}

	public int getId() {
		return this.id;
	}
}
