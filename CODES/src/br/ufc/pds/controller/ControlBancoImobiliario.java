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
import br.ufc.pds.view.EntraComJogador;
import br.ufc.pds.view.SelecionarQuantidadeDeJogadoresPanel;

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

//		this.numJogadores = this.getNumJogadores();


		for(int i=1; i<=this.numJogadores; i++) {

			EntraComJogador entraComJogador = new EntraComJogador();

			entraComJogador.run();


		}
//
//		while(true) {
//			this.iniciarRodada();
//		}
	}

	public void adicionarJogador(String jogador, String cor){
		System.out.println(jogador+" "+cor);
		int indice = jogadoresAtivos.size();
		JogadorHumano jogadorHumano = new JogadorHumano(indice, jogador, new Peca(cor, this.tabuleiro.obterCampoInicial()), this.dados);
					this.jogadoresAtivos.put(indice, jogadorHumano);
			this.tabuleiro.obterCampoInicial().addJogador(jogadorHumano);
	}

	public ArrayList<String> getCores(){
		String[] cores = {"Azul", "Preto", "Roxo", "Verde","Amarelo","Laranja"};
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
