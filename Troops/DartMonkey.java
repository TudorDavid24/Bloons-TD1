package Troops;
import javax.swing.ImageIcon;

import Bloons.Bloons;
import Proiettili.Darts;
import UI.MyPanel;

import java.awt.Image;

public class DartMonkey extends Structure{
    
    public Image dartMonkeyImage = new ImageIcon("immagini/BTD1_towerdart.png").getImage();
    ImageIcon dartMonkeyImageActive = new ImageIcon("immagini/BTD1_towerdartActive.png");
    public MyPanel pannello;

    public DartMonkey(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_towerdart.png"));
        this.title = "  Dart Tower";
        this.cost = "250";
        this.speed = "Fast";
        this.description = "Shoots a single dart.\nCan upgrade to\npiercing darts and\nlong range darts";
        this.raggioAzione = 100;
        this.pannello = p;
    }

    @Override
    public void run() {
        while (true) {

            for (int i = 0; i < pannello.bloonsArray.size(); i++) {

                Bloons palloncino = pannello.bloonsArray.get(i);

                //Calcolo della differenza di posizione tra la x e la y della struttura e il bloon
                double dx = palloncino.getX() - this.x;
                double dy = palloncino.getY() - this.y;

                //Formula di pitagora per calcolare la distanza obliqua tra la struttura e il bloon
                double distanza = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

                if (distanza <= raggioAzione) {

                    //Calcolo dell'angolo di direzione della struttura
                    this.angolo = Math.atan2(dy, dx) + 90;

                    pannello.dartsArray.add(new Darts(this.x, this.y, palloncino, pannello));
                    pannello.dartsArray.getLast().start();
                    
                    //Tempo di ricarica
                    try {
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) {}
                    
                }
            }
            try { Thread.sleep(50); } catch (Exception e) {}
        }
    }

}