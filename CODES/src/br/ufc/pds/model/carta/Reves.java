package br.ufc.pds.model.carta;

import br.ufc.pds.model.jogador.Banco;
import br.ufc.pds.model.jogador.JogadorHumano;

public class Reves extends CartaSorteOuReves {
    public Reves(String titulo, String descricao, float valor) {
        super(titulo, descricao, valor);
    }

    public void acao(JogadorHumano jogador) {
//        jogador.pagar(this.valor);
        if (jogador.pagarCredor(this.valor)){
            Banco.getInstance().receber(this.valor);
        }
        //System.out.println(jogador.getNome() + " pagou R$ " + this.valor);
        this.showCarta(this.titulo, this.descricao, jogador.getNome() + " pagou R$ " + this.valor);
    }
}
