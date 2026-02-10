package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

import Bloons.Bloons;
import UI.MyPanel;

import Proiettili.TacksBullets;

public class Tack extends Structure{
    
    public Image tackImage = new ImageIcon("immagini/BTD1_towertack.png").getImage();
    MyPanel pannello;

    public Tack(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_towertack.png"));
        this.title = "  Tack Tower";
        this.cost = "325";
        this.speed = "Medium";
        this.description = "Shoots volley of tacks\nin 8 directions. Can\nupgrade its shoot\nspeed and its range.";
        this.raggioAzione = 100;
        this.pannello = p;
    }

   @Override
public void run() {
    while (true) {

        // Controlla se c'è almeno un palloncino nel raggio
        for (int i = 0; i < pannello.bloonsArray.size(); i++) {

                Bloons palloncino = pannello.bloonsArray.get(i);

                //Calcolo della differenza di posizione tra la x e la y della struttura e il bloon
                double dx = palloncino.getX() - this.x;
                double dy = palloncino.getY() - this.y;

                //Formula di pitagora per calcolare la distanza obliqua tra la struttura e il bloon
                double distanza = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

                if (distanza <= raggioAzione) {

                    for (int k = 0; k < 360; k += 45) {
                        TacksBullets t = new TacksBullets(this.x + 23, this.y + 23, k, pannello);
                        pannello.tackArray.add(t);
                        t.start();
                    }

                    //Tempo di ricarica
                    try {
                        Thread.sleep(3000); 
                    } catch (InterruptedException e) {}
                }
            }
        
        try { Thread.sleep(100); } catch (Exception e) {}
    }
}
}
