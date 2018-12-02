package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class AvPresidenteVargas extends Terreno implements EfeitoEspecial {

    public AvPresidenteVargas(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "AV. PRESIDENTE VARGAS";
        this.indice = indice;
        this.dono = dono;
        this.preco = 60;
        this.cor = "ROSA";
        this.aluguel = 2;
        this.numCasas = 0;
        this.precoCasa = 50;
        this.precoHotel = 50;
        this.hasHotel = false;
        this.aluguel1Casas = 10;
        this.aluguel2Casas = 30;
        this.aluguel3Casas = 90;
        this.aluguel4Casas = 160;
        this.aluguelHotel = 250;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
