package TP3.Exo1;

public class Sphere extends Form implements SolidShape, PlanarShape {

    private int radius;

    public Sphere(int radius){
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return 4/3*Math.PI*Math.pow(radius,3);
    }

    @Override
    public double getArea() {
        return 4*Math.PI*Math.pow(radius,2);
    }
}
// Note : Ici, on peut faire du multihéritage avec des interfaces, impossible si SolidShape et PlanarShape étaient
// deux sous classes de Form par exemple d'où la nécessité des interfaces + méthodes à redéfinir.