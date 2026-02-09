//#region Import
package UI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Bloons.Bloons;
import InputEvents.MyMouseAdapter;
import InputEvents.MyMouseMotionAdapter;
import Proiettili.Cannon;
import Proiettili.Darts;
import Proiettili.TacksBullets;
import Sound.SoundManager;
import Troops.Structure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.File;

import java.util.concurrent.CopyOnWriteArrayList;
//#endregion

public class MyPanel extends JPanel {

    public MyPanel() {

        setLayout(null);
        setupLabels();
        inizializzaAdapter();

        soundManager.loadSound("PopBloon.wav", "PopBloon.wav");
        soundManager.loadSound("CannonExplosion.wav", "CannonExplosion.wav");

        pannelloStatistiche.setLayout(null);
        pannelloStatistiche.setBackground(new Color(190, 218, 201)); 
        pannelloStatistiche.setBounds(615, 230, 157, 300);
        pannelloStatistiche.setVisible(false);
        add(pannelloStatistiche);

    }

    //Array delle strutture
    public CopyOnWriteArrayList<Structure> structureArray = new CopyOnWriteArrayList<>();

    //Array dei palloncini
    public CopyOnWriteArrayList<Bloons> bloonsArray = new CopyOnWriteArrayList<>();

    //Array dei dardi
    public CopyOnWriteArrayList<Darts> dartsArray = new CopyOnWriteArrayList<>();

    //Array dei tack
    public CopyOnWriteArrayList<TacksBullets> tackArray = new CopyOnWriteArrayList<>();

    //Array delle palle da cannone
    public CopyOnWriteArrayList<Cannon> cannonBallsArray = new CopyOnWriteArrayList<>();

    //Immagini delle icone
    Image Bg = new ImageIcon("Immagini/BTD1_bg.png").getImage();
    Image dartImage = new ImageIcon("Immagini/BTD1_dart_button.png").getImage();
    Image tackImage = new ImageIcon("Immagini/BTD1_tack_button.png").getImage();
    Image iceImage = new ImageIcon("Immagini/BTD1_ice_button.png").getImage();
    Image bombImage = new ImageIcon("Immagini/BTD1_bomb_button.png").getImage();
    Image superImage = new ImageIcon("Immagini/BTD1_super_button.png").getImage();

    //Pannello informazioni
    public JPanel pannelloStatistiche = new JPanel();

    //Labels
    public JLabel roundLabelText, moneyLabelText, livesLabelText, towersLabel, startRoundLabel;
    public JLabel roundLabelValue, moneyLabelValue, livesLabelValue;
    public Rectangle StartRectButton = new Rectangle(615, 535, 157, 45);

    //Labels Info scimmie
    public JLabel title, cost, speed;
    public JTextArea description;

    //Valori di gioco
    public int money = 650;
    public int tempMoney = 0;
    public int lives = 40;
    public int numeroRound = 0;

    //Posizione del mouse
    public int mouseX, mouseY;
    public Image immagineMouse = null;

    //Stato del round
    public boolean isRoundRunning = false;

    //Gestore dei suoni
    public SoundManager soundManager = new SoundManager();

    //Immagini dei proiettili
    Image dardoImg = new ImageIcon("Immagini/BTD1_dart.png").getImage();
    Image tackImg = new ImageIcon("Immagini/BTD1_tack.png").getImage();
    Image cannonImg = new ImageIcon("Immagini/BTD1_bomb.png").getImage();
    
    //Stato del gioco
    public int statoGioco = 0; // 0 = Menu, 1 = Gioco, 2 = Game Over
    Image StartGameImg = new ImageIcon("Immagini/StartImmage.png").getImage();
    Image GameOverImg = new ImageIcon("Immagini/GameOver.png").getImage();

    public void paintComponent(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g); // Pulisce lo schermo
        //#region Disegno GUI di base
        //Disegna lo sfondo
        g.drawImage(Bg, 0, 0, getWidth(), getHeight(), this);

        //Disegna il rettangolo del menu
        g.setColor(new Color(191, 191, 191, 200));
        g.fillRect(605, 10, 177, 580);

        //Disegna le icone
        g.drawImage(dartImage, 607, 180, 33, 33, this);
        g.drawImage(tackImage, 642, 180, 33, 33, this);
        g.drawImage(iceImage, 677, 180, 33, 33, this);
        g.drawImage(bombImage, 712, 180, 33, 33, this);
        g.drawImage(superImage, 747, 180, 33, 33, this);

        //Disegna il pulsante di start
        g.setColor(new Color(78, 203, 75, 255));
        g.fillRect(StartRectButton.x, StartRectButton.y, StartRectButton.width, StartRectButton.height);
        //#endregion

        //Disegna l'immagine del personaggio in base alle coordinate del mouse
        if (immagineMouse != null) {
            g.drawImage(immagineMouse, mouseX - 23, mouseY - 23, this);
        }

        //Disegno di tutto l'array delle strutture
        for (int i = 0; i < structureArray.size(); i++) {
                Structure s = structureArray.get(i);
                AffineTransform vecchioDato = g2d.getTransform();
                g2d.translate(s.getX() + 23, s.getY() + 23); 
                g2d.rotate(s.angolo);
                g2d.drawImage(s.StructureImage, -23, -23, this);
                g2d.setTransform(vecchioDato);
        }

