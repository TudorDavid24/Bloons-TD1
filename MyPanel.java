import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;

class MyPanel extends JPanel {

    public MyPanel() {
        MyKeyAdapter KeyBoard = new MyKeyAdapter(this);
        addKeyListener(KeyBoard);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,500);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
    }   

}