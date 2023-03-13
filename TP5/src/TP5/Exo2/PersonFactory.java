package TP5.Exo2;

public class PersonFactory {
    public static People getInstance(String type){
        People res = null;      // C'est comme juste People res ?
        switch (type.toLowerCase()){
            // toLowerCase() retourne la chaine de charactère courante en minuscules 
            case "farmer" : res = new Farmer(); break;
            // case "ruler" : res = new Ruler(); break;
            case "worker" : res = new Worker(); break;
            case "citizen" : res = new Citizen(); break;
            // case "priest" : res = new Priest(); break;
            default : System.out.println("Invalid person Type");
        }
        return res;
    }
}
