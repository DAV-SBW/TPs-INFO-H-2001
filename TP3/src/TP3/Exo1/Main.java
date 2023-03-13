package TP3.Exo1;

import TP3.Exo1.AreaCalculator;
import TP3.Exo1.Cube;

public class Main {

    public static void main(String[] args) {
        AreaCalculator.addShape(new Cube(5));
        AreaCalculator.addShape(new Rectangle(5, 6));
        AreaCalculator.addShape(new Disc(5));
        AreaCalculator.addShape(new Sphere(3));
        AreaCalculator.addShape(new RightTriangle(2, 5));
        AreaCalculator.addShape(new Rhombus(5, 6));
        System.out.println(AreaCalculator.getTotalArea()); //391.63
        VolumeCalculator.addShape(new Sphere(2));
        VolumeCalculator.addShape(new Cube(4));
        System.out.println(VolumeCalculator.getTotalVolume()); //97.51 --> Faux chez moi...
    }
}
