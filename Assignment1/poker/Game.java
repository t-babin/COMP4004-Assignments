package poker;

import java.util.Arrays;

public class Game {
	private Player[] players = null;
//	private Player[] playersByRank = null;

	public Game() {
//		setPlayerAmount(amount);
//		players = new Player[1];
//		playersByRank = players;
	}

	public int amountOfPlayers() {
		return players.length;
	}

	public boolean setPlayerAmount(int amount) {
		if (amount < 2 || amount > 4)
			return false;
		players = new Player[amount];
		for (int i = 0; i < amount; i++) {
			players[i] = new Player();
		}
//		playersByRank = players;
		return true;
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
//		playersByRank = players;
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
	
	private boolean isDuplicatePlayer(String name) {
		if (players == null)
			return false;
		for (int i = 0; i < players.length; i++) {
			if (name.equals(players[i].getName()))
				return true;
		}
		return false;
	}

	public Player getPlayer(int index) {
		return (index < amountOfPlayers()) ? players[index] : null;
	}

	public int getPlayerRank(Player player) {
		Player[] tmp = getPlayersSorted();
		for (int i = 0; i < tmp.length; i++) {
			if (player.equals(tmp[i])) {
				if (i != 0) {
					if (player.getHandScore() == tmp[i-1].getHandScore())
						return i;
					else
						return i+1;
				}
				else
					return i+1;
			}
		}
		return 0;
	}

	public Player[] getPlayersSorted() {
		Player[] playersByRank = new Player[players.length];
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

	public boolean takeInput(String input) {
		String[] tokens = input.split(" ");
		if (tokens.length != 6)
			return false;
		Player p = new Player();
		Card[] cards = new Card[5];
		if (p.validName(tokens[0])) {
			if (!isDuplicatePlayer(tokens[0])) {
				for (int i = 0; i < tokens.length-1; i++) {
					if (Card.isValidInput(tokens[i+1])) {
						cards[i] = new Card(tokens[i+1]);
					}
				}
				Hand h = new Hand(cards[0], cards[1], cards[2], cards[3], cards[4]);
				System.out.println(h);
				if (h.noDuplicates()) {
					if (players != null) {
						for (Player player : players) {
							if (h.equals(player.getHand()))
								return false;
						}
					}
					this.addPlayer(p);
					p.giveHand(h);
					return true;
				}
				else
					return false;
			}
			else 
				return false;			
		}
		else 
			return false;
	}

}
