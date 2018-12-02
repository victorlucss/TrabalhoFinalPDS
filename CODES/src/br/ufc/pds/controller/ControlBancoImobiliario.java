package br.ufc.pds.controller;

import br.ufc.pds.Teste;
import br.ufc.pds.entity.Tabuleiro;
import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.entity.campo.EfeitoEspecial;
import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.entity.jogador.JogadorHumano;
import br.ufc.pds.pojo.Dado;
import br.ufc.pds.pojo.Peca;

import java.util.HashMap;
import java.util.Map;

public class ControlBancoImobiliario {
	private static ControlBancoImobiliario controlBancoImobiliario = new ControlBancoImobiliario();

	private Map<Integer, JogadorHumano> jogadoresAtivos;
	private Map<Integer,JogadorHumano> jogadoresPresos;
	private Tabuleiro tabuleiro;
	private Dado[] dados = {new Dado(), new Dado()};
	private int numJogadores;
	private Banco banco;

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
		this.numJogadores = Teste.numJogadores();

		for(int i=1; i<=this.numJogadores; i++) {
			JogadorHumano jogadorHumano = new JogadorHumano(i, Teste.nomeJogador(i), new Peca("Verde", this.tabuleiro.obterCampoInicial()), this.dados);
			this.jogadoresAtivos.put(i, jogadorHumano);
			this.tabuleiro.obterCampoInicial().addJogador(jogadorHumano);
		}

		while(true) {
			this.iniciarRodada();
		}
	}

	public void iniciarRodada() {
		this.jogadoresAtivos.forEach((key, value) -> {
			System.out.println(value.getNome()+" jogando, saldo: "+value.getContaBancaria().getSaldo() + " Num Propriedades: " + value.getPropriedades().size());
			this.jogadorRealizaTurno(value);
		});
	}

	public void jogadorRealizaTurno(JogadorHumano jogador) {
		Teste.esperaQualquer(); //remover----------------------------------------------------------------
		int valorDados = jogador.lancarDados();

		jogador.getPeca().obterLocalizacao().removerJogador(jogador); //Remove o jogador do campo em que ele estava

		Campo proximoCampo = this.tabuleiro.obterProximoCampo(jogador.getPeca().obterLocalizacao(), valorDados);
		//Campo proximoCampo = this.tabuleiro.obterProximoCampo(this.tabuleiro.obterCampoInicial(), 2); // NÃO REMOVERLinha usada apenas para testes
		jogador.getPeca().mudarLocalizacao(proximoCampo);
		Teste.informaAvancoJogador(jogador);//remover-------------------------------------------

		jogador.getPeca().obterLocalizacao().addJogador(jogador); //Adiciona o jogador no Campo Atual

		try {
			this.executaAcaoCampo((EfeitoEspecial) proximoCampo, jogador); //Aciona o efeito especial para o Jogador...
		} catch (ClassCastException e) {
			System.out.println("Campo sem Ação!"); // Caso caia em Paradav Livre
		}
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

	public Map getJogadoresPresos() {
		return this.jogadoresPresos;
	}

	public Map getJogadoresAtivos() {
		return this.jogadoresAtivos;
	}
}
