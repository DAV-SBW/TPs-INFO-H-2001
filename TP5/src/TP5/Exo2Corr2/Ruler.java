package TP5.Exo2Corr2;

public class Ruler extends Person implements Farming, Repairing {

	@Override
	public void repair(Castle c) {
		c.repair(15);
	}

	@Override
	public void farm(Castle c) {
		c.addGold(15);
	}

}
