package TP5.Exo1;

import java.util.ArrayList;

public class Document implements Subject{
    private String text ="";
    private ArrayList<Observer> Observers = new ArrayList<Observer>();

    @Override
    public void attach(Observer o) {
        Observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : Observers){
            o.update(text);
        }
    }


    public void setText(String text) {
        if(!this.text.equals(text)) {
            this.text = text;
            notifyObservers();
            // Le faire dès qu'on touche au texte...
        }
    }

    public String getText() {
        return text;
    }

}
