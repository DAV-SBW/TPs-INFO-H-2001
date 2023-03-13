package TP5.Exo2Corr2;

import TP5.Exo2Corr2.TimeSpirit;

import java.util.Random;

public class Worker extends Person implements Hireable, Payable, Repairing {
	private boolean paid = true;
	private int reparation;
	private int salary = 10;
	private int price = 15;

	public Worker() {
		Random r = new Random();
		reparation = r.nextInt(5 - 0 + 1) + 1;
		salary = r.nextInt(8 - 5 + 1) + 1;
	}

	public void repair(Castle c) {
		int repairs = reparation * TimeSpirit.getInstance().getWeatherFactor();
		if (paid) {
			c.repair(repairs);
		}
	}


	public int getSalary() {
		return salary;
	}

	@Override
	public void pay(int salary) {
		paid = true;
	}

	@Override
	public int getPrice() {
		return price;
	}

}
