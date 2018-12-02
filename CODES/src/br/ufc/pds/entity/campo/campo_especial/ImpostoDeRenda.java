package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class ImpostoDeRenda extends CampoEspecial implements EfeitoEspecial {

    public ImpostoDeRenda(int indice) {
        this.listaJogadores = new ArrayList<>();
        this.nome = "Imposto de Renda";
        this.indice = indice;
    }

    public void aplicarEfeito(JogadorHumano jogador) {
        jogador.receber(200);
    }

}
