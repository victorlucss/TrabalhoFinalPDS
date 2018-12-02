package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class RuaAugusta extends Terreno implements EfeitoEspecial {

    public RuaAugusta(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "RUA AUGUSTA";
        this.indice = indice;
        this.dono = dono;
        this.preco = 180;
        this.cor = "VIOLETA";
        this.aluguel = 14;
        this.numCasas = 0;
        this.precoCasa = 100;
        this.precoHotel = 100;
        this.hasHotel = false;
        this.aluguel1Casas = 70;
        this.aluguel2Casas = 200;
        this.aluguel3Casas = 550;
        this.aluguel4Casas = 750;
        this.aluguelHotel = 950;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
