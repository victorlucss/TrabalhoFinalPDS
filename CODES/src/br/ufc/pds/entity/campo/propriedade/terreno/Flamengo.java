package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Flamengo extends Terreno implements EfeitoEspecial {

    public Flamengo(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "FLAMENGO";
        this.indice = indice;
        this.dono = dono;
        this.preco = 120;
        this.cor = "VERMELHO";
        this.aluguel = 8;
        this.numCasas = 0;
        this.precoCasa = 50;
        this.precoHotel = 50;
        this.hasHotel = false;
        this.aluguel1Casas = 40;
        this.aluguel2Casas = 100;
        this.aluguel3Casas = 300;
        this.aluguel4Casas = 450;
        this.aluguelHotel = 600;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
