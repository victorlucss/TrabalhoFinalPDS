package br.ufc.pds.entity;

import br.ufc.pds.controller.ControlCampos;
import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.entity.jogador.Banco;

import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {
    private Map<Integer, Campo> campos;
    private int qtdCampos;

    public Tabuleiro() {
        campos = new HashMap<>();
        this.qtdCampos = 40;
        this.criarCampos();
    }

    public Campo obterCampoInicial() {
        System.out.println("Esse é o nome: " + campos.get(1).getIndice());
        return campos.get(1);
    }

    public Campo obterProximoCampo(Campo inicio, int distancia) {
        if (inicio.getIndice()+distancia > 40) {
            return campos.get(inicio.getIndice()+distancia-this.qtdCampos);
        }
        return campos.get(inicio.getIndice()+distancia);
    }

    public void criarCampos() {
        ControlCampos controlCampos = new ControlCampos();
        this.campos = controlCampos.criarCampos();
    }
}
