package poker;

//import java.util.ArrayList;

public class Game {
	Player[] players = null;

//	public Game(Player p1, Player p2) {
//		players = new ArrayList<Player>();
//		players.add(p1);
//		players.add(p2);
//	}
//	
//	public Game(Player p1, Player p2, Player p3) {
//		players = new ArrayList<Player>();
//		players.add(p1);
//		players.add(p2);
//		players.add(p3);
//	}
//	
//	public Game(Player p1, Player p2, Player p3, Player p4) {
//		players = new ArrayList<Player>();
//		players.add(p1);
//		players.add(p2);
//		players.add(p3);
//		players.add(p4);
//	}

	public Game() {
		setPlayerAmount(0);
	}

	public int amountOfPlayers() {
		return players.length;
	}

	public void setPlayerAmount(int amount) {
		players = new Player[amount];
		for (int i = 0; i < amount; i++)
			players[i] = new Player();

	}

}
