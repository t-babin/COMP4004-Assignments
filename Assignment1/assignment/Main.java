package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import poker.*;

public class Main {

	public static void main(String[] args) {
		try {
			Game g = new Game();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("How Many Players Are Playing? (2-4)");
			
			String input;
			input = br.readLine();
			if (g.setPlayerAmount(Integer.parseInt(input))) {
				System.out.println("Now Enter Each Players' Hand in the following format:\n[Name] [Card 1] [Card 2] [Card 3] [Card 4] [Card 5]");
				System.out.println("Where [Card i] is Written as ValueSuit");
				for (int i = 0; i < g.amountOfPlayers(); i++) {
					System.out.print("Player " + (i+1) + ": ");
					input = br.readLine();
					if (!g.takeInput(input)) {
						System.out.println("Sorry, " + input + " is not a valid input");
						System.exit(-1);
					}
				}
				System.out.println("Computing Player Rankings...");
				System.out.println(g.getOutputString());
			}
			else {
				System.out.println("Sorry, " + input + " is not a valid player amount.");
				System.exit(-1);
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
