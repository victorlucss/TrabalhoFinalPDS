package br.ufc.pds.factory.factory_campo;

import br.ufc.pds.entity.campo.Campo;

public class FactoryCampoEspecial implements IFactoryCampo {
    private static FactoryCampoEspecial factoryCampoEspecial = new FactoryCampoEspecial();

    private FactoryCampoEspecial() {}

    private static synchronized FactoryCampoEspecial getInstance() {
        return factoryCampoEspecial;
    }

    @Override
    public Campo criar() {
        return null;
    }
}
