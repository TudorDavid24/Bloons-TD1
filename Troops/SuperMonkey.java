package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

import UI.MyPanel;

public class SuperMonkey extends Structure{
    
    public Image superMonkeyImage = new ImageIcon("immagini/BTD1_towersuper.png").getImage();
    MyPanel pannelloSuCuiLavorare;

    public SuperMonkey(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_towersuper.png"));
        this.title = "Super Monkey";
        this.cost = "4000";
        this.speed = "Hypersonic";
        this.description = "Super monkey shoots\na continuous stream\nof darts and can mow\ndown even the fastes\nand most stubborn\nbloons.";
        this.raggioAzione = 30;
        this.pannelloSuCuiLavorare = p;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < pannelloSuCuiLavorare.B1A.size(); i++) {
                if (pannelloSuCuiLavorare.B1A.get(i).getX() > x-raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getX() < x+raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getY() > y-raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getY() < y+raggioAzione) {
                    System.out.println("Palloncino scoppiato");
                    pannelloSuCuiLavorare.B1A.remove(i);
                    try {
                        sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            super.run();
        }
    }
}
