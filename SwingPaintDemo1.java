
import javax.swing.SwingUtilities;

import UI.MyPanel;

import javax.swing.JFrame;

public class SwingPaintDemo1 {
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();   
            }
        });

    }
    
    public static void createAndShowGUI() {
        
        JFrame f = new JFrame("Bloons TD1");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel p = new MyPanel();
        f.add(p);
        f.pack(); // Adatta la dimensione al contenuto (MyPanel.getPreferredSize)
        f.setVisible(true);
        f.setResizable(false);
        // Assicurati che il pannello (p) abbia il focus subito all'avvio
        p.requestFocusInWindow(); 
    }
}