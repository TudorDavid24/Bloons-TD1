import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

class MyPanel extends JPanel {

        Image Bg = new ImageIcon("Immagini/Bg1.png").getImage();
    public MyPanel() {
        MyKeyAdapter KeyBoard = new MyKeyAdapter(this);
        addKeyListener(KeyBoard);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(785,600);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Bg, 0, 0, 950, 650, this);
        Color C = new Color(191, 191, 191, 200);
        g.setColor(C);
        g.fillRect(605, 10, 175, 580);
    }   

}