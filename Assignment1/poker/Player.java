package poker;

public class Player {
	private String playerName;
	
	public Player() {
		playerName = "";
		setName(playerName);
	}

	public boolean setName(String name) {
		if (name.contains(" "))
			return false;
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i)) && !Character.isDigit(name.charAt(i)))
				return false;
		}
		playerName = name;
		return true;
	}
}
