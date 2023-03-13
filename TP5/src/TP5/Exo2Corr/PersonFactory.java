package TP5.Exo2Corr;

public class PersonFactory {
	public Hireable hire(String type) {
		Hireable res = null;
		if (!type.equals("Ruler")) {
			res = (Hireable) getInstance(type);
		}
		return res;
	}

	public Person getInstance(String type) {
		Person res = null;
		switch (type.toLowerCase()){
			case "farmer": res = new Farmer(); break;
			case "ruler": res = new Ruler(); break;
			case "worker": res = new Worker(); break;
			case "citizen": res = new Citizen(); break;
			default : System.out.println("Invalid person type");
		}
		return res;
	}
}
