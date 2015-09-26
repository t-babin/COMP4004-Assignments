package poker;

public class Player {
	private String playerName;
	private Hand hand = null;
	
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

	public String getName() { return playerName; }

	public void giveHand(Hand hand) { this.hand = hand; }

	public Hand getHand() { return this.hand; }
	
	public float getHandScore() { return hand.getHandScore(); }
	
	public String toString() { return playerName + " " + getHand().toString(); }

	//eclipse-generated method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		result = prime * result
				+ ((playerName == null) ? 0 : playerName.hashCode());
		return result;
	}

	//eclipse-generated method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		return true;
	}
	
}
