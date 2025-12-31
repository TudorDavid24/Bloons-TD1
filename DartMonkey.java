import javax.swing.ImageIcon;
import java.awt.Image;

public class DartMonkey extends Structure{
    
    Image dartMonkeyImage = new ImageIcon("BTD1_towerdart.png").getImage();

    public DartMonkey() {
        this.title = "  Dart Tower";
        this.cost = "250";
        this.speed = "Fast";
        this.description = "Shoots a single dart.\nCan upgrade to\npiercing darts and\nlong range darts";
        this.raggioAzione = 30;
    }
}
