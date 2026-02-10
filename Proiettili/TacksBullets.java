package Proiettili;

import java.awt.Rectangle;

import Bloons.Bloons;
import UI.MyPanel;

public class TacksBullets extends Thread {
    double x, y; 

    public double velX, velY;
    MyPanel pannello;
    boolean inVolo = true;
    Rectangle areaMaxDardo;

    public TacksBullets(int startX, int startY, double gradi, MyPanel p) {
        this.x = startX;
        this.y = startY;
        this.pannello = p;

        //Transforma in radianti i gradi passati
        double radianti = Math.toRadians(gradi);

        //Imposta la velocità del Tack
        double velocita = 6.0;

        //Normalizzazione del vettore di direzione e moltiplicazione per la velocità del dardo
        this.velX = Math.cos(radianti) * velocita;
        this.velY = Math.sin(radianti) * velocita;

        //Definizione dell'area massima in cui il Tack può muoversi
        areaMaxDardo = new Rectangle(startX - 75, startY - 75, 150, 150);
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

                    if (hitBoxPalloncino.contains(x, y)) {
                        pannello.PlaySound("PopBloon.wav");
                        b.isColpito=true;
                        pannello.bloonsArray.remove(i);
                        b.interrupt();
                        pannello.money++;
                        pannello.moneyLabelValue.setText(String.valueOf(pannello.money));
                        inVolo = false;
                        break;
                    }
                }
            }
            // Uscita dall'area massima del Tack
            if (x < areaMaxDardo.x || x > areaMaxDardo.x + areaMaxDardo.width || y < areaMaxDardo.y || y > areaMaxDardo.y + areaMaxDardo.height)
                inVolo = false;

            pannello.repaint();
            try { Thread.sleep(20); } catch (InterruptedException e) {}
        }
        //Rimuove il Tack dall'array una volta che ha colpito un bloon o è uscita dall'area massima
        pannello.tackArray.remove(this);
        pannello.repaint();
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}