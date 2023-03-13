package TP5.Exo2;

public class Citizen extends People{
    private int goldProd = 2;
    private int PVProd = 2;

    public Citizen(){
        // Appel au constructeur de la classe parent
        super(4);
    }

    @Override
    public void workDay(Castle c) {
        c.addGold(goldProd);
        c.addLive(PVProd);
    }
}
