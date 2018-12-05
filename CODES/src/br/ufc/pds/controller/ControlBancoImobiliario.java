package br.ufc.pds.controller;

import br.ufc.pds.Teste;
import br.ufc.pds.interfaces.ObserverJogador;
import br.ufc.pds.model.Tabuleiro;
import br.ufc.pds.model.campo.Campo;
import br.ufc.pds.model.campo.EfeitoEspecial;
import br.ufc.pds.model.campo.propriedade.Propriedade;
import br.ufc.pds.model.campo.propriedade.Terreno;
import br.ufc.pds.model.jogador.Banco;
import br.ufc.pds.model.jogador.JogadorHumano;
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

public class ControlBancoImobiliario implements ObserverJogador {
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

        this.tabuleiro.getCampos().forEach((key, value) -> {
        	if (value instanceof Terreno && ((Terreno) value).getDono() != Banco.getInstance())
        		this.telaPrincipal.renderCasasHoteis((Terreno) value);

        	if (value instanceof Propriedade && ((Propriedade) value).getDono() != Banco.getInstance())
				this.telaPrincipal.renderProprietario((Propriedade)value);
		});

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
		jogadorHumano.addObserver(this);
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
            jogador.getFichaCriminal().setRodadasPreso(0);
            this.alterarPosicaoDoJogador(jogador);
            JOptionPane.showMessageDialog(null, jogador.getNome() + " saiu da Prisão (Dados Iguais)");

        } else if (jogador.getFichaCriminal().getRodadasPreso() >= 3) {
            jogador.getContaBancaria().pagar(50); //IMPLEMENTAR QUANDO O JOGADOR NÃO TIVER MAIS CONDIÇÕES PARA PAGAR
            Banco.getInstance().receber(50);
			this.soltarJogador(jogador);
			jogador.getFichaCriminal().setRodadasPreso(0);
			this.alterarPosicaoDoJogador(jogador);
            JOptionPane.showMessageDialog(null, jogador.getNome() + " saiu da Prisão (Pagou R$ 50,00 ao Banco)");
        } else {
            int delitos = jogador.getFichaCriminal().getRodadasPreso() + 1;
            System.out.println(delitos + " - " + jogador.getNome());
            jogador.getFichaCriminal().setRodadasPreso(delitos);
            JOptionPane.showMessageDialog(null, jogador.getNome() + " continuará Preso");
        }
	}


	private void jogadorRealizaTurno(JogadorHumano jogador) {
		if (jogador.getFichaCriminal().getNumDelitos()>=3){
			JOptionPane.showMessageDialog(null, jogador.getNome() + " preso por trapacear.");
			this.prenderJogador(jogador);
			jogador.getFichaCriminal().setNumDelitos(0);
		} else {
			Campo proximoCampo = this.alterarPosicaoDoJogador(jogador);

			try {
				this.executaAcaoCampo((EfeitoEspecial) proximoCampo, jogador); //Aciona o efeito especial para o Jogador...
			} catch (ClassCastException e) {
				System.out.println("Campo sem Ação!"); // Caso caia em Paradav Livre
			}
		}
	}

	private Campo alterarPosicaoDoJogador(JogadorHumano jogador) {
		int valorDados = jogador.getDados()[0].obterValorDaFace() + jogador.getDados()[1].obterValorDaFace();

        jogador.getPeca().obterLocalizacao().removerJogador(jogador); //Remove o jogador do campo em que ele estava

        Campo proximoCampo = this.tabuleiro.obterProximoCampo(jogador.getPeca().obterLocalizacao(), valorDados);
//        Campo proximoCampo = this.tabuleiro.obterProximoCampo(this.tabuleiro.obterCampoInicial(), 5); // NÃO REMOVERLinha usada apenas para testes
        jogador.getPeca().mudarLocalizacao(proximoCampo);
        Teste.informaAvancoJogador(jogador);//remover-------------------------------------------

        jogador.getPeca().obterLocalizacao().addJogador(jogador); //Adiciona o jogador no Campo Atual
        this.renderizarTelaPrincipal(); // Atualiza posição do jogador no Tabuleiro

        return proximoCampo;
    }

	private void executaAcaoCampo(EfeitoEspecial campo, JogadorHumano jogador) {
		if (campo!=null) {
			//System.out.println("Testando Aplicar Efeito");
			campo.aplicarEfeito(jogador);

			if (jogador.getDados()[0].obterValorDaFace() == jogador.getDados()[1].obterValorDaFace()){
				JogadorDaVez jdv = new JogadorDaVez(jogador.getNome() + " Jogando (Dados Iguais)", "Propriedades: " + jogador.getPropriedades().size(), "Saldo: R$ " + jogador.getContaBancaria().getSaldo(), "Status: Jogador Livre");
				jdv.setVisible(true);
				jogador.lancarDados();
				jogador.getFichaCriminal().setNumDelitos(jogador.getFichaCriminal().getNumDelitos()+1);
				this.jogadorRealizaTurno(jogador);

			} else {
				jogador.getFichaCriminal().setNumDelitos(0);
			}
		}
	}

	public void prenderJogador(JogadorHumano jogador) {
		this.tabuleiro.buscarCampo(11).addJogador(jogador); // 11 é o índice da prisão
		this.jogadoresPresos.put(jogador.getId(), jogador);
	}

	public void soltarJogador(JogadorHumano jogador) {
		this.tabuleiro.buscarCampo(11).removerJogador(jogador); // 11 é o índice da prisão
		this.jogadoresPresos.remove(jogador.getId());
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

	public boolean validarConstrucaoCasa(JogadorHumano jogador, Terreno terreno){
		ArrayList<Campo> camposIndisponiveis = new ArrayList<>();

		this.tabuleiro.getCampos().forEach((key, campo) -> {
			if (campo instanceof Terreno) {
				if (((Terreno) campo).getCor().equals(terreno.getCor())) {
					System.out.println("Terreno Atual: "+terreno.getNumCasas()+" - " + "Terreno Iterado: "+((Terreno) campo).getNumCasas());
					if(!jogador.equals(((Terreno)campo).getDono()) || terreno.getNumCasas() > ((Terreno) campo).getNumCasas()) {
						camposIndisponiveis.add(campo);
					}
				}
			}
		});

		return camposIndisponiveis.isEmpty();
	}

	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}

	public void changeHasSetedNumJogadores(){
		this.hasSetedNumJogadores = true;
	}

	@Override
	public void update(JogadorHumano jogador) {
		System.out.println("Tem que se antes");
	}
}
