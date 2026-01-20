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
import java.awt.Image;
import java.io.File;

public class MyPanel extends JPanel {

    Bloons Prova1 = new Bloons();
    
    //Truppe
    DartMonkey D1 = new DartMonkey();
    Tack T1 = new Tack();
    IceTower I1 = new IceTower();
    BombTower B1 = new BombTower();   
    SuperMonkey S1 = new SuperMonkey();

    public Structure D1A[] = new Structure[10];
    public int NelD1A = 0;

    //Immagini
    Image Bg = new ImageIcon("Immagini/BTD1_bg.png").getImage();
    Image dartImage = new ImageIcon("Immagini/BTD1_dart_button.png").getImage();
    Image tackImage = new ImageIcon("Immagini/BTD1_tack_button.png").getImage();
    Image iceImage = new ImageIcon("Immagini/BTD1_ice_button.png").getImage();
    Image bombImage = new ImageIcon("Immagini/BTD1_bomb_button.png").getImage();
    Image superImage = new ImageIcon("Immagini/BTD1_super_button.png").getImage();

    public JPanel pannelloStatistiche = new JPanel();

    //Labels
    JLabel roundLabel, moneyLabel, livesLabel, towersLabel;

    //Labels Info scimmie
    public JLabel title, cost, speed;
    public JTextArea description;

    //Posizione del mouse
    public int mouseX, mouseY;
    public Image immagineMouse = null;

    public Boolean StampaImmagine = false;
    
    public MyPanel() {
        setLayout(null);
        setupLabels();
        inizializzaAdapter();

        pannelloStatistiche.setLayout(null);
        pannelloStatistiche.setBackground(new Color(190, 218, 201)); 
        pannelloStatistiche.setBounds(615, 230, 157, 300);
        pannelloStatistiche.setVisible(false);
        add(pannelloStatistiche);

        //Prova dei pallonici
        /*Prova1.ImmagineBloons = new ImageIcon("Immagini/BTD1_super_button.png").getImage();
        Prova1.speed = 5;
        Prova1.x=0;
        Prova1.y=290;
        Prova1.pannelloSuCuiLavorare=this;
        Prova1.tipo=1;
        Prova1.start();*/
        
        //Iniziallizzazione dell'array a null
        for (int i = 0; i < 10; i++) {
            D1A[i] = null;
        }
    
    }
    
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // Pulisce lo schermo

        // #region Disegno GUI di base
        // 1. Disegna lo sfondo
        g.drawImage(Bg, 0, 0, getWidth(), getHeight(), this);

        // 2. Disegna il rettangolo del menu
        g.setColor(new Color(191, 191, 191, 200));
        g.fillRect(605, 10, 177, 580);

        // 3. Disegna le icone manuali
        g.drawImage(dartImage, 607, 180, 33, 33, this);
        g.drawImage(tackImage, 642, 180, 33, 33, this);
        g.drawImage(iceImage, 677, 180, 33, 33, this);
        g.drawImage(bombImage, 712, 180, 33, 33, this);
        g.drawImage(superImage, 747, 180, 33, 33, this);
        //#endregion

        if (immagineMouse != null) {
            g.drawImage(immagineMouse, mouseX - 23, mouseY - 23, this);
        }

        for (int i = 0; i < NelD1A; i++) {
            g.drawImage(D1A[i].StructureImage, D1A[i].getX(), D1A[i].getY(), this);
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
    private void inizializzaAdapter(){
        MyKeyAdapter KeyBoard = new MyKeyAdapter(this);
        addKeyListener(KeyBoard);
        MyMouseMotionAdapter MouseMotionAdapter = new MyMouseMotionAdapter(this);
        addMouseMotionListener(MouseMotionAdapter);
        MyMouseAdapter MouseAdapter = new MyMouseAdapter(this);
        addMouseListener(MouseAdapter);
    }

}