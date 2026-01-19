package UI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Bloons.Bloons;
import InputEvents.MyKeyAdapter;
import InputEvents.MyMouseAdapter;
import InputEvents.MyMouseMotionAdapter;
import Troops.BombTower;
import Troops.DartMonkey;
import Troops.IceTower;
import Troops.Structure;
import Troops.SuperMonkey;
import Troops.Tack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;

public class MyPanel extends JPanel {

    Bloons Prova1 = new Bloons();
    
    //Truppe
    DartMonkey D1 = new DartMonkey();
    Tack T1 = new Tack();
    IceTower I1 = new IceTower();
    BombTower B1 = new BombTower();   
    SuperMonkey S1 = new SuperMonkey();

    DartMonkey D1A[] = new DartMonkey[10];
    int NelD1A = 0;


    //Immagini
    Image Bg = new ImageIcon("Immagini/BTD1_bg.png").getImage();
    Image dartImage = new ImageIcon("Immagini/BTD1_dart_button.png").getImage();
    Image tackImage = new ImageIcon("Immagini/BTD1_tack_button.png").getImage();
    Image iceImage = new ImageIcon("Immagini/BTD1_ice_button.png").getImage();
    Image bombImage = new ImageIcon("Immagini/BTD1_bomb_button.png").getImage();
    Image superImage = new ImageIcon("Immagini/BTD1_super_button.png").getImage();

    boolean IconSelected = false;
    boolean dartMonkeyIconSelected = false;
    boolean tackIconSelected = false;
    boolean iceIconSelected = false;
    boolean bombIconSelected = false;
    boolean superMonkeyIconSelected = false;

    public JPanel pannelloStatistiche = new JPanel();

    //Labels
    JLabel roundLabel, moneyLabel, livesLabel, towersLabel;

    public JLabel title, cost, speed;
    public JTextArea description;

    public int mouseX, mouseY;
    public Image immagineMouse = null;

    public Boolean StampaImmagine = false;
    
    public MyPanel() {
        setLayout(null);
        setupLabels();
        MyKeyAdapter KeyBoard = new MyKeyAdapter(this);
        addKeyListener(KeyBoard);
        MyMouseMotionAdapter MouseMotionAdapter = new MyMouseMotionAdapter(this);
        addMouseMotionListener(MouseMotionAdapter);
        MyMouseAdapter MouseAdapter = new MyMouseAdapter(this);
        addMouseListener(MouseAdapter);

        pannelloStatistiche.setLayout(null);
        pannelloStatistiche.setBackground(new Color(190, 218, 201)); 
        pannelloStatistiche.setBounds(615, 230, 157, 300);
        pannelloStatistiche.setVisible(false);
        add(pannelloStatistiche);

        Prova1.ImmagineBloons = new ImageIcon("Immagini/BTD1_super_button.png").getImage();
        Prova1.speed = 5;
        Prova1.x=0;
        Prova1.y=290;
        Prova1.pannelloSuCuiLavorare=this;
        Prova1.tipo=1;
        Prova1.start();
        
        
        for (int i = 0; i < 10; i++) {
            D1A[i] = new DartMonkey();
        }
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
            
            title = new JLabel();
            cost = new JLabel();
            speed = new JLabel();
            description = new JTextArea(3, 30);
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
    private JLabel createMenuLabel(String text, int x, int y, Color color, JPanel Panel) {
        JLabel l = new JLabel(text);
        l.setBounds(x, y, 150, 50);
        l.setForeground(color);
        l.setFont(l.getFont().deriveFont(20.0f));
        Panel.add(l);
        return l;
    }
    private JTextArea createMenuTextArea(String text, int x, int y, Color color, JPanel Panel){
        JTextArea TextArea = new JTextArea(text);
        TextArea.setBounds(x, y, 300, 200);
        TextArea.setForeground(color);
        TextArea.setFont(TextArea.getFont().deriveFont(16.0f));
        TextArea.setBackground(new Color(0,0,0,0));
        TextArea.setLineWrap(true);
        Panel.add(TextArea);
        return TextArea;
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

        g.drawImage(Prova1.ImmagineBloons, Prova1.x, Prova1.y, 30, 30, this);

        if (immagineMouse == D1.dartMonkeyImage || immagineMouse == S1.superMonkeyImage) {
            //g2d.drawImage(immagineMouse, mouseX - 23, mouseY - 23, 50, 50, this);
        }
        if (immagineMouse == T1.tackImage || immagineMouse == I1.iceTowerImage) {
            g2d.drawImage(immagineMouse, mouseX - 21, mouseY - 21, 45, 45, this);
        }
        if(immagineMouse == B1.bombMonkeyImage){
            g2d.drawImage(immagineMouse, mouseX - 14, mouseY - 21, 29, 55, this);
        }

        if (StampaImmagine == true) {
            DartMonkey NewMonkey = new DartMonkey();
            NewMonkey.setX(mouseX- 14);
            NewMonkey.setY(mouseY- 21);
            D1A[1] = NewMonkey;
        }

        for (int i = NelD1A; i < D1A.length; i++) {
            g2d.drawImage(D1A[i].dartMonkeyImage, mouseX - 23, mouseY - 23, 50, 50, this);
        }


    }

    public void createMenu(Structure S1){
        Color textColor = new Color(24, 129, 25);
        if (pannelloStatistiche.isVisible()==false) {
            title = createMenuLabel(S1.getTitle(), 10, 5, textColor, pannelloStatistiche);
            System.out.print(title.getWidth());
            cost = createMenuLabel("Cost: " +S1.getCost(), 5, 50, textColor, pannelloStatistiche);
            speed = createMenuLabel("Speed: " + S1.getSpeed(), 5, 80, textColor, pannelloStatistiche);
            description = createMenuTextArea(S1.getDescription(), 5, 130, textColor, pannelloStatistiche);
        }
    }
}