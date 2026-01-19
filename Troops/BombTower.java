package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BombTower extends Structure{
    
    public Image bombMonkeyImage = new ImageIcon("immagini/BTD1_TowerBomb.png").getImage();

    public BombTower() {
        this.title = "  Bomb Tower";
        this.cost = "900";
        this.speed = "Medium";
        this.description = "Launches a bomb\nthat explodes on\nimpact. Can upgrade\nto bigger bomb and\nlonger range.";
        this.raggioAzione = 30;
    }
}