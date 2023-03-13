package TP5.Exo2Corr;


public class Main {

	public static void main(String[] args) {
		int gold = 200;
		int lp = 500;
		int difficulty = 20;
	

		Castle c = new Castle(gold, lp, difficulty);
		c.play();
	}
}
