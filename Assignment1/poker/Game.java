package poker;

public class Game {
	private Player[] players = null;

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

	public Player getPlayer(int index) {
		return (index < amountOfPlayers()) ? players[index] : null;
	}

	public int getPlayerRank(Player player) {
		return 0;
	}

}
