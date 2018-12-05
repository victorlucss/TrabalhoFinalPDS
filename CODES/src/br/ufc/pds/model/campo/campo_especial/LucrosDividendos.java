package br.ufc.pds.model.campo.campo_especial;

import br.ufc.pds.model.campo.EfeitoEspecial;
import br.ufc.pds.model.jogador.Banco;
import br.ufc.pds.model.jogador.JogadorHumano;

public class LucrosDividendos extends CampoEspecial implements EfeitoEspecial {

	public LucrosDividendos(int indice) {
		super("Lucros e Dividendos", indice, 23, 161);
	}

	public void aplicarEfeito(JogadorHumano jogador) {
		String titulo = this.nome;
		String acao = jogador.getNome() + " recebeu R$ 200 de Lucros e Dividendos.";

		this.showMensagem(titulo, acao);

		//System.out.println(jogador.getNome() + " recebeu R$ 200");
		Banco.getInstance().pagar(200);
		jogador.receber(200);
	}

}