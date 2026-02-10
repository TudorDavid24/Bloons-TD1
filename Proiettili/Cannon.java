package Proiettili;

import java.awt.Rectangle;

import Bloons.Bloons;
import UI.MyPanel;

public class Cannon extends Thread {

    int x, y;
    public double velX, velY;
    MyPanel pannello;
    boolean inVolo = true;

    public Cannon(int monkeyX, int monkeyY, Bloons palloncino, MyPanel p) {

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

        //Imposta la velocità della palla di cannone
        double velocitaDardo = 8.0;
        
        //Normalizzazione del vettore di direzione e moltiplicazione per la velocità del dardo
        this.velX = (diffX / distanza) * velocitaDardo;
        this.velY = (diffY / distanza) * velocitaDardo;

    }

    @Override
    public void run() {

        //Dimensione del raggio di esplosione
        int raggioEsplosione = 35;

        while (inVolo) {

            x += velX;
            y += velY;

            //Controllo se la palla di cannone colpisce un bloon
            boolean impatto = false;
            synchronized (pannello.bloonsArray) {
                for (int i = 0; i < pannello.bloonsArray.size(); i++) {

                    Bloons b = pannello.bloonsArray.get(i);
                    Rectangle hitBoxPalloncino = new Rectangle(b.getX(), b.getY(), 30, 42);

                    if (hitBoxPalloncino.contains(x,y)) {
                        pannello.PlaySound("CannonExplosion.wav");
                        impatto = true;
                        break;
                    }
                }

                if (impatto) {

                    Rectangle areaEsplosione = new Rectangle(x - raggioEsplosione, y - raggioEsplosione, raggioEsplosione * 2, raggioEsplosione * 2);

                    for (int i = pannello.bloonsArray.size() - 1; i >= 0; i--) {
                        Bloons b = pannello.bloonsArray.get(i);
                        if (areaEsplosione.intersects(new Rectangle(b.getX(), b.getY(), 30, 42))) {
                            pannello.bloonsArray.remove(i);
                            b.isColpito=true;
                            b.interrupt();
                            pannello.money++;
                            pannello.moneyLabelValue.setText(String.valueOf(pannello.money));
                        }
                    }
                    
                    inVolo = false;
                }
            }

            // Controllo se la palla di canncone esce dal campo
            if (x < 0 || x > 580 || y < 0 || y > 600) 
                inVolo = false;

            pannello.repaint();
            try { Thread.sleep(20); } catch (InterruptedException e) {}

        }
        //Rimuove la palla di cannone dall'array una volta che ha colpito un bloon o è uscita dal campo
        pannello.cannonBallsArray.remove(this);
        pannello.repaint();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
