package Troops;
import javax.swing.ImageIcon;

import java.awt.Image;

public class DartMonkey extends Structure{
    
    public Image dartMonkeyImage = new ImageIcon("immagini/BTD1_towerdart.png").getImage();

    public DartMonkey() {
        super(new ImageIcon("immagini/BTD1_towerdart.png"));
        this.title = "  Dart Tower";
        this.cost = "250";
        this.speed = "Fast";
        this.description = "Shoots a single dart.\nCan upgrade to\npiercing darts and\nlong range darts";
        this.raggioAzione = 30;
    }
}
