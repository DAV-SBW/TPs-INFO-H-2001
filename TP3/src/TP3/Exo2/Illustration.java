package TP3.Exo2;

import java.util.ArrayList;
import java.util.List;

public class Illustration {
    private List<Drawable> formes = new ArrayList<Drawable>();
    private static int SIZE = 50;

    public void add(Drawable f){
        this.formes.add(f);
    }

    public String toString(){
        String out = "";
        for(int y=0; y<SIZE; y++){
            for(int x=0; x<SIZE; x++){
                char couleur = ' ';
                for(Drawable f : formes){
                    if(f.isOn(new Point(x,y))){
                        couleur = f.getColor();
                    }
                }
                //ici, couleur est soit " ", soit la couleur de
                //la dernière forme de la liste qui occupe le point (x,y)
                out += couleur;
            }
            out += '\n'; //fin de ligne
        }
        return out;
    }

}