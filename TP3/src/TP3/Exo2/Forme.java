package TP3.Exo2;

public class Forme implements Drawable{
    private Point origine;
    private char couleur;

    public Forme(Point origine, char couleur)
    {
        this.origine = origine;
        this.couleur = couleur;
    }

    @Override
    public boolean isOn(Point p) {
        // Préciser le type d'argument dans l'interface déjà !
        return (origine.getX() == p.getX() && origine.getY() == p.getY());
    }

    @Override
    public char getColor() {
        return couleur;
    }

    public Point getOrigine() {
        return origine;
    }

    public void bouge(int dx, int dy){
        origine.bouge(dx,dy);
    }

}

