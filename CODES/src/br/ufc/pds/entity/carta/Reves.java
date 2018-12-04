package br.ufc.pds.entity.carta;

import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.JogadorHumano;

public class Reves extends CartaSorteOuReves {
    public Reves(String titulo, String descricao, float valor) {
        super(titulo, descricao, valor);
    }

    public void acao(JogadorHumano jogador) {
        Banco.getInstance().receber(this.valor);
        jogador.pagar(this.valor);
        //System.out.println(jogador.getNome() + " pagou R$ " + this.valor);
        this.showCarta(this.titulo, this.descricao, jogador.getNome() + " pagou R$ " + this.valor);
    }
}
