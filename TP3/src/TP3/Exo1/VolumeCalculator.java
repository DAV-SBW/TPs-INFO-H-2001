package TP3.Exo1;

import java.util.ArrayList;

public class VolumeCalculator {

    private static ArrayList<Form> forms = new ArrayList<Form>();

    public static void addShape(Form f){
        forms.add(f);
    }

    public static double getTotalVolume(){
        double totalVolume = 0;
        for (Form f : forms){
            if (f instanceof SolidShape){
                totalVolume += ((SolidShape)f).getVolume();
                // Downcasting de f pour lui appliquer la méthode getVolume
            }
        }
        return totalVolume;
    }
}
