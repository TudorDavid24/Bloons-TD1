import java.awt.Image;
import javax.swing.ImageIcon;

public class IceTower extends Structure{
    
    //Image dartMonkeyImage = new ImageIcon("BTD1_tack.png").getImage();

    public IceTower() {
        this.title = "    Ice Tower";
        this.cost = "850";
        this.speed = "Slow";
        this.description = "Freezes nearby\nbloons. Frozen bloons\nare immune to darts\nand tacks, but bombs\nwill destroy them. Can\nupgrade to increased\nfreeze time, and\nlarger freeze radius";
        this.raggioAzione = 30;
    }
}
