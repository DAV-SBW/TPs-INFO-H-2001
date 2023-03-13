package TP5.Exo2Corr2;

import TP5.Exo2Corr2.TimeSpirit;

import java.util.Random;

public class Farmer extends Person implements Farming, Hireable, Payable{
	private boolean paid = true;
	private int production;
	private int salary = 10;
	private int price = 10;

	public Farmer() {
		Random r = new Random();
		production = r.nextInt(10 - 5 + 1) + 1;
		salary = r.nextInt(4 - 2 + 1) + 1;
	}

	@Override
	public void farm(Castle castle) {
		int harvest = production* TimeSpirit.getInstance().getWeatherFactor();
		if (paid) {
			castle.addGold(harvest);
		}
		paid = false;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public int getSalary() {
		return salary;
	}

	@Override
	public void pay(int salary) {
		paid = true;
	}

}
