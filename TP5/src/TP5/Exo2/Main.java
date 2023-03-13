package TP5.Exo2;

public class Main {

    public static void main(String args[]) {
        int gold = 50;
        int life = 100;
        int difficulty = 1;
        Castle c = new Castle(gold, life, difficulty);

        while (c.getlives()>0) {
            System.out.println("Il vous reste : " + c.getlives() + " vies");
            c.hire();
            c.surviveDay();
            System.out.println("Il vous reste : " + c.getlives() + " vies");
            // Passer la nuit
        }
    }
}

