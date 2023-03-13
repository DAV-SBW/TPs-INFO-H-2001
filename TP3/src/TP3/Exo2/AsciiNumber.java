package TP3.Exo2;

public class AsciiNumber implements Drawable {

    private int nombre;
    private Point origine;

    public AsciiNumber(int nombre, Point origine){
        if (nombre >= 0 && nombre < 10){
            this.nombre = nombre;
        }
        this.origine = origine;
    }

    @Override
    public boolean isOn(Point p) {
        int x = p.getX();
        int y = p.getY();
        int x2 = origine.getX();
        int y2 = origine.getY();
        if (x2<=x && x2+3>x && y2<=y && y2+5>y){
            return NUMBERS[nombre][(y-y2)][(x-x2)];
            // Return True en fait...
        } else {
            return false;
        }
    }

    @Override
    public char getColor() {
        return (""+nombre).charAt(0);
        // Méthode chatAt()
        // Retourne le caractère de la chaîne correspondant à la position indiquée en paramètre de charAt().
        // Le premier caractère d'une chaîne correspond à l'indice 0
    }

    private static final boolean[][][] NUMBERS =
            {
                    // number 0
                    {{false,true,false},
                            {true,false,true},
                            {true,false,true},
                            {true,false,true},
                            {false,true,false},
                    },
                    // number 1
                    {{false,false,true},
                            {false, true, true},
                            {false, false, true},
                            {false, false, true},
                            {false, false, true}
                    },
                    //number 2
                    {
                            {true,true,true},
                            {false,false,true},
                            {false, true, true},
                            {true, false, false},
                            {true, true, true}
                    },
                    //number 3
                    {
                            {true,true,true},
                            {false,false,true},
                            {false, true, true},
                            {false,false,true},
                            {true, true, true}
                    },
                    //number 4
                    {
                            {false,false,true},
                            {false,true,true},
                            {true, true, true},
                            {false, false, true},
                            {false, false, true}
                    },
                    //number 5
                    {
                            {true,true,true},
                            {true,false,false},
                            {false, true, true},
                            {false, false, true},
                            {true, true, true}
                    },
                    //number 6
                    {
                            {false,true,true},
                            {true,false,false},
                            {true, true, true},
                            {true, false, true},
                            {true, true, true}
                    },
                    //number 7
                    {
                            {true,true,true},
                            {false,false,true},
                            {false, true, false},
                            {true, false, false},
                            {true, false, false}
                    },
                    //number 8
                    {
                            {true,true,true},
                            {true,false,true},
                            {true, true, true},
                            {true, false, true},
                            {true, true, true}
                    },
                    //number 9
                    {
                            {true,true,true},
                            {true,false,true},
                            {true, true, true},
                            {false, false, true},
                            {true, true, true}
                    }
            };

}
