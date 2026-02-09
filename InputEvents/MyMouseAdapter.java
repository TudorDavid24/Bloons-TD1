package InputEvents;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import Troops.BombTower;
import Troops.DartMonkey;
import Troops.IceTower;
import Troops.SuperMonkey;
import Troops.Tack;
import UI.MyPanel;

public class MyMouseAdapter implements MouseListener {

    MyPanel pannello;
      public MyMouseAdapter(MyPanel p){
        this.pannello = p;
    }

    DartMonkey D1 = new DartMonkey(pannello);
    Tack T1 = new Tack(pannello);
    IceTower I1 = new IceTower(pannello);
    BombTower B1 = new BombTower(pannello);
    SuperMonkey S1 = new SuperMonkey(pannello);

    boolean piazzaTruppa = false;

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(e.getX() + " " + e.getY());
        //#region Controllo se l'utente ha premuto su una truppa
        if (e.getX()>607 && e.getX()<607+33 && e.getY()>180&& e.getY()<180+33) {

            if (pannello.money < 250) {
                System.out.println("Non hai abbastanza soldi per comprare questa truppa!");
            }
            else{
                System.out.println("Hai premuto la scimmia dart");
                pannello.structureArray.add(new DartMonkey(pannello));
                pannello.structureArray.getLast().start();
                piazzaTruppa=true;
                pannello.immagineMouse = D1.dartMonkeyImage;
                pannello.money -= 250;
                pannello.moneyLabelValue.setText(String.valueOf(pannello.money));
            }
        }

        if (e.getX()>642 && e.getX()<642+33 && e.getY()>180&& e.getY()<180+33) {
            if (pannello.money < 325) {
                System.out.println("Non hai abbastanza soldi per comprare questa truppa!");
            }
            else{
                System.out.println("Hai premuto la tack");
                pannello.structureArray.add(new Tack(pannello));
                pannello.structureArray.getLast().start();
                piazzaTruppa=true;
                pannello.immagineMouse = T1.tackImage;
                pannello.money -= 325;
                pannello.moneyLabelValue.setText(String.valueOf(pannello.money));
            }
        }
        if (e.getX()>677 && e.getX()<677+33 && e.getY()>180&& e.getY()<180+33) {
            if (pannello.money < 850) {
                System.out.println("Non hai abbastanza soldi per comprare questa truppa!");
            }
            else{
                System.out.println("Hai premuto la ice");
                pannello.structureArray.add(new IceTower(pannello));
                pannello.structureArray.getLast().start();
                piazzaTruppa=true;
                pannello.immagineMouse = I1.iceTowerImage;
                pannello.money -= 850;
                pannello.moneyLabelValue.setText(String.valueOf(pannello.money));
            }
        }
        if (e.getX()>712 && e.getX()<712+33 && e.getY()>180&& e.getY()<180+33) {
            if (pannello.money < 900) {
                System.out.println("Non hai abbastanza soldi per comprare questa truppa!");
            }
            else{
                System.out.println("Hai premuto la bomb");
                pannello.structureArray.add(new BombTower(pannello));
                pannello.structureArray.getLast().start();
                piazzaTruppa=true;
                pannello.immagineMouse = B1.bombMonkeyImage;
                pannello.money -= 900;
                pannello.moneyLabelValue.setText(String.valueOf(pannello.money));
            }
        }
        if (e.getX()>747 && e.getX()<747+33 && e.getY()>180&& e.getY()<180+33) {
            if (pannello.money < 1500) {
                System.out.println("Non hai abbastanza soldi per comprare questa truppa!");
            }
            else{
                System.out.println("Hai premuto la scimmia super");
                pannello.structureArray.add(new SuperMonkey(pannello));
                pannello.structureArray.getLast().start();
                piazzaTruppa=true;
                pannello.immagineMouse = S1.superMonkeyImage;
                pannello.money -= 1500;
                pannello.moneyLabelValue.setText(String.valueOf(pannello.money));
            }
        }
        //#endregion

        //Controlla se l'utente ha premuto nel campo e se può piazzare una truppa
        if (e.getX()>0 && e.getX()<600 && e.getY()>0&& e.getY()<600) {
            System.out.println("Hai premuto nel campo");
            pannello.mouseX = e.getX();
            pannello.mouseY = e.getY();
            pannello.immagineMouse = null;

            if (piazzaTruppa == true) {
                    pannello.structureArray.getLast().setX(e.getX() - 23);
                    pannello.structureArray.getLast().setY(e.getY() - 23);
                    pannello.repaint();
                    piazzaTruppa=false;
                }
        }
        
        //Controllo se l'utente ha cliccato per iniziare il round
        if (e.getX()>615 && e.getX()<772 && e.getY()>535&& e.getY()<580 && !pannello.isRoundRunning) {
            pannello.numeroRound++;
            SwingUtilities.invokeLater(() -> {
            pannello.roundLabelValue.setText(String.valueOf(pannello.numeroRound));
            pannello.StartRectButton.setLocation(3000, 3000);
            pannello.startRoundLabel.setVisible(false);
            pannello.repaint();
            });
            pannello.isRoundRunning=true;
            pannello.gestioneRound();
        }
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
