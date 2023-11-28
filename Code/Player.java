package HW2;

public class Player {
	private Hand playerHand;
	private int standValue;
	private boolean hardStand;
	
	//Constructor for player
	public Player(int sv, boolean hS) {
		this.playerHand = new Hand();
		this.standValue = sv;
		this.hardStand = hS;
	}
	
	//String representation of player
	public String toString() {
		return(this.playerHand.toString());
	}
	
	//Takes cards until player is at or above stand value
	public void play(Deck theDeck) {
		// If the player is doing a hard stand, follow hard stand rules
		if(this.hardStand) {
			while(true) {
				// If the hand is hard
				if(playerHand.getHard()) {
					// If hand at the stand value, break the loop, done playing
					if(this.standValue <= this.playerHand.getScore()) {
						break;
					}
					// If hand not at the stand value, hit again
					else {
						this.playerHand.addCard(theDeck.deal());
					}
				}
				// If the hand is soft, hit
				else {
					this.playerHand.addCard(theDeck.deal());
				}
			}
		}
		
		// If the player is doing a soft hand, follow soft hand rules
		else {
			while(this.standValue >= this.playerHand.getScore()) {	
				this.playerHand.addCard(theDeck.deal());
			}
		}	
	}
	
	//Checks to see if player is bust
	public boolean isBust() {
		if (this.playerHand.getScore() > 21) {
			return(true);
		}
		return(false);
	}
	
	//Compares this players score to another players score
	public int compareScores(Player playerTwo) {
		return(this.playerHand.getScore() - playerTwo.playerHand.getScore());
	}

}
