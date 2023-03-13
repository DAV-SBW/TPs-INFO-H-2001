package TP5.Exo2Corr2;

public class Priest extends Person implements Praying, Hireable, Payable{
	private boolean paid = true;
	private int salary = 3;
	private int price = 6;

	public int getSalary() {
		return salary;
	}

	public void pay(int salary) {
		paid = true;
	}

	public void pray() {
		TimeSpirit.getInstance().receiveSacrifice();
		paid = false;
	}

	@Override
	public int getPrice() {
		return price;
	}

}
