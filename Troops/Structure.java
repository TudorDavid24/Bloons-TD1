package Troops;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Structure extends Thread {

    public Image StructureImage = null;

    public Structure(ImageIcon structureImage) {
        StructureImage = structureImage.getImage();
    }

    String title;
    String cost;
    String speed;
    String description;
    int raggioAzione;
    int x,y;
    
    public double angolo = 0;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getTitle() {
        return title;
    }
    public String getCost() {
        return cost;
    }
    public String getSpeed() {
        return speed;
    }
    public String getDescription() {
        return description;
    }
    public int getRaggioAzione() {
        return raggioAzione;
    }
}
