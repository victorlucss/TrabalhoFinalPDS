package br.ufc.pds.controller;

import br.ufc.pds.entity.Tabuleiro;
import br.ufc.pds.entity.jogador.JogadorHumano;
import br.ufc.pds.pojo.Dado;

import java.util.HashMap;
import java.util.Map;

public class ControlBancoImobiliario {

	private Map<Integer, JogadorHumano> jogadoresAtivos;
	private Map<Integer,JogadorHumano> jogadoresPresos;
	private Tabuleiro tabuleiro;
	private Dado[] dados = {new Dado(), new Dado()};

	public ControlBancoImobiliario() {
		this.jogadoresAtivos = new HashMap<>();
		this.jogadoresPresos = new HashMap<>();
		this.tabuleiro = new Tabuleiro();
	}

	public void jogar() {
		while(true) {

		}
	}

	public Map<Integer,JogadorHumano> obterJogadores() {
		return null;
	}

	public void adicionarJogador() {

	}

	public void prenderJogador() {

	}

	public void soltarJogador() {

	}

}
