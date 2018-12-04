package br.ufc.pds.entity.campo.campo_especial;

import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.view.MensagemCamposDeAcao;


public abstract class CampoEspecial extends Campo {

    protected CampoEspecial(String nome, int indice, int eixoX, int eixoY) {
        super(nome, indice, eixoX, eixoY);
    }

    protected void showMensagem(String titulo, String acao){
        MensagemCamposDeAcao ms = new MensagemCamposDeAcao(titulo, acao);
        ms.setVisible(true);
    }
}
