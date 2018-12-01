package br.ufc.pds.entity.campo.campo_especial;

import java.util.ArrayList;

public class ParadaLivre extends CampoEspecial {

    public ParadaLivre(int indice) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "Parada Livre";
        this.indice = indice;
    }
}
