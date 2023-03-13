package TP5.Exo2Corr;

import java.util.Random;

public class Worker extends Person implements Hireable, Payable, Repairing{
	private boolean paid = true;
	private int repairation;
	private int salary = 10;
	private int price = 15;

	public Worker() {
		Random r = new Random();
		repairation = r.nextInt(5 - 0 + 1) + 1;
		salary = r.nextInt(8 - 5 + 1) + 1;
	}

	public void repair(Castle c) {
		if (paid) {
			c.repair(repairation);
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
