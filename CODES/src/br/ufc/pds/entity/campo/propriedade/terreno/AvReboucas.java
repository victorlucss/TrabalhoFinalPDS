package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class AvReboucas extends Terreno implements EfeitoEspecial {

    public AvReboucas(int indice, Jogador dono) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "AV. REBOUCAS";
        this.indice = indice;
        this.dono = dono;
        this.preco = 220;
        this.cor = "AZUL";
        this.aluguel = 18;
        this.numCasas = 0;
        this.precoCasa = 150;
        this.precoHotel = 150;
        this.hasHotel = false;
        this.aluguel1Casas = 90;
        this.aluguel2Casas = 250;
        this.aluguel3Casas = 700;
        this.aluguel4Casas = 875;
        this.aluguelHotel = 1050;
    }

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {

    }
}
