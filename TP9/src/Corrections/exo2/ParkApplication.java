package Corrections.exo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ParkApplication {
	private Park park = new Park();

	private String message = "Welcome to ParkGarden";  // message � afficher � l'utilisateur au draw()

	public Park load(String filename){
		FileInputStream file;
		ObjectInputStream i;
		try {
			file = new FileInputStream(filename);
			i = new ObjectInputStream(file);
			park = (Park) i.readObject();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return park;
	}

	public void save(String filename, Park park) {
		FileOutputStream file;
		ObjectOutputStream o;
		try {
			file = new FileOutputStream(filename);
			o = new ObjectOutputStream(file);
			o.writeObject(park);
			o.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void run() throws IOException {
        String line="";
		int n, posx, posy;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		park = load("save.serial");
		
		while(true) {
			System.out.println(message);
			message = ""; // reset message
			try {
	            line = input.readLine();
				if(line.startsWith("stop")) break;
				String[]  command = line.split(" ");
	            if(command.length == 3 && command[0].equals("add")) {
	            	posx = Integer.parseInt(command[1]);
	                posy = Integer.parseInt(command[2]);
	                park.addWanderer(posx, posy);
	            } else if(command.length == 4 && command[0].equals("move")) {
	                n = Integer.parseInt(command[1]);
	                posx = Integer.parseInt(command[2]);
	                posy = Integer.parseInt(command[3]);
	                Wanderer wanderer = park.getWanderer(n);
	                wanderer.move(posx, posy);
	            } else {
					this.message ="Unrecognized command: "+line;
					this.message += "\nCommands are : \n "
							+"  add x y (where x and y are the positions),\n"
							+"  move n x y (where n is the index of the traveler and x,y the movement offset),\n"
							+"  stop\n";
	            }
			}catch (Exception e) {
				this.message = "Commands are : \n "
					+"  add x y (where x and y are the positions),\n"
					+"  move n x y (where n is the index of the traveler and x,y the movement offset),\n"
					+"  stop\n";
			}
			park.draw();			
		}
		
		save("save.serial",park);

    }

    public static void main(String[] args) throws Exception {
        ParkApplication pa = new ParkApplication();
        pa.run();
     }
}