        //Disegno di tutto l'array di palloncini
        for (Bloons b : bloonsArray) {
            g.drawImage(b.ImmagineBloons, b.getX(), b.getY(), 30, 42, this);
        }
    
        //Disegno di tutto l'array di proiettili
        for (Darts d : dartsArray) {
            AffineTransform vecchioDato = g2d.getTransform();
            g2d.translate(d.getX(), d.getY());
            g2d.rotate(Math.atan2(d.velY, d.velX));
            g2d.drawImage(dardoImg, -7, -7, 30, 10, this);
            g2d.setTransform(vecchioDato);
        }

        //Disegno di tutto l'array di tack
        for (TacksBullets t : tackArray) {
            AffineTransform vecchioDato = g2d.getTransform();
            g2d.translate(t.getX(), t.getY());
            g2d.rotate(Math.atan2(t.velY, t.velX));
            g.drawImage(tackImg, -10, -15, 12, 10, this);
            g2d.setTransform(vecchioDato);
        }

        //Disegno di tutto l'array di cannoni
        for (Cannon c : cannonBallsArray) {
            AffineTransform vecchioDato = g2d.getTransform();
            g2d.translate(c.getX(), c.getY());
            g2d.rotate(Math.atan2(c.velY, c.velX));
            g2d.drawImage(cannonImg, -10, -15, 15, 18, this);
            g2d.setTransform(vecchioDato);
        }
        //Controllo se il round è finito
        fineRound();

        if (lives<1) {
            g.drawImage(GameOverImg, 0, 0, getWidth(), getHeight(), this);
            remove(roundLabelText);
            remove(moneyLabelText);
            remove(livesLabelText);
            remove(towersLabel);
            remove(startRoundLabel);
            remove(roundLabelValue);
            remove(moneyLabelValue); 
            remove(livesLabelValue);
            remove(pannelloStatistiche);
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

            roundLabelText = createLabel("Round:", 620, 40, customFont, textColor);
            moneyLabelText = createLabel("Money:", 620, 70, customFont, textColor);
            livesLabelText = createLabel("Lives:", 620, 100, customFont, textColor);
            towersLabel = createLabel("Build Towers", 620, 140, customFont, textColor);
            startRoundLabel = createLabel("Start Round", 630, 545, customFont, textColor);

            roundLabelValue = createLabel(String.valueOf(numeroRound), 720, 40, customFont, textColor);
            moneyLabelValue = createLabel(String.valueOf(money), 720, 70, customFont, textColor);
            livesLabelValue = createLabel(String.valueOf(lives), 720, 100, customFont, textColor);
            
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
            cost = createMenuLabel("Cost: " + S1.getCost(), 5, 50, textColor, pannelloStatistiche);
            speed = createMenuLabel("Speed: " + S1.getSpeed(), 5, 80, textColor, pannelloStatistiche);
            description = createMenuTextArea(S1.getDescription(), 5, 130, textColor, pannelloStatistiche);
        }
    }
    private void inizializzaAdapter(){
        MyMouseMotionAdapter MouseMotionAdapter = new MyMouseMotionAdapter(this);
        addMouseMotionListener(MouseMotionAdapter);
        MyMouseAdapter MouseAdapter = new MyMouseAdapter(this);
        addMouseListener(MouseAdapter);
    }

    public void gestioneRound(){

                switch (numeroRound) {
                    case 1:
                        spawnPalloncini(10, 10);
                        tempMoney = 100;
                    break;
                    case 2:
                        spawnPalloncini(20, 10);
                        tempMoney = 200;
                    break;
                    case 3:
                        spawnPalloncini(30, 8);
                        tempMoney = 250;
                    break;
                    case 4:
                        spawnPalloncini(40, 7);
                        tempMoney = 200;
                    break;
                        case 5:
                        spawnPalloncini(50, 6);
                        tempMoney = 250;
                    break;
                        case 6:
                        spawnPalloncini(60, 5);
                        tempMoney = 350;
                    break;
                        case 7:
                        spawnPalloncini(70, 5);
                        tempMoney = 300;
                    break;
                        case 8:
                        spawnPalloncini(80, 4);
                        tempMoney = 250;
                    break;
                        case 9:
                        spawnPalloncini(90, 3);
                        tempMoney = 100;
                    break;
                       case 10:
                        spawnPalloncini(100, 2);
                    break;
            }
        }

    private void spawnPalloncini(int numeroPalloncini, int velBloons) {

        // Pulisci la lista per il nuovo round
        bloonsArray.clear(); 
         
        for (int i = 0; i < numeroPalloncini; i++) {
            Bloons b = new Bloons(this);
            b.setTempoAttesaIni((int)((200 * Math.random()) + 200 * i));
            b.TempoAttesa = velBloons;
            bloonsArray.add(b);
            b.start();
        }

    }
    private void fineRound() {
        if (bloonsArray.isEmpty() && isRoundRunning) {
            System.out.println("Round Finito!");
            SwingUtilities.invokeLater(() -> {
            StartRectButton.setLocation(615, 535);
            startRoundLabel.setVisible(true);
            isRoundRunning=false;
            money += tempMoney;
            moneyLabelValue.setText(String.valueOf(money));
            });
            repaint();
        }
    }
    public void PlaySound(String soundName) {
        soundManager.playSound(soundName);
    }
}
