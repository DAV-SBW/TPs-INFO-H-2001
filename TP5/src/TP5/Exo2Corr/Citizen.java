package TP5.Exo2Corr;

public class Citizen extends Person implements Farming, Repairing, Hireable{
	private int repairation = 2;
	private int production = 2;
	private int cost = 5;

	public void repair(Castle c) {
		c.repair(repairation);
	}

	public void farm(Castle c) {
		c.addGold(production);
	}

	public int getPrice() {
		return cost;
	}

}
