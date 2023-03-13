package TP3.Exo1;

public class RightTriangle extends Form implements PlanarShape {
    private int base;
    private int hauteur;

    public RightTriangle(int hauteur,int base){
        this.hauteur = hauteur;
        this.base = base;
    }

    @Override
    public double getArea() {
        return base*hauteur/2;
    }
}
