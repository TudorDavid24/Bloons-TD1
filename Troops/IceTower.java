package Troops;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Bloons.Bloons;
import UI.MyPanel;

public class IceTower extends Structure{
    
    public Image iceTowerImage = new ImageIcon("immagini/BTD1_towerice.png").getImage();
    MyPanel pannello;
    
    public IceTower(MyPanel p) {
        super(new ImageIcon("immagini/BTD1_towerice.png"));
        this.title = "    Ice Tower";
        this.cost = "850";
        this.speed = "Slow";
        this.description = "Freezes nearby\nbloons. Frozen bloons\nare immune to darts\nand tacks, but bombs\nwill destroy them. Can\nupgrade to increased\nfreeze time, and\nlarger freeze radius";
        this.raggioAzione = 100;
        this.pannello = p;  
    }
    
    @Override
    public void run() {
        while (true) {
            
            Rectangle zonaGhiaccio = new Rectangle(this.x - raggioAzione, this.y - raggioAzione, raggioAzione*2, raggioAzione*2);

            for (int i = 0; i < pannello.bloonsArray.size(); i++) {
                Bloons b = pannello.bloonsArray.get(i);
                if (zonaGhiaccio.contains(b.getX(), b.getY())) {
                    b.setImmagineBloons(new ImageIcon("immagini/BTD1_plain1Iced.png").getImage());
                    b.isCongelato=true;
                }
            }
            
            //Tempo di ricarica
            try {
                Thread.sleep(6000); 
            } catch (InterruptedException e) {}
        }
    }    
}
