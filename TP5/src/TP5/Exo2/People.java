package TP5.Exo2;

public abstract class People {
    protected int price;
    // On pourrait en avoir besoin dans les classes filles

    public People(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public abstract void workDay(Castle c);
}
