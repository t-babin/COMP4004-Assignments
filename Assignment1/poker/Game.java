package poker;

import java.util.Arrays;

public class Game {
	private Player[] players = null;
	private Player[] playersByRank = null;

	public Game() {
		setPlayerAmount(0);
	}

	public int amountOfPlayers() {
		return players.length;
	}

	public void setPlayerAmount(int amount) {
		players = new Player[amount];
		for (int i = 0; i < amount; i++) {
			players[i] = new Player();
		}
		playersByRank = players;

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
		playersByRank = players;
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

	public Player getPlayer(int index) {
		return (index < amountOfPlayers()) ? players[index] : null;
	}

	public int getPlayerRank(Player player) {
		return 0;
	}

	public Player[] getPlayersSorted() {
		java.util.ArrayList<Player> tmp = new java.util.ArrayList<Player>(Arrays.asList(players));
		java.util.Collections.sort(tmp, new java.util.Comparator<Player>() {
			public int compare(Player p1, Player p2) {
				return Float.valueOf(p2.getHandScore()).compareTo(p1.getHandScore());
			}
		});
		for (int i = 0; i < players.length; i++) {
			playersByRank[i] = tmp.get(i);
		}
		
		return playersByRank;
	}

}
