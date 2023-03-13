package TP5.Exo2;

import java.util.Random;

public class Worker extends People implements Payable {
    int productionPV;
    private int salary;
    private boolean paid;

    public Worker(){
        super(15);
        Random r = new Random();
        productionPV = r.nextInt(6);
        salary = 5 + r.nextInt(4);
    }

    @Override
    public void workDay(Castle c) {
        if (paid) {
            c.addLive(productionPV);
        }
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void pay() {
        paid = true;

    }
}
