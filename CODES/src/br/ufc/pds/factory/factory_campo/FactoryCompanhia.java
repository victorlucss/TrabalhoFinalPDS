package br.ufc.pds.factory.factory_campo;

import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.entity.campo.propriedade.Companhia;
import br.ufc.pds.entity.jogador.Jogador;

public class FactoryCompanhia {

    private static FactoryCompanhia factoryCompanhia = new FactoryCompanhia();

    private FactoryCompanhia() {}

    public static synchronized FactoryCompanhia getInstance() {
        return factoryCompanhia;
    }

    public Campo criar(String nome, int indice, float preco, Jogador dono, float taxa) {
        return new Companhia(nome, indice, preco, dono, taxa);
    }
}
