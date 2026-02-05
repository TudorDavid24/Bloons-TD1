package Proiettili;

import java.awt.Rectangle;

import Bloons.Bloons;
import UI.MyPanel;

public class Darts extends Thread {

    int x, y; // Coordinate attuali del dardo
    public int bloonX, bloonY;
    public double velX, velY;
    MyPanel pannello;
    boolean inVolo = true;

    public Darts(int monkeyX, int monkeyY, Bloons target, MyPanel p) {
        this.x = monkeyX;
        this.y = monkeyY;
        this.pannello = p;

        double diffX = target.getX() - monkeyX;
        double diffY = target.getY() - monkeyY;
        double distanza = Math.sqrt(diffX*diffX + diffY*diffY);
        
        this.velX = (diffX / distanza) * 5;
        this.velY = (diffY / distanza) * 5;
    }

    @Override
    public void run() {
        while (inVolo) {
            x += velX;
            y += velY;

            for (int i = 0; i < pannello.B1A.size(); i++) {
                Bloons b = pannello.B1A.get(i);
                Rectangle hitBoxPalloncino = new Rectangle(b.getX(), b.getY(), 30, 42);
                bloonX=b.getX();
                bloonY=b.getY();
                if (hitBoxPalloncino.contains(x, y)) {
                    pannello.B1A.remove(i); 
                    inVolo = false;
                    break;
                }
            }

            // Uscita dallo schermo
            if (x < 0 || x > 580 || y < 0 || y > 600) 
                inVolo = false;

            pannello.repaint(); 
            try { Thread.sleep(20); } catch (InterruptedException e) {}
        }
        pannello.ArrayDardi.remove(this); // Rimuoviti dalla lista una volta finito
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
