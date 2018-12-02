package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.JogadorHumano;

public class ImpostoDeRenda extends CampoEspecial implements EfeitoEspecial {

    public ImpostoDeRenda(int indice) {
        super("Imposto de Renda", indice);
    }

    public void aplicarEfeito(JogadorHumano jogador) {
        jogador.receber(200);
    }

}
