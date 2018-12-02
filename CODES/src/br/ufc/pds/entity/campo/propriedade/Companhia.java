package br.ufc.pds.entity.campo.propriedade;

import br.ufc.pds.Teste;
import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.ArrayList;

public class Companhia extends Propriedade implements EfeitoEspecial {

	private float taxa;

	public Companhia(String nome, int indice, float preco, Jogador dono, float taxa) {
		this.nome = nome;
		this.indice = indice;
		this.preco = preco;
		this.dono = dono;
		this.listaJogadores = new ArrayList<>();
		this.taxa = taxa;
	}

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {
		if (this.dono != Banco.getInstance()) {
			int escolha = Teste.opcaoDoJogadorPropriedadeComDono();
			if (escolha==1) {
				System.out.println("Jogador quer comprar, implementar isso");
			} else {
				float taxaCobrada = this.taxa * (jogador.getDados()[0].obterValorDaFace() + jogador.getDados()[1].obterValorDaFace());
				System.out.println(jogador.getNome()+" pagou R$" + taxaCobrada);
				jogador.pagar(taxaCobrada);
				this.dono.receber(taxaCobrada);
			}
		} else {
			int escolha = Teste.opcaoDoJogadorPropriedadeSemDono();
			if (escolha==1) {
				System.out.println(jogador.getNome()+" comprou " + this.nome + " por R$"+this.preco);
				this.dono.receber(this.preco);
				jogador.pagar(this.preco);
				jogador.comprarPropriedade(this);
				this.dono = jogador;
			} else {
				System.out.println("O que fazer? kkk");
			}
		}
    }
}
