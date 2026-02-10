package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

import Bloons.Bloons;
import Proiettili.Darts;
import UI.MyPanel;

public class SuperMonkey extends Structure{
    
    public Image superMonkeyImage = new ImageIcon("immagini/BTD1_towersuper.png").getImage();
    MyPanel pannello;

    public SuperMonkey(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_towersuper.png"));
        this.title = "Super Monkey";
        this.cost = "1500";
        this.speed = "Hypersonic";
        this.description = "Super monkey shoots\na continuous stream\nof darts and can mow\ndown even the fastes\nand most stubborn\nbloons.";
        this.raggioAzione = 250;
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
                this.angolo = Math.atan2(dy, dx)+90;
                Darts d = new Darts(this.x, this.y, palloncino, pannello);
                pannello.dartsArray.add(d);
                d.start();
                
                try {
                    Thread.sleep(150); 
                } catch (InterruptedException e) {}
                
            }
        }
        try { Thread.sleep(50); } catch (Exception e) {}
    }
    }
}
