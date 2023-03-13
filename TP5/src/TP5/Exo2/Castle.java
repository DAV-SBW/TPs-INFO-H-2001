package TP5.Exo2;

import java.util.ArrayList;
import java.util.Scanner;

public class Castle {
    private int gold;
    private int life;
    private int life_max;
    private int difficulty;
    private int day = 1;

    private ArrayList<People> habitants = new ArrayList<People>();

    public Castle(int gold, int life, int d) {
        this.gold = gold;
        this.life = life;
        difficulty = d;
    }

    public void hire() {
        // La méthode invite l'utilisateur à entrer du texte dans le terminal pour décider
        // quel type de perso créer et ce texte sera renvoyé à la classe fabrique
        Scanner in = new Scanner(System.in);
        // Permet de lire ce qu'il y a à l'écran
        boolean stop = false;
        // Tant qu'on ne répond pas stop on reste dans le while
        while(!stop)
        {
            System.out.println("Who do you want to hire? You have " + gold + " Golds. [stop to quit]");
            String line = in.nextLine();
            String[] words = line.split(" ");
            String order = words[0];
            int price = 0;
            if (order != null) {
                if (order.equals("stop")) {
                    stop = true;
                } else {
                    for (int i = 0; i < Integer.parseInt(words[1]); i++) {
                        People newHabitant = PersonFactory.getInstance(order);
                        if (newHabitant != null) {
                            price = newHabitant.getPrice();
                            if (price <= gold) {
                                gold -= price;
                                habitants.add(newHabitant);
                            }
                        }
                    }
                }
            }
        }
    }

    public void surviveDay() {
        for (People p : habitants){
            p.workDay(this);
        }
        for (People p : habitants){
            if (p instanceof Payable){
                int salary = ((Payable)p).getSalary();
                if (salary < gold){
                    // On le paie pour de bon :
                    ((Payable)p).pay();
                    gold -= salary;
                }
            }
        }
        // Perds des points de vie
        life -= day*difficulty*7;
        day += 1;
    }

    public int getlives(){
        return life;
    }

    public void addGold(int production) {
        gold += production;
    }

    public void addLive(int productionPV) {
        life += productionPV;
    }
}
