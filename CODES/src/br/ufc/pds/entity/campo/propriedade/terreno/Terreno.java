package br.ufc.pds.entity.campo.propriedade.terreno;

import br.ufc.pds.entity.campo.propriedade.Propriedade;
import br.ufc.pds.entity.jogador.JogadorHumano;

public class Terreno extends Propriedade {

	protected String cor;
	protected float aluguel;
	protected int numCasas;
	protected float precoCasa;
	protected float precoHotel;
	protected boolean hasHotel;
	protected float aluguel1Casas;
	protected float aluguel2Casas;
	protected float aluguel3Casas;
	protected float aluguel4Casas;
	protected float aluguelHotel;

	public float getAluguel() {
		if (numCasas == 1) {
			return aluguel1Casas;
		} else if (numCasas == 2) {
			return aluguel2Casas;
		} else if (numCasas == 3) {
			return aluguel3Casas;
		} else if (numCasas == 4) {
			return aluguel4Casas;
		} else {
			return aluguel;
		}
	}
}
