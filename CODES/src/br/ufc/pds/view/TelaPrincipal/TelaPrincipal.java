package br.ufc.pds.view.TelaPrincipal;

import JGamePlay.GameImage;
import JGamePlay.Window;
import br.ufc.pds.pojo.Peca;

public class TelaPrincipal {
    private Window janelaPrincipal;
    private GameImage background;
    private static TelaPrincipal telaPrincipal = new TelaPrincipal();

    private TelaPrincipal() {
        this.janelaPrincipal = new Window(700, 700);
        this.background = new GameImage("resources//preview.png");
    }

    public static synchronized TelaPrincipal getInstance() {
        return telaPrincipal;
    }

    public void drawBackgroud() {
        this.background.draw();
    }

    public void displayJanelaPrincipal() {
        this.janelaPrincipal.display();
    }

    public void renderPeca(Peca pecaLoc) {
        GameImage peca = new GameImage("resources//pecas//"+ pecaLoc.getCor() +".png");
        peca.setPosition(pecaLoc.obterLocalizacao().getEixoX(), pecaLoc.obterLocalizacao().getEixoY());
        peca.draw();
    }
}
