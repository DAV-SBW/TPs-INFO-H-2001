package TP3.Exo3;

import java.util.ArrayList;

public class Game {
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private Hero h;

    public void addObject(GameObject g){
        objects.add(g);
    }

    public GameObject getObject(int x, int y){
        GameObject res = null;
        for (GameObject o : objects){
            if (o.getX() == x && o.getY() == y){
                res = o;
            }
        }
        return res;
    }
}
