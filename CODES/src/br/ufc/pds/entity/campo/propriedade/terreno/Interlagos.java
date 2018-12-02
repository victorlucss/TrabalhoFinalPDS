package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Interlagos extends Terreno implements EfeitoEspecial {

    public Interlagos(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "INTERLAGOS";
        this.indice = indice;
        this.dono = dono;
        this.preco = 350;
        this.cor = "LARANJA";
        this.aluguel = 35;
        this.numCasas = 0;
        this.precoCasa = 200;
        this.precoHotel = 200;
        this.hasHotel = false;
        this.aluguel1Casas = 175;
        this.aluguel2Casas = 500;
        this.aluguel3Casas = 1100;
        this.aluguel4Casas = 1300;
        this.aluguelHotel = 1500;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
