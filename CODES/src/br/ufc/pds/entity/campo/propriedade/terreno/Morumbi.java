package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Morumbi extends Terreno implements EfeitoEspecial {

    public Morumbi(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "MORUMBI";
        this.indice = indice;
        this.dono = dono;
        this.preco = 400;
        this.cor = "LARANJA";
        this.aluguel = 50;
        this.numCasas = 0;
        this.precoCasa = 200;
        this.precoHotel = 200;
        this.hasHotel = false;
        this.aluguel1Casas = 200;
        this.aluguel2Casas = 600;
        this.aluguel3Casas = 1400;
        this.aluguel4Casas = 1700;
        this.aluguelHotel = 2000;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
