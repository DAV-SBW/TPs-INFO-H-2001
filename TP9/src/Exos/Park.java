package Exos;

import java.io.*;
import java.util.ArrayList;

public class Park {
	final int HEIGTH = 20;
	final int WIDTH = 20;
	private final int MAX_WANDERERS = 10;

	// private Wanderer[] wanderers = new Wanderer[MAX_WANDERERS];
	private ArrayList<Wanderer> wanderers = new ArrayList<Wanderer>();
    private int count = 0;

	private int occupied(int x, int y) {
		for(int k = 0; k<wanderers.size(); k++) {
			if(wanderers.get(k).at(x,y)) {
				return k;
			}
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
			count++;
			return wanderer;
		}
    }

 	private void clearConsole() {
		int i = 100;
		while(i-- > 0) System.out.println();
    }

	public Wanderer getWanderer(int n) {
		if(n<0 || n>=count) {
			return null;
		} else {
			return wanderers.get(n);
		}
	}

	public void removeLastWanderer() {
		this.count--;
		wanderers.remove(wanderers.size()-1);
	}

	public void save(String filename) {
		String txt = "";
		for (int i = 0; i< wanderers.size(); i++){
			String line = "";
			line = line + String.valueOf(i)+",";
			line = line + wanderers.get(i).getPosx()+",";
			line = line + wanderers.get(i).getPosx()+"\n";

			txt += line;
		}

		BufferedWriter file;
		try {
			file = new BufferedWriter((new FileWriter(filename)));
			file.write(txt);
			file.close();
			(System.out).println("File saved !");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void load(String filename) {
		String line;
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader(filename));
			while ((line = file.readLine()) != null){
				String[] parts = line.split(",");
				addWanderer(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
			}
			file.close();
			System.out.println("File loaded !");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
