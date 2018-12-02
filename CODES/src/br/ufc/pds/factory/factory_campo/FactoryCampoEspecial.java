package br.ufc.pds.factory.factory_campo;

import br.ufc.pds.entity.campo.Campo;
import br.ufc.pds.entity.campo.campo_especial.*;

public class FactoryCampoEspecial {
    private static FactoryCampoEspecial factoryCampoEspecial = new FactoryCampoEspecial();

    private FactoryCampoEspecial() {}

    public static synchronized FactoryCampoEspecial getInstance() {
        return factoryCampoEspecial;
    }

    public Campo criar(String tipoCampo, int indice) {
        if (tipoCampo.equals("PontoDePartida")) {
            return new PontoDePartida(indice);
        } else if (tipoCampo.equals("ImpostoDeRenda")) {
            return new ImpostoDeRenda(indice);
        } else if (tipoCampo.equals("LucrosDividendos")) {
            return new LucrosDividendos(indice);
        } else if (tipoCampo.equals("ParadaLivre")) {
            return new ParadaLivre(indice);
        } else if (tipoCampo.equals("VaParaPrisao")) {
            return new VaParaPrisao(indice);
        } else if (tipoCampo.equals("Prisao")) {
            return new Prisao(indice);
        } else if (tipoCampo.equals("SorteOuReves")) {
            return new SorteOuReves(indice);
        }
        return null;
    }
}
