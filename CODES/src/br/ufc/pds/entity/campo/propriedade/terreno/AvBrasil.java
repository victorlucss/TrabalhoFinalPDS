package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class AvBrasil extends Terreno implements EfeitoEspecial {

    public AvBrasil(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "AV.BRASIL";
        this.indice = indice;
        this.dono = dono;
        this.preco = 160;
        this.cor = "AMARELA";
        this.aluguel = 12;
        this.numCasas = 0;
        this.precoCasa = 100;
        this.precoHotel = 100;
        this.hasHotel = false;
        this.aluguel1Casas = 60;
        this.aluguel2Casas = 180;
        this.aluguel3Casas = 500;
        this.aluguel4Casas = 700;
        this.aluguelHotel = 900;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
