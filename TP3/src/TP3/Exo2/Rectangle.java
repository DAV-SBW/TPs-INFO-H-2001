package TP3.Exo2;

public class Rectangle extends Forme {
    private int largeur;
    private int hauteur;

    public Rectangle(Point origine, int largeur, int hauteur, char couleur){
        super(origine, couleur);
        setLargeur(largeur);
        setHauteur(hauteur);
    }

    public int getLargeur() {
        return largeur;
    }

    private void setLargeur(int largeur) {
        if(largeur>0){
            this.largeur = largeur;
        }
        else{
            throw new RuntimeException("La largeur doit être strictement positive");
        }
    }

    public int getHauteur() {
        return hauteur;
    }

    private void setHauteur(int hauteur) {
        if(hauteur>0){
            this.hauteur = hauteur;
        }
        else{
            throw new RuntimeException("La hauteur doit être strictement positive");
        }
    }

    public boolean isOn(Point p){
        return(p.getX() >= getOrigine().getX() &&
                p.getX() < getOrigine().getX()+largeur &&
                p.getY() >= getOrigine().getY() &&
                p.getY() < getOrigine().getY()+hauteur);
    }
}

