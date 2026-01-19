package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SuperMonkey extends Structure{
    
    public Image superMonkeyImage = new ImageIcon("immagini/BTD1_towersuper.png").getImage();

    public SuperMonkey() {
        this.title = "Super Monkey";
        this.cost = "4000";
        this.speed = "Hypersonic";
        this.description = "Super monkey shoots\na continuous stream\nof darts and can mow\ndown even the fastes\nand most stubborn\nbloons.";
        this.raggioAzione = 30;
    }
}
