import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseAdapter implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() +" " +e.getY());

        if (e.getX()>607 && e.getX()<607+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la scimmia dart");
        }
        if (e.getX()>642 && e.getX()<642+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la tack");
        }
        if (e.getX()>677 && e.getX()<677+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la ice");
        }
        if (e.getX()>712 && e.getX()<712+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la bomb");
        }
        if (e.getX()>747 && e.getX()<747+33 && e.getY()>180&& e.getY()<180+33) {
            System.out.println("Hai premuto la scimmia super");
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
