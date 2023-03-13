package TP3.Exo1;

import java.util.ArrayList;

public class AreaCalculator {

    private static ArrayList<Form> forms = new ArrayList<Form>();     // ! Synthaxe ici...

    public static void addShape(Form f){
        forms.add(f);
    }
    public static double getTotalArea(){
        double totalArea = 0;
        for (Form f : forms){
            if (f instanceof PlanarShape){
                totalArea +=((PlanarShape)f).getArea();
                // On downcaste f comme étant planarShape pour que la méthode getArea puisse s'appliquer sans
                // erreur de typage à l'exécution.
            }
        }
    return totalArea;
    }
}
