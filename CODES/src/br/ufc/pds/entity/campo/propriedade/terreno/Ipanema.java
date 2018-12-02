package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Ipanema extends Terreno implements EfeitoEspecial {

    public Ipanema(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "IPANEMA";
        this.indice = indice;
        this.dono = dono;
        this.preco = 300;
        this.cor = "VERDE";
        this.aluguel = 26;
        this.numCasas = 0;
        this.precoCasa = 200;
        this.precoHotel = 200;
        this.hasHotel = false;
        this.aluguel1Casas = 130;
        this.aluguel2Casas = 390;
        this.aluguel3Casas = 900;
        this.aluguel4Casas = 1100;
        this.aluguelHotel = 1275;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
