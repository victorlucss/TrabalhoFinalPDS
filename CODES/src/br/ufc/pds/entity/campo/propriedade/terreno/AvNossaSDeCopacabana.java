package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class AvNossaSDeCopacabana extends Terreno implements EfeitoEspecial {

    public AvNossaSDeCopacabana(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "AV. NOSSA S. DE COPACABANA";
        this.indice = indice;
        this.dono = dono;
        this.preco = 60;
        this.cor = "ROSA";
        this.aluguel = 4;
        this.numCasas = 0;
        this.precoCasa = 50;
        this.precoHotel = 50;
        this.hasHotel = false;
        this.aluguel1Casas = 20;
        this.aluguel2Casas = 60;
        this.aluguel3Casas = 180;
        this.aluguel4Casas = 320;
        this.aluguelHotel = 450;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
