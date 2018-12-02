package br.ufc.pds.entity.campo.propriedade;

import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;

import java.util.Scanner;

public class Terreno extends Propriedade implements EfeitoEspecial {

	private String cor;
	private float aluguel;
	private int numCasas;
	private float precoCasa;
	private float precoHotel;
	private boolean hasHotel;
	private float aluguel1Casas;
	private float aluguel2Casas;
	private float aluguel3Casas;
	private float aluguel4Casas;
	private float aluguelHotel;

	public Terreno(String nome, int indice, Jogador dono, float preco, String cor, float aluguel, float precoCasa, float precoHotel, float aluguel1Casas, float aluguel2Casas, float aluguel3Casas, float aluguel4Casas, float aluguelHotel) {
        super(nome, indice, preco, dono);
		this.cor = cor;
		this.aluguel = aluguel;
		this.numCasas = 0;
		this.precoCasa = precoCasa;
		this.precoHotel = precoHotel;
		this.hasHotel = false;
		this.aluguel1Casas = aluguel1Casas;
		this.aluguel2Casas = aluguel2Casas;
		this.aluguel3Casas = aluguel3Casas;
		this.aluguel4Casas = aluguel4Casas;
		this.aluguelHotel = aluguelHotel;
	}

	public float getAluguel() {
	    if (this.hasHotel) {
	        return this.aluguelHotel;
        } else if (this.numCasas == 1) {
			return this.aluguel1Casas;
		} else if (this.numCasas == 2) {
			return this.aluguel2Casas;
		} else if (this.numCasas == 3) {
			return this.aluguel3Casas;
		} else if (this.numCasas == 4) {
			return this.aluguel4Casas;
		} else {
			return this.aluguel;
		}
	}

    @Override
    public void aplicarEfeito(JogadorHumano jogador) {
	    if (this.dono == jogador) {
	        this.acoesProprietario();
        } else if (this.dono == Banco.getInstance()) {
	        this.acoesComprador(jogador);
        } else {
	        this.acoesVisitante(jogador);
        }
    }

    public void acoesProprietario () {
        System.out.println("Esse Terreno é Seu!");
	    System.out.println("Escolha:");
        System.out.println("1- Vender pro Banco por " + (this.preco/2));
        System.out.println("2- Construir Casa");
        System.out.println("0- Encerrar Turno.");
        Scanner input = new Scanner(System.in);
        int escolha = Integer.parseInt(input.nextLine());

        if (escolha==1) {
            System.out.println(((JogadorHumano) this.dono).getNome() + " vendeu a propriedade para o Banco por" + (this.preco/2));
            this.dono.venderPropriedade(this);
            Banco.getInstance().comprarPropriedade(this);
            this.dono.pagar(this.preco/2);
            Banco.getInstance().receber(this.preco/1);
            this.dono = Banco.getInstance();
        } else if (escolha==2) {
            System.out.println("Implementar");
        } else {
            System.out.println(((JogadorHumano) this.dono).getNome()+" encerrou o Turno.");
        }
    }

    public void acoesVisitante(JogadorHumano jogador) {
	    System.out.println("Esse Terreno Pertence a: " + ((JogadorHumano) this.dono).getNome());
        System.out.println("Escolha:");
        System.out.println("1- Fazer Proposta de Compra.");
        System.out.println("0- Encerrar Turno.");
        Scanner input = new Scanner(System.in);
        int escolha = Integer.parseInt(input.nextLine());

        if (escolha==1) {
            System.out.print("Digite o valor da proposta: R$ ");
            float valorProposto = Float.parseFloat(input.nextLine());

            boolean isAceito = ((JogadorHumano) this.dono).pedidoDeCompraDePropriedade(this, valorProposto);

            if (isAceito) {
                System.out.println(((JogadorHumano) this.dono).getNome() + " aceitou sua proposta.");
                System.out.println(jogador.getNome() + " comprou " + this.nome + " por R$ "+ valorProposto);
                this.dono.receber(this.preco);
                jogador.pagar(this.preco);
                this.dono.venderPropriedade(this);
                jogador.comprarPropriedade(this);
                this.dono = jogador;
            } else {
                System.out.println(((JogadorHumano) this.dono).getNome() + " recusou sua proposta.");
            }

        } else {
            System.out.println(jogador.getNome()+" encerrou o Turno e pagou R$ " + this.getAluguel() + " de aluguel");
            jogador.pagar(this.getAluguel());
            this.dono.receber(this.getAluguel());
        }
    }

    public void acoesComprador(JogadorHumano jogador) {
        System.out.println("Escolha:");
        System.out.println("1- Comprar Terreno por R$ "+this.preco);
        System.out.println("0- Encerrar Turno.");
        Scanner input = new Scanner(System.in);
        int escolha = Integer.parseInt(input.nextLine());

        if (escolha==1) {
            System.out.println(jogador.getNome()+" comprou " + this.nome + " por R$ "+this.preco);
            this.dono.receber(this.preco);
            jogador.pagar(this.preco);
            this.dono.venderPropriedade(this);
            jogador.comprarPropriedade(this);
            this.dono = jogador;
        } else {
            System.out.println(jogador.getNome()+" encerrou o Turno.");
        }
    }

    public boolean validarConstrucaoCasa(){
	    return false;
    }
}
