package TP3.Exo1;

public class Rectangle extends Form implements PlanarShape {

    private int length;
    private int height;

    public Rectangle(int length,int height){
        this.length = length;
        this.height = height;
    }

    @Override
    public double getArea() {
        return length*height;
    }
}