package Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SoundManager {

    // Mappa per memorizzare i suoni pre-caricati
    private HashMap<String, Clip> clips = new HashMap<>();

    // Metodo per caricare un suono in memoria
    public void loadSound(String soundName, String filePath) {
        try {
            File f = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clips.put(soundName, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Metodo per riprodurre un suono esistente senza creare nuovi thread o oggetti
    public void playSound(String soundName) {
        Clip clip = clips.get(soundName);
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop(); // Interrompe se stava già suonando (opzionale)
            }
            clip.setFramePosition(0); // Ricomincia dall'inizio
            clip.start();
        }
    }
}