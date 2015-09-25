package poker;

public class Player {
	private String playerName;
	
	public Player() {
		playerName = "";
		validName(playerName);
	}
	
	public Player(String name) {
		if (validName(name))
			playerName = name;
		else
			playerName = "user";
	}

	public boolean validName(String name) {
		if (name.contains(" "))
			return false;
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i)) && !Character.isDigit(name.charAt(i)))
				return false;
		}
		playerName = name;
		return true;
	}

	public String getName() {
		return playerName;
	}

	public void giveHand(Hand hand) {
		// TODO Auto-generated method stub
	}
}
