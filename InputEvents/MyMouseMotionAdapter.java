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
    
    DartMonkey DartMonkeyItem = new DartMonkey();
    Tack TackItem = new Tack();
    IceTower IceTowerItem = new IceTower();
    BombTower BombTowerItem = new BombTower();
    SuperMonkey SuperMonkeyItem = new SuperMonkey();
    MyPanel pannelloSuCuiLavorare;
    public MyMouseMotionAdapter(MyPanel p){
        this.pannelloSuCuiLavorare = p;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
     //System.out.println("Mouse Dragged!");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (e.getX()>607 && e.getX()<607+33 && e.getY()>180&& e.getY()<180+33) {
            pannelloSuCuiLavorare.createMenu(DartMonkeyItem);
            pannelloSuCuiLavorare.pannelloStatistiche.setVisible(true);
            pannelloSuCuiLavorare.repaint();
        }
        else if (e.getX()>642 && e.getX()<642+33 && e.getY()>180&& e.getY()<180+33) {
            pannelloSuCuiLavorare.createMenu(TackItem);
            pannelloSuCuiLavorare.pannelloStatistiche.setVisible(true);
            pannelloSuCuiLavorare.repaint();
        }
        else if (e.getX()>677 && e.getX()<677+33 && e.getY()>180&& e.getY()<180+33) {
            pannelloSuCuiLavorare.createMenu(IceTowerItem);
            pannelloSuCuiLavorare.pannelloStatistiche.setVisible(true);
            pannelloSuCuiLavorare.repaint();
        }
        else if (e.getX()>712 && e.getX()<712+33 && e.getY()>180&& e.getY()<180+33) {
            pannelloSuCuiLavorare.createMenu(BombTowerItem);
            pannelloSuCuiLavorare.pannelloStatistiche.setVisible(true);
            pannelloSuCuiLavorare.repaint();
        }
        else if (e.getX()>747 && e.getX()<747+33 && e.getY()>180&& e.getY()<180+33) {
            pannelloSuCuiLavorare.createMenu(SuperMonkeyItem);
            pannelloSuCuiLavorare.pannelloStatistiche.setVisible(true);
            pannelloSuCuiLavorare.repaint();
        }
        else{
            RemoveLabels();
            pannelloSuCuiLavorare.pannelloStatistiche.setVisible(false);
            pannelloSuCuiLavorare.repaint();
        }

        if (pannelloSuCuiLavorare.immagineMouse != null) {
            pannelloSuCuiLavorare.mouseX = e.getX();
            pannelloSuCuiLavorare.mouseY = e.getY();
            pannelloSuCuiLavorare.repaint();
        }
    }

    public void RemoveLabels(){
            pannelloSuCuiLavorare.pannelloStatistiche.remove(pannelloSuCuiLavorare.title);
            pannelloSuCuiLavorare.pannelloStatistiche.remove(pannelloSuCuiLavorare.cost);
            pannelloSuCuiLavorare.pannelloStatistiche.remove(pannelloSuCuiLavorare.speed);
            pannelloSuCuiLavorare.pannelloStatistiche.remove(pannelloSuCuiLavorare.description);
    }
}