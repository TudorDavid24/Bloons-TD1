package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;
import UI.MyPanel;

public class BombTower extends Structure{
    
    public Image bombMonkeyImage = new ImageIcon("immagini/BTD1_TowerBomb.png").getImage();
    MyPanel pannelloSuCuiLavorare;

    public BombTower(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_TowerBomb.png"));
        this.title = "  Bomb Tower";
        this.cost = "900";
        this.speed = "Medium";
        this.description = "Launches a bomb\nthat explodes on\nimpact. Can upgrade\nto bigger bomb and\nlonger range.";
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