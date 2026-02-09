package InputEvents;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Troops.BombTower;
import Troops.DartMonkey;
import Troops.IceTower;
import Troops.SuperMonkey;
import Troops.Tack;
import UI.MyPanel;

public class MyMouseMotionAdapter implements MouseMotionListener{ 
    
    MyPanel pannello;

    public MyMouseMotionAdapter(MyPanel p){
        this.pannello = p;
    }

    DartMonkey DartMonkeyItem = new DartMonkey(pannello);
    Tack TackItem = new Tack(pannello);
    IceTower IceTowerItem = new IceTower(pannello);
    BombTower BombTowerItem = new BombTower(pannello);
    SuperMonkey SuperMonkeyItem = new SuperMonkey(pannello);


    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {

        //region Mostra le statistiche di una truppa quando l'utente ci passa sopra
        if (e.getX()>607 && e.getX()<607+33 && e.getY()>180&& e.getY()<180+33) {
            pannello.createMenu(DartMonkeyItem);
            pannello.pannelloStatistiche.setVisible(true);
        }

        else if (e.getX()>642 && e.getX()<642+33 && e.getY()>180&& e.getY()<180+33) {
            pannello.createMenu(TackItem);
            pannello.pannelloStatistiche.setVisible(true);
        }

        else if (e.getX()>677 && e.getX()<677+33 && e.getY()>180&& e.getY()<180+33) {
            pannello.createMenu(IceTowerItem);
            pannello.pannelloStatistiche.setVisible(true);
        }

        else if (e.getX()>712 && e.getX()<712+33 && e.getY()>180&& e.getY()<180+33) {
            pannello.createMenu(BombTowerItem);
            pannello.pannelloStatistiche.setVisible(true);
        }

        else if (e.getX()>747 && e.getX()<747+33 && e.getY()>180&& e.getY()<180+33) {
            pannello.createMenu(SuperMonkeyItem);
            pannello.pannelloStatistiche.setVisible(true);
        }
        else{
            removeLabels();
        }
        //#endregion

        if (pannello.immagineMouse != null) {
            pannello.mouseX = e.getX();
            pannello.mouseY = e.getY();
            pannello.repaint();
        }
    }

    public void removeLabels(){
        pannello.pannelloStatistiche.remove(pannello.title);
        pannello.pannelloStatistiche.remove(pannello.cost);
        pannello.pannelloStatistiche.remove(pannello.speed);
        pannello.pannelloStatistiche.remove(pannello.description);
        pannello.pannelloStatistiche.setVisible(false);
    }
}