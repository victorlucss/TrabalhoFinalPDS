package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Brooklin extends Terreno implements EfeitoEspecial {

    public Brooklin(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "BROOKLIN";
        this.indice = indice;
        this.dono = dono;
        this.preco = 260;
        this.cor = "ROXO";
        this.aluguel = 22;
        this.numCasas = 0;
        this.precoCasa = 150;
        this.precoHotel = 150;
        this.hasHotel = false;
        this.aluguel1Casas = 110;
        this.aluguel2Casas = 330;
        this.aluguel3Casas = 800;
        this.aluguel4Casas = 975;
        this.aluguelHotel = 1150;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
