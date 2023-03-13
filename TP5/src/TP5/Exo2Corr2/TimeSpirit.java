package TP5.Exo2Corr2;

public class TimeSpirit {
	private static TimeSpirit ts = null;
	private int production_factor = 1;
	private int sacrifices = 0;
	private int days_left = 0;


	private TimeSpirit() {
		
	}
	
	public void receiveSacrifice() {
		sacrifices += 1;
		if (sacrifices > 40) {
			sacrifices -= 40;
			production_factor = 2;
			days_left = 5;
		}
	}
	
	public void passDay() {
		if (days_left == 1)
			production_factor = 1;
		if (days_left >= 1) 
			days_left -= 1;
	}
	
	public int getWeatherFactor() {
		return production_factor;
	}
	
	public int getSacrifices() {
		return sacrifices;
	}
	
	public static TimeSpirit getInstance() {
		if(ts == null) {
			ts = new TimeSpirit();
		}
		return ts;
	}

}
