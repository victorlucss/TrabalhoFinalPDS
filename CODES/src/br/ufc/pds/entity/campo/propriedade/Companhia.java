package br.ufc.pds.entity.campo.propriedade;

import br.ufc.pds.Teste;
import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;
import br.ufc.pds.view.ComprarPropriedade;

import javax.swing.*;

public class Companhia extends Propriedade implements EfeitoEspecial {

	private float taxa;

	public Companhia(String nome, int indice, float preco, Jogador dono, float taxa, int eixoX, int eixoY) {
		super(nome, indice, preco, dono, eixoX, eixoY);
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
			//int escolha = Teste.opcaoDoJogadorPropriedadeSemDono();
            String titulo = jogador.getNome() + " alcançou " + this.nome;
            String taxa = "Taxa: R$ "+this.taxa;
            String valor = "Valor: R$ "+this.preco;
            String saldo = "Seu Saldo: R$ " + jogador.getContaBancaria().getSaldo();
            String numPropriedades = "Num. Prop.: " + jogador.getPropriedades().size();
            String dado1 = "Dado1: " + jogador.getDados()[0].obterValorDaFace();
            String dado2 = "Dado2: " + jogador.getDados()[1].obterValorDaFace();

			ComprarPropriedade cp = new ComprarPropriedade(titulo, taxa, valor, saldo, numPropriedades, dado1, dado2);
			cp.setVisible(true);
			boolean comprar = cp.getComprar();

			if (comprar) {
				//System.out.println(jogador.getNome()+" comprou " + this.nome + " por R$"+this.preco);
                JOptionPane.showMessageDialog(null,jogador.getNome()+" comprou " + this.nome + " por R$"+this.preco);

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
