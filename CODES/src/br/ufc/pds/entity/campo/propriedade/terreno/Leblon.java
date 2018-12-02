package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Leblon extends Terreno implements EfeitoEspecial {

    public Leblon(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "LEBLON";
        this.indice = indice;
        this.dono = dono;
        this.preco = 100;
        this.cor = "ROSA";
        this.aluguel = 6;
        this.numCasas = 0;
        this.precoCasa = 50;
        this.precoHotel =50;
        this.hasHotel = false;
        this.aluguel1Casas = 30;
        this.aluguel2Casas = 90;
        this.aluguel3Casas = 270;
        this.aluguel4Casas = 400;
        this.aluguelHotel = 500;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
