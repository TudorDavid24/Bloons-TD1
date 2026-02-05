package Troops;
import javax.swing.ImageIcon;

import Bloons.Bloons;
import Proiettili.Darts;
import UI.MyPanel;

import java.awt.Image;

public class DartMonkey extends Structure{
    
    public Image dartMonkeyImage = new ImageIcon("immagini/BTD1_towerdart.png").getImage();
    ImageIcon dartMonkeyImageActive = new ImageIcon("immagini/BTD1_towerdartActive.png");
    public MyPanel pannelloSuCuiLavorare;

    public DartMonkey(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_towerdart.png"));
        this.title = "  Dart Tower";
        this.cost = "250";
        this.speed = "Fast";
        this.description = "Shoots a single dart.\nCan upgrade to\npiercing darts and\nlong range darts";
        this.raggioAzione = 100;
        this.pannelloSuCuiLavorare = p;
    }

@Override
public void run() {
    while (true) {

        for (int i = 0; i < pannelloSuCuiLavorare.B1A.size(); i++) {

            Bloons bersaglio = pannelloSuCuiLavorare.B1A.get(i);

            double dx = bersaglio.getX() - this.x;
            double dy = bersaglio.getY() - this.y;

            double distanza = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

            if (distanza <= raggioAzione) {

                this.angolo = Math.atan2(dy, dx);

                Darts dardo = new Darts(this.x, this.y, bersaglio, pannelloSuCuiLavorare);
                pannelloSuCuiLavorare.ArrayDardi.add(dardo);
                dardo.start();
                
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {}
                
                break;
            }
        }
        try { Thread.sleep(50); } catch (Exception e) {}
    }
}

}