import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

class MyPanel extends JPanel {

    Image Bg = new ImageIcon("Immagini/BTD1_bg.png").getImage();
    
    public MyPanel() {
        MyKeyAdapter KeyBoard = new MyKeyAdapter(this);
        addKeyListener(KeyBoard);
        MyMouseAdapter MouseAdapter = new MyMouseAdapter();
        addMouseListener(MouseAdapter);
        Labels();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(785,600);
        
    }


    public void paintComponent(Graphics g) {
        //Bordi lisci per il testo
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        super.paintComponent(g);
        //Background
        g.drawImage(Bg, 0, 0, getWidth(), getHeight(), this);
        //Container
        Color C;
        C = new Color(191, 191, 191, 200);
        g.setColor(C);
        g.fillRect(605, 10, 175, 580);


    }   

    public void Labels(){
        int LabelY = 21;
        Color TextColor = new Color(238, 255, 243);
        setLayout(null);
        JLabel RoundLabel = new JLabel("Round:");
        RoundLabel.setBounds(620, 40, 100, LabelY+10);
        RoundLabel.setForeground(TextColor);
        JLabel MoneyLabel = new JLabel("Money:");
        MoneyLabel.setBounds(620, 70, 100, LabelY+10);
        MoneyLabel.setForeground(TextColor);
        JLabel LivesLabel = new JLabel("Lives:");
        LivesLabel.setBounds(620, 100, 100, LabelY+10);
        LivesLabel.setForeground(TextColor);

        JLabel TowersLabel = new JLabel("<html><u>Build Towers</u></html>");
        TowersLabel.setBounds(620, 140, 200, LabelY+10);
        TowersLabel.setForeground(TextColor);

        
        add(RoundLabel);
        add(MoneyLabel);
        add(LivesLabel);
        add(TowersLabel);


        try {
            // Carica il file del font
            Font luckiestGuy = Font.createFont(Font.PLAIN, new File("LuckiestGuy-Regular.ttf")).deriveFont((float)LabelY);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(luckiestGuy);

            // Applicalo alla tua label
            RoundLabel.setFont(luckiestGuy);
            MoneyLabel.setFont(luckiestGuy);
            LivesLabel.setFont(luckiestGuy);
            TowersLabel.setFont(luckiestGuy);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

}