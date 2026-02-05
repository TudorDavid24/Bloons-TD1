package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

import UI.MyPanel;

public class IceTower extends Structure{
    
    public Image iceTowerImage = new ImageIcon("immagini/BTD1_towerice.png").getImage();
    MyPanel pannelloSuCuiLavorare;

    public IceTower(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_towerice.png"));
        this.title = "    Ice Tower";
        this.cost = "850";
        this.speed = "Slow";
        this.description = "Freezes nearby\nbloons. Frozen bloons\nare immune to darts\nand tacks, but bombs\nwill destroy them. Can\nupgrade to increased\nfreeze time, and\nlarger freeze radius";
        this.raggioAzione = 100;
        this.pannelloSuCuiLavorare = p;
    }

    @Override
    public void run() {
while (true) {
            for (int i = 0; i < pannelloSuCuiLavorare.B1A.size(); i++) {
                if (pannelloSuCuiLavorare.B1A.get(i).getX() > x-raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getX() < x+raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getY() > y-raggioAzione && pannelloSuCuiLavorare.B1A.get(i).getY() < y+raggioAzione) {
                    System.out.println("Palloncino congelato");
                    pannelloSuCuiLavorare.B1A.get(i).isCongelato=true;
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            super.run();
        }
    }
}
