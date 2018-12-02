package br.ufc.pds.controller;

import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.entity.jogador.Banco;
import br.ufc.pds.entity.jogador.Jogador;
import br.ufc.pds.factory.factory_campo.FactoryCampoEspecial;
import br.ufc.pds.factory.factory_campo.FactoryCompanhia;
import br.ufc.pds.factory.factory_campo.FactoryTerreno;

import java.util.HashMap;
import java.util.Map;

public class ControlCampos {

    public ControlCampos() {

    }

    public Map criarCampos() {
        Map<Integer, Campo> campos = new HashMap<>();
        Jogador dono = Banco.getInstance();

        campos.put(1, FactoryCampoEspecial.getInstance().criar("PontoDePartida", 1));
        campos.put(2, FactoryTerreno.getInstance().criar(2, dono, "Leblon"));
        campos.put(3, FactoryCampoEspecial.getInstance().criar("SorteOuReves", 3));
        campos.put(4, FactoryTerreno.getInstance().criar(4, dono, "AvPresidenteVargas"));
        campos.put(5, FactoryTerreno.getInstance().criar(5, dono, "AvNossaSCopacabana"));
        campos.put(6, FactoryCompanhia.getInstance().criar("COMPANHIA FERROVIÁRIA", 6, 200, dono, 50));
        campos.put(7, FactoryTerreno.getInstance().criar(7, dono, "AvBrigadeiroLima"));
        campos.put(8, FactoryCompanhia.getInstance().criar("COMPANHIA DE VIAÇÃO", 8, 200, dono, 50));
        campos.put(9, FactoryTerreno.getInstance().criar(9, dono, "AvReboucas"));
        campos.put(10, FactoryTerreno.getInstance().criar(10, dono, "AvNoveDeJulho"));
        campos.put(11, FactoryCampoEspecial.getInstance().criar("Prisao", 11));
        campos.put(12, FactoryTerreno.getInstance().criar(12, dono, "AvEuropa"));
        campos.put(13, FactoryCampoEspecial.getInstance().criar("SorteOuReves", 13));
        campos.put(14, FactoryTerreno.getInstance().criar(14, dono, "RuaAugusta"));
        campos.put(15, FactoryTerreno.getInstance().criar(15, dono, "AvPacaembu"));
        campos.put(16, FactoryCompanhia.getInstance().criar("COMPANHIA DE TAXI", 16, 150, dono, 40));
        campos.put(17, FactoryCampoEspecial.getInstance().criar("SorteOuReves", 17));
        campos.put(18, FactoryTerreno.getInstance().criar(18, dono, "Interlagos"));
        campos.put(19, FactoryCampoEspecial.getInstance().criar("LucrosDividendos", 19));
        campos.put(20, FactoryTerreno.getInstance().criar(20, dono, "Morumbi"));
        campos.put(21, FactoryCampoEspecial.getInstance().criar("ParadaLivre", 21));
        campos.put(22, FactoryTerreno.getInstance().criar(22, dono, "Flamengo"));
        campos.put(23, FactoryCampoEspecial.getInstance().criar("SorteOuReves", 22));
        campos.put(24, FactoryTerreno.getInstance().criar(24, dono, "Botafogo"));
        campos.put(25, FactoryCampoEspecial.getInstance().criar("ImpostoDeRenda", 25));
        campos.put(26, FactoryCompanhia.getInstance().criar("COMPANHIA DE NAVEGAÇÃO", 26, 150, dono, 40));
        campos.put(27, FactoryTerreno.getInstance().criar(27, dono, "AvBrasil"));
        campos.put(28, FactoryCampoEspecial.getInstance().criar("SorteOuReves", 28));
        campos.put(29, FactoryTerreno.getInstance().criar(29, dono, "AvPaulista"));
        campos.put(30, FactoryTerreno.getInstance().criar(30, dono, "JardimEuropa"));
        campos.put(31, FactoryCampoEspecial.getInstance().criar("VaParaPrisao", 31));
        campos.put(32, FactoryTerreno.getInstance().criar(32, dono, "Copacabana"));
        campos.put(33, FactoryCompanhia.getInstance().criar("COMPANHIA DE AVIAÇÃO", 33, 200, dono, 50));
        campos.put(34, FactoryTerreno.getInstance().criar(34, dono, "AvVieiraSouto"));
        campos.put(35, FactoryTerreno.getInstance().criar(35, dono, "AvAtlantica"));
        campos.put(36, FactoryCompanhia.getInstance().criar("COMPANHIA DE TAXI AÉRIO", 36, 200, dono, 50));
        campos.put(37, FactoryTerreno.getInstance().criar(37, dono, "Ipanema"));
        campos.put(38, FactoryCampoEspecial.getInstance().criar("SorteOuReves", 38));
        campos.put(39, FactoryTerreno.getInstance().criar(39, dono, "Brooklin"));
        campos.put(40, FactoryTerreno.getInstance().criar(40, dono, "JardimPaulista"));

        return campos;
    }
}
