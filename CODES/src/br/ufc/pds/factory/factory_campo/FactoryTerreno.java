package br.ufc.pds.factory.factory_campo;

import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.entity.campo.propriedade.terreno.*;
import br.ufc.pds.entity.jogador.Jogador;

public class FactoryTerreno {
    private static FactoryTerreno factoryTerreno = new FactoryTerreno();

    private FactoryTerreno() {}

    public static synchronized FactoryTerreno getInstance() {
        return factoryTerreno;
    }

    public Campo criar(int indice, Jogador dono, String tipoCampo) {
        if (tipoCampo.equals("AvAtlantica")) {
            return new AvAtlantica(indice, dono);
        } else if (tipoCampo.equals("AvBrasil")) {
            return new AvBrasil(indice, dono);
        } else if (tipoCampo.equals("AvBrigadeiroLima")) {
            return new AvBrigadeiroFariaLima(indice, dono);
        } else if (tipoCampo.equals("AvNossaSCopacabana")) {
            return new AvNossaSDeCopacabana(indice, dono);
        } else if (tipoCampo.equals("AvNoveDeJulho")) {
            return new AvNoveDeJulho(indice, dono);
        } else if (tipoCampo.equals("AvPacaembu")) {
            return new AvPacaembu(indice, dono);
        } else if (tipoCampo.equals("AvPaulista")) {
            return new AvPaulista(indice, dono);
        } else if (tipoCampo.equals("AvPresidenteVargas")) {
            return new AvPresidenteVargas(indice, dono);
        } else if (tipoCampo.equals("AvReboucas")) {
            return new AvReboucas(indice, dono);
        } else if (tipoCampo.equals("AvVieiraSouto")) {
            return new AvVieiraSouto(indice, dono);
        } else if (tipoCampo.equals("Botafogo")) {
            return new Botafogo(indice, dono);
        } else if (tipoCampo.equals("Brooklin")) {
            return new Brooklin(indice, dono);
        } else if (tipoCampo.equals("Copacabana")) {
            return new Copacabana(indice, dono);
        } else if (tipoCampo.equals("Flamengo")) {
            return new Flamengo(indice, dono);
        } else if (tipoCampo.equals("Interlagos")) {
            return new Interlagos(indice, dono);
        } else if (tipoCampo.equals("Ipanema")) {
            return new Ipanema(indice, dono);
        } else if (tipoCampo.equals("JardimEuropa")) {
            return new JardimEuropa(indice, dono);
        } else if (tipoCampo.equals("JardimPaulista")) {
            return new JardimPaulista(indice, dono);
        } else if (tipoCampo.equals("Leblon")) {
            return new Leblon(indice, dono);
        } else if (tipoCampo.equals("Morumbi")) {
            return new Morumbi(indice, dono);
        } else if (tipoCampo.equals("RuaAugusta")) {
            return new RuaAugusta(indice, dono);
        }  else if (tipoCampo.equals("AvEuropa")) {
            return new AvEuropa(indice, dono);
        }
        return null;
    }
}
