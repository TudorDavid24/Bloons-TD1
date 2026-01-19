package Troops;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tack extends Structure{
    
    public Image tackImage = new ImageIcon("immagini/BTD1_towertack.png").getImage();

    public Tack() {
        this.title = "  Tack Tower";
        this.cost = "325";
        this.speed = "Medium";
        this.description = "Shoots volley of tacks\nin 8 directions. Can\nupgrade its shoot\nspeed and its range.";
        this.raggioAzione = 30;
    }
}
