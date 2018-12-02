package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class JardimPaulista extends Terreno implements EfeitoEspecial {

    public JardimPaulista(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "JARDIM PAULISTA";
        this.indice = indice;
        this.dono = dono;
        this.preco = 280;
        this.cor = "ROXO";
        this.aluguel = 24;
        this.numCasas = 0;
        this.precoCasa = 150;
        this.precoHotel = 150;
        this.hasHotel = false;
        this.aluguel1Casas = 120;
        this.aluguel2Casas = 360;
        this.aluguel3Casas = 860;
        this.aluguel4Casas = 1025;
        this.aluguelHotel = 1200;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
