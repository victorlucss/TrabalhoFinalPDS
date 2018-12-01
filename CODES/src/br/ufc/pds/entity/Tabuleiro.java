package br.ufc.pds.entity;

import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.factory.factory_campo.IFactoryCampo;

import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {
    private Map<Integer, Campo> campos;
    private int qtdCampos;
    private IFactoryCampo iFactoryCampo; //não instanciado

    public Tabuleiro() {
        campos = new HashMap<>();
        this.qtdCampos = 40;
    }

    public Campo obterCampoInicial() {
        return null;
    }

    public Campo obterProximoCampo(Campo inicio, int distancia) {
        return null;
    }

    public void criarCampos() {

    }
}
