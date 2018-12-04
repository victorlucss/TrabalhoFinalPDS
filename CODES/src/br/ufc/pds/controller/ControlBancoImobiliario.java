package br.ufc.pds.controller;

import br.ufc.pds.Teste;
import br.ufc.pds.entity.Tabuleiro;
import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.JogadorHumano;
import br.ufc.pds.pojo.Dado;
import br.ufc.pds.pojo.Peca;
import br.ufc.pds.view.EntraComJogador;
import br.ufc.pds.view.JogadorDaVez;
import br.ufc.pds.view.SelecionarQuantidadeDeJogadoresPanel;
import br.ufc.pds.view.TelaPrincipal.TelaPrincipal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlBancoImobiliario {
	private static ControlBancoImobiliario controlBancoImobiliario = new ControlBancoImobiliario();

	private Map<Integer, JogadorHumano> jogadoresAtivos;
	private Map<Integer,JogadorHumano> jogadoresPresos;
	private Tabuleiro tabuleiro;
	private Dado[] dados = {new Dado(), new Dado()};
	private TelaPrincipal telaPrincipal;

	private int numJogadores;
	private Banco banco;

	private boolean hasSetedNumJogadores = false;

	private ControlBancoImobiliario() {
		this.jogadoresAtivos = new HashMap<>();
		this.jogadoresPresos = new HashMap<>();
		this.banco = Banco.getInstance();
		this.tabuleiro = new Tabuleiro();
	}

	public static synchronized ControlBancoImobiliario getInstance(){
		return controlBancoImobiliario;
	}

	public void jogar() {

		SelecionarQuantidadeDeJogadoresPanel SQDPanel = new SelecionarQuantidadeDeJogadoresPanel();
		SQDPanel.run();

		while (!this.hasSetedNumJogadores){
			System.out.println(this.numJogadores);
		}

		for(int i=1; i<=this.numJogadores; i++) {
			EntraComJogador entraComJogador = new EntraComJogador();
			entraComJogador.run();
		}

        this.telaPrincipal = TelaPrincipal.getInstance(); //Instancia Tela Principal

		while(true) {
			this.iniciarRodada();
		}
	}

	public void renderizarTelaPrincipal() {
        this.telaPrincipal.drawBackgroud();

        this.jogadoresAtivos.forEach((key, value) -> {
            this.telaPrincipal.renderPeca(value.getPeca());
        });

        this.telaPrincipal.displayJanelaPrincipal();
    }

	public void adicionarJogador(String jogador, String cor){
		System.out.println(jogador+" "+cor);
		int indice = jogadoresAtivos.size();
		JogadorHumano jogadorHumano = new JogadorHumano(indice, jogador, new Peca(cor, this.tabuleiro.obterCampoInicial()), this.dados);
					this.jogadoresAtivos.put(indice, jogadorHumano);
			this.tabuleiro.obterCampoInicial().addJogador(jogadorHumano);
	}

	public void iniciarRodada() {
		this.jogadoresAtivos.forEach((key, value) -> {
            this.renderizarTelaPrincipal();
            JogadorDaVez jdv;

		    if (!(this.getJogadoresPresos().containsValue(value))) {
                jdv = new JogadorDaVez(value.getNome() + " Jogando", "Propriedades: " + value.getPropriedades().size(), "Saldo: R$ " + value.getContaBancaria().getSaldo(), "Status: Jogador Livre");
                jdv.setVisible(true);
                value.lancarDados();
                this.jogadorRealizaTurno(value);
            } else {
                jdv = new JogadorDaVez(value.getNome() + " Jogando", "Propriedades: " + value.getPropriedades().size(), "Saldo: R$ " + value.getContaBancaria().getSaldo(), "Status: Jogador Preso");
                jdv.setVisible(true);
                value.lancarDados();
                this.jogadorPresoRealizaTurno(value);
            }
		});
	}

	public void jogadorPresoRealizaTurno(JogadorHumano jogador) {
        if (jogador.getCartaPrisao() != null) {
            jogador.setCartaPrisao(null);
            this.soltarJogador(jogador);
            jogador.getFichaCriminal().setRodadasPreso(0);
            this.alterarPosicaoDoJogador(jogador);
            JOptionPane.showMessageDialog(null, jogador.getNome() + " saiu da Prisão (Carta Coringa)");
        } else if (this.dados[0].obterValorDaFace() == this.dados[1].obterValorDaFace()) {
            this.soltarJogador(jogador);
            this.soltarJogador(jogador);
            jogador.getFichaCriminal().setRodadasPreso(0);
            this.alterarPosicaoDoJogador(jogador);
            JOptionPane.showMessageDialog(null, jogador.getNome() + " saiu da Prisão (Dados Iguais)");

        } else if (jogador.getFichaCriminal().getRodadasPreso() >= 3) {
            jogador.getContaBancaria().pagar(50);
            Banco.getInstance().receber(50);
            JOptionPane.showMessageDialog(null, jogador.getNome() + " saiu da Prisão (Pagou R$ 50,00 ao Banco)");
        } else {
            int delitos = jogador.getFichaCriminal().getRodadasPreso() + 1;
            System.out.println(delitos + " - " + jogador.getNome());
            jogador.getFichaCriminal().setRodadasPreso(delitos);
            JOptionPane.showMessageDialog(null, jogador.getNome() + " continuará Preso");
        }
	}


	public void jogadorRealizaTurno(JogadorHumano jogador) {
        Campo proximoCampo = this.alterarPosicaoDoJogador(jogador);
        
		try {
			this.executaAcaoCampo((EfeitoEspecial) proximoCampo, jogador); //Aciona o efeito especial para o Jogador...
		} catch (ClassCastException e) {
			System.out.println("Campo sem Ação!"); // Caso caia em Paradav Livre
		}
	}

	public Campo alterarPosicaoDoJogador(JogadorHumano jogador) {
        int valorDados = jogador.getDados()[0].obterValorDaFace() + jogador.getDados()[1].obterValorDaFace();

        jogador.getPeca().obterLocalizacao().removerJogador(jogador); //Remove o jogador do campo em que ele estava

        Campo proximoCampo = this.tabuleiro.obterProximoCampo(jogador.getPeca().obterLocalizacao(), valorDados);
        //Campo proximoCampo = this.tabuleiro.obterProximoCampo(this.tabuleiro.obterCampoInicial(), 30); // NÃO REMOVERLinha usada apenas para testes
        jogador.getPeca().mudarLocalizacao(proximoCampo);
        Teste.informaAvancoJogador(jogador);//remover-------------------------------------------

        jogador.getPeca().obterLocalizacao().addJogador(jogador); //Adiciona o jogador no Campo Atual
        this.renderizarTelaPrincipal(); // Atualiza posição do jogador no Tabuleiro

        return proximoCampo;
    }

	public void executaAcaoCampo(EfeitoEspecial campo, JogadorHumano jogador) {
		if (campo!=null) {
			System.out.println("Testando Aplicar Efeito");
			campo.aplicarEfeito(jogador);
		}
	}

	public void prenderJogador(JogadorHumano jogador) {
		this.tabuleiro.buscarCampo(11).addJogador(jogador); // 11 é o índice da prisão
		this.jogadoresPresos.put(jogador.getId(), jogador);
	}

	public void soltarJogador(JogadorHumano jogador) {
		this.tabuleiro.buscarCampo(11).removerJogador(jogador); // 11 é o índice da prisão
		this.jogadoresPresos.remove(jogador);
	}

    public ArrayList<String> getCores(){
        String[] cores = {"Azul", "Rosa", "Roxo", "Verde","Amarelo","Laranja"};
        List<String> coresList = new ArrayList<String>();

        for(String cor: cores){
            if(!this.corUsada(cor)){
                coresList.add(cor);
            }
        }

        return (ArrayList) coresList;
    }

    public boolean corUsada(String cor){
        for (int i = 0; i < jogadoresAtivos.size(); i++) {
            if(jogadoresAtivos.get(i).getPeca().getCor().equals(cor)){
                return true;
            }
        }

        for (int i = 0; i < jogadoresPresos.size(); i++) {
            if(jogadoresPresos.get(i).getPeca().getCor().equals(cor)){
                return true;
            }
        }

        return false;
    }

	public Map getJogadoresPresos() {
		return this.jogadoresPresos;
	}

	public Map getJogadoresAtivos() {
		return this.jogadoresAtivos;
	}

	public int getNumJogadores() {
		return numJogadores;
	}

	public void setNumJogadores(int numJogadores) {
		System.out.println(numJogadores);
		this.numJogadores = numJogadores;
	}

	public void changeHasSetedNumJogadores(){
		this.hasSetedNumJogadores = true;
	}
}
