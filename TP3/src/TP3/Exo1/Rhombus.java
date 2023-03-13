package TP3.Exo1;

public class Rhombus extends Form implements PlanarShape {
    private int grandeDiagonale;
    private int petiteDiagonale;

    public Rhombus(int grandeDiagonale, int petiteDiagonale){
        this.petiteDiagonale = petiteDiagonale;
        this.grandeDiagonale = grandeDiagonale;
    }

    @Override
    public double getArea() {
        return grandeDiagonale*petiteDiagonale/2;
    }
}
