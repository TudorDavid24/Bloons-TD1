import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;

class MyPanel extends JPanel {

    //Immagini
    Image Bg = new ImageIcon("Immagini/BTD1_bg.png").getImage();
    Image dartImage = new ImageIcon("Immagini/BTD1_dart_button.png").getImage();
    Image tackImage = new ImageIcon("Immagini/BTD1_tack_button.png").getImage();
    Image iceImage = new ImageIcon("Immagini/BTD1_ice_button.png").getImage();
    Image bombImage = new ImageIcon("Immagini/BTD1_bomb_button.png").getImage();
    Image superImage = new ImageIcon("Immagini/BTD1_super_button.png").getImage();


    //Labels
    JLabel roundLabel, moneyLabel, livesLabel, towersLabel;

    public MyPanel() {
        setLayout(null);
        setupLabels();
        MyKeyAdapter KeyBoard = new MyKeyAdapter(this);
        addKeyListener(KeyBoard);
        MyMouseAdapter MouseAdapter = new MyMouseAdapter();
        addMouseListener(MouseAdapter);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(785,600);
    }

    public void setupLabels(){

        Color textColor = new Color(238, 255, 243);
        int labelY = 21;

        try {
            // Carica il font UNA VOLTA SOLA
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("LuckiestGuy-Regular.ttf")).deriveFont((float)labelY);

            roundLabel = createLabel("Round:", 620, 40, customFont, textColor);
            moneyLabel = createLabel("Money:", 620, 70, customFont, textColor);
            livesLabel = createLabel("Lives:", 620, 100, customFont, textColor);
            towersLabel = createLabel("Build Towers", 620, 140, customFont, textColor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo di supporto per non ripetere codice
    private JLabel createLabel(String text, int x, int y, Font font, Color color) {
        JLabel l = new JLabel(text);
        l.setBounds(x, y, 200, 31);
        l.setFont(font);
        l.setForeground(color);
        add(l);
        return l;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g); // Pulisce lo schermo
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Disegna lo sfondo
        g2d.drawImage(Bg, 0, 0, getWidth(), getHeight(), this);

        // 2. Disegna il rettangolo del menu
        g2d.setColor(new Color(191, 191, 191, 200));
        g2d.fillRect(605, 10, 177, 580);

        // 3. Disegna le icone manuali
        g2d.drawImage(dartImage, 607, 180, 33, 33, this);
        g2d.drawImage(tackImage, 642, 180, 33, 33, this);
        g2d.drawImage(iceImage, 677, 180, 33, 33, this);
        g2d.drawImage(bombImage, 712, 180, 33, 33, this);
        g2d.drawImage(superImage, 747, 180, 33, 33, this);

    }
}
