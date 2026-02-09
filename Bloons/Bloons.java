package Bloons;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import UI.MyPanel;


public class Bloons extends Thread {
    
    public int TempoAttesa=10, TempoAttesaIni, x=-60, y=260;
    public Image ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
    public MyPanel pannello;
    public Boolean isCongelato = false;
    private int tempoCongelamento = 1500;
    public boolean isColpito = false;

    public Bloons(MyPanel p) {
        this.pannello = p;
    }

   @Override
    public void run() {
        try {
            sleep(TempoAttesaIni);
            for (int i = 0; i < 160 && !isColpito; i++) {
                x++;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 150 && !isColpito; i++) {
                y--;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 140 && !isColpito; i++) {
                x++;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 300 && !isColpito; i++) {
                y++;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 190 && !isColpito; i++) {
                x--;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 100 && !isColpito; i++) {
                y++;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 455 && !isColpito; i++) {
                x++;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 158 && !isColpito; i++) {
                y--;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 140 && !isColpito; i++) {
                x--;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 137 && !isColpito; i++) {
                y--;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 144 && !isColpito; i++) {
                x++;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 167 && !isColpito; i++) {
                y--;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 201 && !isColpito; i++) {
                x--;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            for (int i = 0; i < 80 && !isColpito; i++) {
                y--;
                sleep(TempoAttesa);
                pannello.repaint();
                if (isCongelato) {
                    sleep(tempoCongelamento);
                    isCongelato = false;
                    ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
                }
            }
            if (!isColpito) {
                pannello.bloonsArray.remove(this);
                pannello.lives--;
                pannello.livesLabelValue.setText(String.valueOf(pannello.lives));
            }
        }
    catch (InterruptedException e) {return;}
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setTempoAttesaIni(int tempoAttesaIni) {
        TempoAttesaIni = tempoAttesaIni;
    }
    public void setImmagineBloons(Image immagineBloons) {
        ImmagineBloons = immagineBloons;
    }
}
