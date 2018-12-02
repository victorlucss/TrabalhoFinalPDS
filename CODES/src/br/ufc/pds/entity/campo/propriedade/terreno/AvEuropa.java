package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class AvEuropa extends Terreno implements EfeitoEspecial {

    public AvEuropa(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "AV. EUROPA";
        this.indice = indice;
        this.dono = dono;
        this.preco = 200;
        this.cor = "VIOLETA";
        this.aluguel = 16;
        this.numCasas = 0;
        this.precoCasa = 100;
        this.precoHotel = 100;
        this.hasHotel = false;
        this.aluguel1Casas = 80;
        this.aluguel2Casas = 220;
        this.aluguel3Casas = 600;
        this.aluguel4Casas = 800;
        this.aluguelHotel = 1000;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
