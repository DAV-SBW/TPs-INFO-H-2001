package TP5.Exo2Corr;

import java.util.ArrayList;
import java.util.Scanner;

public class Castle {
	private int day;
	private int gold;
	private int lp;
	private int max_lp;
	private int difficulty;
	private PersonFactory personFactory = new PersonFactory();
	private ArrayList<Person> habitants = new ArrayList<Person>();
	
	public Castle(int gold, int lifepoints, int difficulty) {
		this.gold = gold;
		this.lp = lifepoints;
		this.max_lp = lifepoints;
		this.difficulty = difficulty;
		habitants.add(personFactory.getInstance("Ruler"));
	}
	
	public boolean surviveDay() {
		max_lp += difficulty;
		for (Person p: habitants) {
			if (p instanceof Farming) {
				// gold += ((Farming)p).getProduction();
				((Farming)p).farm(this);
			}
			if (lp < max_lp) {
				if (p instanceof Repairing) {
					((Repairing)p).repair(this);
				}
			}
		}
		for (Person p: habitants) {
			int salary =  0;
			if(p instanceof Payable) {
				salary = ((Payable)p).getSalary();
				salary = Math.min(salary, gold);
				gold -= salary;
				((Payable)p).pay(salary);
			}
		}
		lp -= day*difficulty;
		day += 1;
		return lp>0;
	}
	
	public void hire() {
		Scanner in = new Scanner(System.in);
		boolean stop = false;
		while(!stop)
		{
			System.out.println("Who do you want to hire? You have " + gold + " Golds. [stop to quit]");
			String line = in.nextLine();
			String[] words = line.split(" ");
			String order = words[0];
			int price = 0;
			if (order != null) {
				if (order.equals("stop")) {
				stop = true;
				} else {
					for (int i = 0; i < Integer.parseInt(words[1]); i++) {
						Hireable newHabitant = personFactory.hire(order);
						if (newHabitant != null) {
							price = newHabitant.getPrice();
							if (price <= gold) {
								gold -= price;
								habitants.add((Person) newHabitant);
							}
						}
					}
				}
			}
		}
	}

	public void play() {
		hire();
		while(surviveDay()) {
			System.out.println("New day: you got " + lp + "/" + max_lp + " lp");
			hire();
		}
		System.out.println("game over, you survived " + day + " days");
	}

	public void addGold(int gold) {
		this.gold += gold;
	}

	public void repair(int qty){
		lp = Math.min(lp+qty, max_lp);
	}

}
