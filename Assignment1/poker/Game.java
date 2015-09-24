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

	public void addPlayer(Player player) {
		if (players == null) {
			players = new Player[1];
			players[0] = player;
		}
		else {
			Player tmp[] = new Player[players.length + 1];
			for (int i = 0; i < players.length; i++) {
				tmp[i] = players[i];
			}
			tmp[players.length] = player;
			players = tmp;
		}
	}

	public boolean uniquePlayers() {
		//case where only 2 players
		if (amountOfPlayers() == 2) {
			if (players[0].getName().equals(players[1].getName()))
				return false;
		}
		//case where 3 players
		else if (amountOfPlayers() == 3) {
			if (players[0].getName().equals(players[1].getName()) || players[0].getName().equals(players[2].getName()) || players[1].getName().equals(players[2].getName()))
				return false;
		}
		//case where 4 players
		else if (amountOfPlayers() == 4) {
			if (players[0].getName().equals(players[1].getName()) || players[0].getName().equals(players[2].getName())
					|| players[0].getName().equals(players[3].getName()) || players[1].getName().equals(players[2].getName()) || players[1].getName().equals(players[3].getName())
					|| players[2].getName().equals(players[3].getName()))
				return false;
		}
		return true;
	}

}
