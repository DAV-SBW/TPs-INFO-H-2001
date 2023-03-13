package Exos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkApplication {
	private Park park = new Park();

	private String message = "Welcome to ParkGarden";  // message ? afficher ? l'utilisateur au draw()

    public void run() throws IOException {
        String line="";
		int n, posx, posy;
		BufferedReader input = new BufferedReader(
						new InputStreamReader(System.in));

		park.load("park.txt");

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
	            }
			}catch (Exception e) {
				this.message = "Commands are : \n "
					+"  add x y (where x and y are the positions),\n"
					+"  move n x y (where n is the index of the traveler and x,y the movement offset),\n"
					+"  undo"
					+"  redo"
					+"  print_commands"
					+"  stop\n";
			}
			park.draw();
		}
		park.save("park.txt");
    }

    public static void main(String[] args) throws Exception {
        ParkApplication pa = new ParkApplication();
        pa.run();
     }
}
