package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class AvVieiraSouto extends Terreno implements EfeitoEspecial {

    public AvVieiraSouto(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "AV.VIERIRA SOUTO";
        this.indice = indice;
        this.dono = dono;
        this.preco = 320;
        this.cor = "VERDE";
        this.aluguel = 28;
        this.numCasas = 0;
        this.precoCasa = 200;
        this.precoHotel = 200;
        this.hasHotel = false;
        this.aluguel1Casas = 150;
        this.aluguel2Casas = 450;
        this.aluguel3Casas = 1000;
        this.aluguel4Casas = 1200;
        this.aluguelHotel = 1400;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
