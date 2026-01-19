package Bloons;

import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.ImageIcon;

public class BloonsManager{

    Queue<Bloons> BloonsArr = new PriorityQueue<>();
    Bloons NewBloons;
    BloonsManager(){
        for (int i = 0; i < 100; i++) {
            BloonsArr.add(new Bloons());
        }
    }

    public void SpawnBloons(int Tipo, int Speed, int X, int Y, ImageIcon Immagine){
        NewBloons = BloonsArr.remove();
        NewBloons.tipo=Tipo;
        NewBloons.speed=Speed;
        NewBloons.x = X;
        NewBloons.y = Y;
        NewBloons.ImmagineBloons = Immagine.getImage();
    }

    public void DestroyBloons(){
        BloonsArr.add(NewBloons);
        NewBloons.tipo = 0;
        NewBloons.speed = 0;
        NewBloons.x = 0;
        NewBloons.y = 0;
        NewBloons.ImmagineBloons = null;
    }
}