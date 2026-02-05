package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

import UI.MyPanel;

public class Tack extends Structure{
    
    public Image tackImage = new ImageIcon("immagini/BTD1_towertack.png").getImage();
    MyPanel pannelloSuCuiLavorare;

    public Tack(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_towertack.png"));
        this.title = "  Tack Tower";
        this.cost = "325";
        this.speed = "Medium";
        this.description = "Shoots volley of tacks\nin 8 directions. Can\nupgrade its shoot\nspeed and its range.";
        this.raggioAzione = 100;
        this.pannelloSuCuiLavorare = p;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < pannelloSuCuiLavorare.B1A.size(); i++) {
                if (pannelloSuCuiLavorare.B1A.get(i).getX() > x-raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getX() < x+raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getY() > y-raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getY() < y+raggioAzione) {
                    System.out.println("Palloncino scoppiato");
                    pannelloSuCuiLavorare.B1A.remove(i);
                }
            }
            try {
                sleep(200);
            } catch (Exception e) {
                // TODO: handle exception
            }
            super.run();
        }
    }
}
