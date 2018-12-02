package br.ufc.pds.entity.campo;

import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public abstract class Campo {

	protected String nome;
	protected ArrayList<JogadorHumano> listaJogadores;
	protected int indice;

	protected Campo(String nome, int indice) {
		this.nome = nome;
		this.indice = indice;
		this.listaJogadores = new ArrayList<>();
	}

	public int getIndice() {
		return indice;
	}

	public String getNome() {
		return nome;
	}

	public void addJogador(JogadorHumano jogadorHumano) {
		this.listaJogadores.add(jogadorHumano);
		jogadorHumano.getPeca().mudarLocalizacao(this);
	}

	public void removerJogador(JogadorHumano jogadorHumano) {
		this.listaJogadores.remove(jogadorHumano);
	}

}
