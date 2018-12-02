package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class AvBrigadeiroFariaLima extends Terreno implements EfeitoEspecial {

    public AvBrigadeiroFariaLima(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "AV. BRIGADEIRO FARIA LIMA";
        this.indice = indice;
        this.dono = dono;
        this.preco = 240;
        this.cor = "AZUL";
        this.aluguel = 20;
        this.numCasas = 0;
        this.precoCasa = 150;
        this.precoHotel = 150;
        this.hasHotel = false;
        this.aluguel1Casas = 100;
        this.aluguel2Casas = 300;
        this.aluguel3Casas = 750;
        this.aluguel4Casas = 925;
        this.aluguelHotel = 1100;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
