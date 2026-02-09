package Proiettili;

import java.awt.Rectangle;

import Bloons.Bloons;
import UI.MyPanel;

public class Darts extends Thread {

    int x, y;
    public double velX, velY;
    MyPanel pannello;
    boolean inVolo = true;

    public Darts(int monkeyX, int monkeyY, Bloons palloncino, MyPanel p) {

        this.x = monkeyX;
        this.y = monkeyY;
        this.pannello = p;

        //Calcolo della posizione del centro del bloon
        double targetX = palloncino.getX() + 15; 
        double targetY = palloncino.getY() + 21;

        //Calcolo della differenza di posizione tra la x e la y della scimmia e il bloon
        double diffX = targetX - monkeyX;
        double diffY = targetY - monkeyY;
        
        //Formula di pitagora per calcolare la distanza obliqua tra la scimmia e il bloon
        double distanza = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));

        //Imposta la velocità del dardo
        double velocitaDardo = 8.0;
        
        //Normalizzazione del vettore di direzione e moltiplicazione per la velocità del dardo
        this.velX = (diffX / distanza) * velocitaDardo;
        this.velY = (diffY / distanza) * velocitaDardo;

    }

    @Override
    public void run() {
        while (inVolo) {

            x += velX;
            y += velY;
            synchronized (pannello.bloonsArray) {
                for (int i = pannello.bloonsArray.size() - 1; i >= 0; i--) {

                    Bloons b = pannello.bloonsArray.get(i);
                    Rectangle hitBoxPalloncino = new Rectangle(b.getX(), b.getY(), 30, 42);

                    if (hitBoxPalloncino.contains(x,y)) {
                        pannello.PlaySound("PopBloon.wav");
                        pannello.bloonsArray.remove(i);
                        b.isColpito=true;
                        b.interrupt();
                        pannello.money++;
                        pannello.moneyLabelValue.setText(String.valueOf(pannello.money));
                        inVolo = false;
                        break;
                    }
                }
            }

            // Controllo se il dardo esce dal campo
            if (x < 0 || x > 580 || y < 0 || y > 600) 
                inVolo = false;

            pannello.repaint();

            try { Thread.sleep(20); } catch (InterruptedException e) {}

        }
        //Rimuove il dardo dall'array una volta che ha colpito un bloon o è uscita dal campo
        pannello.dartsArray.remove(this);
        pannello.repaint();

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
