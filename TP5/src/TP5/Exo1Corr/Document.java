package TP5.Exo1Corr;

import java.util.ArrayList;

public class Document implements Subject {
	private String text ="";
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public void attach(Observer o) {
		observers.add(o);
	}

	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(text);
		}
	}
	
	public void setText(String text)
	{
		if(!this.text.equals(text)) {
			this.text = text;
			notifyObservers();
		}
	}

	public String getText() {
		return text;
	}
	
}
