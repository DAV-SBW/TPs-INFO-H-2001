package TP3.Exo1;

public class Cube extends Form implements SolidShape, PlanarShape {

    private int cote;

    public Cube(int cote){
        this.cote = cote;
    }

    @Override
    public double getVolume() {
        return Math.pow(cote,3);
    }

    @Override
    public double getArea() {
        return 6*Math.pow(cote,2);
    }
}
