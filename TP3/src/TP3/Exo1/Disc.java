package TP3.Exo1;

public class Disc extends Form implements PlanarShape {

    private double radius;

    public Disc(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}
