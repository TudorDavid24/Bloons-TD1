package InputEvents;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Troops.BombTower;
import Troops.DartMonkey;
import Troops.IceTower;
import Troops.SuperMonkey;
import Troops.Tack;
import UI.MyPanel;

public class MyMouseAdapter implements MouseListener {

    DartMonkey D1 = new DartMonkey();
    Tack T1 = new Tack();
    IceTower I1 = new IceTower();
    BombTower B1 = new BombTower();   
    SuperMonkey S1 = new SuperMonkey();

    boolean piazzaTruppa = false;

    MyPanel pannelloSuCuiLavorare;
      public MyMouseAdapter(MyPanel p){
        this.pannelloSuCuiLavorare = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());

        if (e.getX()>607 && e.getX()<607+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la scimmia dart");
            pannelloSuCuiLavorare.D1A[pannelloSuCuiLavorare.NelD1A] = new DartMonkey();
            piazzaTruppa=true;
            pannelloSuCuiLavorare.immagineMouse = D1.dartMonkeyImage;
        }

        if (e.getX()>642 && e.getX()<642+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la tack");
            pannelloSuCuiLavorare.D1A[pannelloSuCuiLavorare.NelD1A] = new Tack();
            piazzaTruppa=true;
            pannelloSuCuiLavorare.immagineMouse = T1.tackImage;
        }
        if (e.getX()>677 && e.getX()<677+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la ice");
            pannelloSuCuiLavorare.D1A[pannelloSuCuiLavorare.NelD1A] = new IceTower();
            piazzaTruppa=true;
            pannelloSuCuiLavorare.immagineMouse = I1.iceTowerImage;
        }
        if (e.getX()>712 && e.getX()<712+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la bomb");
            pannelloSuCuiLavorare.D1A[pannelloSuCuiLavorare.NelD1A] = new BombTower();
            piazzaTruppa=true;
            pannelloSuCuiLavorare.immagineMouse = B1.bombMonkeyImage;
        }
        if (e.getX()>747 && e.getX()<747+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la scimmia super");
            pannelloSuCuiLavorare.D1A[pannelloSuCuiLavorare.NelD1A] = new SuperMonkey();
            piazzaTruppa=true;
            pannelloSuCuiLavorare.immagineMouse = S1.superMonkeyImage;
        }

        if (e.getX()>0 && e.getX()<600 && e.getY()>0&& e.getY()<600) {
            System.out.println("Hai premuto nel campo");
            pannelloSuCuiLavorare.mouseX = e.getX();
            pannelloSuCuiLavorare.mouseY = e.getY();
            pannelloSuCuiLavorare.StampaImmagine = true;
            pannelloSuCuiLavorare.immagineMouse = null;
            pannelloSuCuiLavorare.StampaImmagine = false;

            if (piazzaTruppa == true) {
                pannelloSuCuiLavorare.D1A[pannelloSuCuiLavorare.NelD1A].setX(e.getX() - 23);
                pannelloSuCuiLavorare.D1A[pannelloSuCuiLavorare.NelD1A].setY(e.getY() - 23);
                pannelloSuCuiLavorare.NelD1A++;
                pannelloSuCuiLavorare.repaint();
                piazzaTruppa=false;
            }
        }
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}
