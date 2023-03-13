package TP5.Exo2;

import java.util.Random;

public class Farmer extends People {
    private int production;

    public Farmer(){
        // Appel au constructeur de la classe parent
        super(10);
        Random r = new Random();
        production = 5 + r.nextInt(6);
    }

    @Override
    public void workDay(Castle c) {
        c.addGold(production);
    }
}
