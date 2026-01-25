package UI;

import java.util.concurrent.atomic.AtomicInteger;

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
import java.awt.Rectangle;
import java.io.File;
import java.util.Arrays;

public class MyPanel extends JPanel {

    //Truppe
    DartMonkey D1 = new DartMonkey();
    Tack T1 = new Tack();
    IceTower I1 = new IceTower();
    BombTower B1 = new BombTower();   
    SuperMonkey S1 = new SuperMonkey();

    //Array delle strutture
    public Structure D1A[] = new Structure[10];
    public int NelD1A = 0;

    //Array dei palloncini
    public Bloons B1A[] = new Bloons[40];
    public int NelB1A = 0;

    //Immagini
    Image Bg = new ImageIcon("Immagini/BTD1_bg.png").getImage();
    Image dartImage = new ImageIcon("Immagini/BTD1_dart_button.png").getImage();
    Image tackImage = new ImageIcon("Immagini/BTD1_tack_button.png").getImage();
    Image iceImage = new ImageIcon("Immagini/BTD1_ice_button.png").getImage();
    Image bombImage = new ImageIcon("Immagini/BTD1_bomb_button.png").getImage();
    Image superImage = new ImageIcon("Immagini/BTD1_super_button.png").getImage();

    public JPanel pannelloStatistiche = new JPanel();

    //Labels
    public JLabel roundLabel, moneyLabel, livesLabel, towersLabel, startRoundLabel;
    public Rectangle StartRectButton = new Rectangle(615, 535, 157, 45);

    //Labels Info scimmie
    public JLabel title, cost, speed;
    public JTextArea description;

    //Posizione del mouse
    public int mouseX, mouseY;
    public Image immagineMouse = null;

    //Stampa immagine
    public Boolean StampaImmagine = false;

    //Logica Round
    public int NumeroRound = 0;
    public boolean RoundIsStarted = false;
    int NumeroPalloncini=0;
    private AtomicInteger pallonciniAttivi = new AtomicInteger(0);


    boolean tuttiFiniti = false;

    
    public MyPanel() {

        setLayout(null);
        setupLabels();
        inizializzaAdapter();

        pannelloStatistiche.setLayout(null);
        pannelloStatistiche.setBackground(new Color(190, 218, 201)); 
        pannelloStatistiche.setBounds(615, 230, 157, 300);
        pannelloStatistiche.setVisible(false);
        add(pannelloStatistiche);
        
        //Iniziallizzazione dell'array Structure a null
        for (int i = 0; i < D1A.length; i++) {
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

        //4. Disegna il pulsante di start
        g.setColor(new Color(78, 203, 75, 255));
        g.fillRect(StartRectButton.x, StartRectButton.y, StartRectButton.width, StartRectButton.height);
        //#endregion

        if (immagineMouse != null) {
            g.drawImage(immagineMouse, mouseX - 23, mouseY - 23, this);
        }

        for (int i = 0; i < NelD1A; i++) {
            g.drawImage(D1A[i].StructureImage, D1A[i].getX(), D1A[i].getY(), this);
        }

        if (RoundIsStarted) {
            for (int i = 0; i < B1A.length; i++) {
            g.drawImage(B1A[i].ImmagineBloons, B1A[i].getX(), B1A[i].getY(), 30, 42, this);
            } 
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
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("LuckiestGuy-Regular.ttf")).deriveFont((float)labelY);

            roundLabel = createLabel("Round:", 620, 40, customFont, textColor);
            moneyLabel = createLabel("Money:", 620, 70, customFont, textColor);
            livesLabel = createLabel("Lives:", 620, 100, customFont, textColor);
            towersLabel = createLabel("Build Towers", 620, 140, customFont, textColor);
            startRoundLabel = createLabel("Start Round", 630, 545, customFont, textColor);
            
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


    public void GestisciRound(){

            for (int i = 0; i < B1A.length; i++) {
            B1A[i] = new Bloons(this);
            }

            switch (NumeroRound) {
                case 1:
                    StartaNumeroThread( 10);
                break;
                case 2:
                    StartaNumeroThread(20);
                break;
                case 3:
                    StartaNumeroThread(5);
                break;
            }
    }

    private void StartaNumeroThread(int numeroPalloncini){

    pallonciniAttivi.set(numeroPalloncini); // Imposta quanti devono finire

        for (int i = 0; i < numeroPalloncini; i++) {
            final int index = i;
            B1A[i].setTempoAttesaIni(400 * i);
            
            // Se Bloons estende Thread, dobbiamo sovrascrivere il comportamento
            // o assicurarci che alla fine del suo run() decrementi il contatore.
            // Se non puoi modificare Bloons, avvolgilo così:
            new Thread(() -> {
                B1A[index].run(); // Esegue la logica del movimento
                
                // QUANDO IL THREAD FINISCE:
                if (pallonciniAttivi.decrementAndGet() == 0) {
                    // Questo è l'ultimo palloncino!
                    fineRoundSafe();
                }
            }).start();
        }
    }

    private void fineRoundSafe() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            System.out.println("Round Finito!");
            RoundIsStarted = false;
            StartRectButton.setLocation(615, 535);
            startRoundLabel.setVisible(true);
            repaint();
        });
    }

}
