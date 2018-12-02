package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class AvPaulista extends Terreno implements EfeitoEspecial {

    public AvPaulista(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "AV.PAULISTA";
        this.indice = indice;
        this.dono = dono;
        this.preco = 140;
        this.cor = "AMARELO";
        this.aluguel = 10;
        this.numCasas = 0;
        this.precoCasa = 100;
        this.precoHotel = 100;
        this.hasHotel = false;
        this.aluguel1Casas = 50;
        this.aluguel2Casas = 150;
        this.aluguel3Casas = 450;
        this.aluguel4Casas = 625;
        this.aluguelHotel = 750;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
