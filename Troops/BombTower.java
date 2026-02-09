package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

import Bloons.Bloons;
import Proiettili.Cannon;
import UI.MyPanel;

public class BombTower extends Structure{
    
    public Image bombMonkeyImage = new ImageIcon("immagini/BTD1_TowerBomb.png").getImage();
    MyPanel pannello;

    public BombTower(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_TowerBomb.png"));
        this.title = "  Bomb Tower";
        this.cost = "900";
        this.speed = "Medium";
        this.description = "Launches a bomb\nthat explodes on\nimpact. Can upgrade\nto bigger bomb and\nlonger range.";
        this.raggioAzione = 300;
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

                    pannello.cannonBallsArray.add(new Cannon(this.x, this.y, palloncino, pannello));
                    pannello.cannonBallsArray.getLast().start();
                    
                    //Tempo di ricarica
                    try {
                        Thread.sleep(3000); 
                    } catch (InterruptedException e) {}
                    
                }
            }
            try { Thread.sleep(50); } catch (Exception e) {}
        }
    }
}