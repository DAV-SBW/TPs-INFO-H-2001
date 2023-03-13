package Corrections.exo3;

import java.util.ArrayList;

public class Park{
	final int HEIGTH = 20;
	final int WIDTH = 20;
	private final int MAX_WANDERERS = 10;

	//private Wanderer[] wanderers = new Wanderer[MAX_WANDERERS];
	private ArrayList<Wanderer> wanderers = new ArrayList<Wanderer>();
    private int count = 0;

	private int occupied(int x, int y) {
		for(int k = 0; k<wanderers.size() ; k++) {
			if(wanderers.get(k).at(x,y)) return k;
        }
		return -1;
	}

	public void draw() {
		clearConsole();
		for(int i = 0 ; i<=HEIGTH ; i++) {
            for(int j = 0 ; j<=WIDTH ; j++) {
				int iTraveler = occupied(i,j);
            	if(iTraveler >= 0)
					System.out.print(iTraveler);
				else
					System.out.print(" ");
        	}
		System.out.println();
        }
    }

	private boolean in(int posx, int posy) {
		return posx<WIDTH && posx>=0 && posy>=0 && posy<HEIGTH;
	}

    public Wanderer addWanderer(int posx,int posy) throws Exception {
    	if (count >= MAX_WANDERERS) {
			throw new Exception("Too many wanderers");
		} else if (!in(posx, posy)) {
			throw new Exception("Wanderer out of bounds");
		} else if (occupied(posx, posy)>=0) {
			throw new Exception("Occupied");
		} else {
			Wanderer wanderer = new Wanderer(posx, posy);
			wanderers.add(wanderer);
			return wanderer;
		}
    }

 	private void clearConsole() {
		int i = 100;
		while(i-- > 0) System.out.println();
    }

	public Wanderer getWanderer(int n) {
		return wanderers.get(n);
	}

	public void removeLastWanderer() {
		wanderers.remove(wanderers.size()-1);
	}
	
	public void load(String filename){
		Db db = new Db();
		ArrayList<String> results = db.query();
		for(int i=0; i<results.size(); i=i+3){
			try {
				Wanderer wand = addWanderer(Integer.valueOf(results.get(i+1)),Integer.valueOf(results.get(i+2)));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void save(String filename){
		Db db = new Db();
		db.clean();
		db.create();
		for(int i = 0; i<wanderers.size(); i++){
			db.insert(i, wanderers.get(i).getPosX(), wanderers.get(i).getPosY());
		}	
	}
}
