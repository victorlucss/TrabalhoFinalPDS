package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public abstract class CampoEspecial extends Campo {

	protected String nome;
	protected ArrayList<JogadorHumano> listaJogadores;

}
