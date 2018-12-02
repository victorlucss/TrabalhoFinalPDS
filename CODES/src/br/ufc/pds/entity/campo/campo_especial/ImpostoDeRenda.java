package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.JogadorHumano;

public class ImpostoDeRenda extends CampoEspecial implements EfeitoEspecial {

    public ImpostoDeRenda(int indice) {
        super("Imposto de Renda", indice);
    }

    public void aplicarEfeito(JogadorHumano jogador) {
        System.out.println(jogador.getNome() + " pagou R$ 200 de Imposto de Renda.");
        Banco.getInstance().receber(200);
        jogador.pagar(200);
    }

}
