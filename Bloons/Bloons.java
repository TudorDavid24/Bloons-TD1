package Bloons;
import java.awt.Image;

import UI.MyPanel;


public class Bloons extends Thread {
    
    public int tipo, speed, x, y;
    public Image ImmagineBloons;

    public MyPanel pannelloSuCuiLavorare;


    @Override
    public void run() {

        while(true){
            if (x < 90 && y > 255 && y < 312) {
                x += speed;
            } 
            else if (x >= 90 && x < 140 && y > 140) {
                y -= speed;
            } 
            else if (x >= 90 && x < 140 && y <= 140) {
                x += speed;
            }
            else if (x >= 140 && x < 225 && y <= 150) {
                x += speed;
            }
            else if (x >= 225 && y < 413) {
                y += speed;
            }
            else if (x > 94 && y >= 413) {
                x -= speed;
            }
            else if (x <= 94 && y < 505) {
                y += speed;
            }
            else if (x < 492 && y >= 505) {
                x += speed;
            }
            else if (x >= 492 && y > 405) {
                y -= speed;
            }
            else if (x > 400 && y <= 405) {
                x -= speed;
            }
            else if (x <= 400 && y > 260) {
                y -= speed;
            }
            else if (x < 495 && y <= 260) {
                x += speed;
            }
            else if (x >= 495 && y > 93) {
                y -= speed;
            }
            else if (x > 345 && y <= 93) {
                x -= speed;
            }
            else if (x <= 345) {
                y -= speed;
            }
            
            pannelloSuCuiLavorare.repaint();
            
            try {
                sleep(33);
            } catch (Exception e) {}
        }
    }

}
