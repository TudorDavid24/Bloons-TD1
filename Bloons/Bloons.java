package Bloons;
import java.awt.Image;
import javax.swing.ImageIcon;
import UI.MyPanel;


public class Bloons extends Thread {
    
    private int tipo, TempoAttesa=10, TempoAttesaIni, x=-60, y=260;
    public Image ImmagineBloons = new ImageIcon("immagini/BTD1_plain1.png").getImage();
    public MyPanel pannelloSuCuiLavorare;
    public Boolean isCongelato = false;
    private int tempoCongelamento = 1500;
    
    public Bloons(MyPanel pannelloSuCuiLavorare) {
        this.pannelloSuCuiLavorare = pannelloSuCuiLavorare;
    }

    @Override
    public void run() {
        try {
            sleep(TempoAttesaIni);
            for (int i = 0; i < 160; i++) {
                x++;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 150; i++) {
                y--;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 140; i++) {
                x++;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 300; i++) {
                y++;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 190; i++) {
                x--;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 100; i++) {
                y++;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 455; i++) {
                x++;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 158; i++) {
                y--;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 140; i++) {
                x--;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 137; i++) {
                y--;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 144; i++) {
                x++;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 167; i++) {
                y--;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 201; i++) {
                x--;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
            for (int i = 0; i < 72; i++) {
                y--;
                sleep(TempoAttesa);
                pannelloSuCuiLavorare.repaint();
                if (isCongelato==true) {
                    try {
                        sleep(tempoCongelamento);
                        isCongelato=false;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        } catch (Exception e) {}
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setTempoAttesaIni(int tempoAttesaIni) {
        TempoAttesaIni = tempoAttesaIni;
    }

}
