package br.ufc.pds.factory.factory_campo;

import br.ufc.pds.model.campo.Campo;
import br.ufc.pds.model.campo.propriedade.Companhia;
import br.ufc.pds.model.jogador.Jogador;

public class FactoryCompanhia {

    private static FactoryCompanhia factoryCompanhia = null;

    private FactoryCompanhia() {}

    public static synchronized FactoryCompanhia getInstance() {
        if(factoryCompanhia == null) factoryCompanhia = new FactoryCompanhia();
        return factoryCompanhia;
    }

    public Campo criar(String nome, int indice, float preco, Jogador dono, float taxa, int eixoX, int eixoY) {
        return new Companhia(nome, indice, preco, dono, taxa, eixoX, eixoY);
    }
}
