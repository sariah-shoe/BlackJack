package HW2;
import java.util.ArrayList;

public class Hand {
	// Create the class variables needed
	private ArrayList<Card> myHand;
	private int score;
	private boolean hard;
	
	//Constructor for hand, create an empty arraylist of cards
	public Hand() {
		this.myHand = new ArrayList<Card>();
		this.score = 0;
		this.hard = true;
	}
	
	// To string method
	public String toString() {
		
		// Get a string representation of hard or soft
		String hardSoft;
		if (this.hard){
			hardSoft = "hard";
		}
		else {
			hardSoft = "soft";
		}
		
		//Create my starting string
		String returnStr = "Score: " + this.score + " This is a " + hardSoft + "hand." + " \n Hand: [";
		
		//Loop through every card in my hand and add it to the string
		for(Card i : this.myHand) {
			returnStr = returnStr + i.toString();
			
			//If this card isn't the last in the hand, at a comma and space
			if(this.myHand.indexOf(i) != (this.myHand.size()-1)) {
				returnStr = returnStr + ", ";
			}
		}
		
		//Add the ending bracket and return the string
		returnStr = returnStr + "]";
		return(returnStr);
	}
	
	// Add a new card to the hand and add its score to the hands score
	public void addCard(Card newCard) {
		this.myHand.add(newCard);
		this.updateScore(newCard);
	}
	
	private void updateScore(Card newCard) {
		// Check to see if the card is an ace
		if (newCard.getCardRank() == 11) {
			// If an 11 will bust then play as 1 and make the hand hard
			if((this.score + 11) > 21) {
				this.score = this.score + 1;
			}
			// Otherwise, add 11 to the score and make the hand soft
			else {
				this.score = this.score + 11;
				this.hard = false;
			}
		}
		
		// If this is not an ace
		else {
			// Check to see if this card will bust and if the hand is soft
			if(((this.score + newCard.getScore()) > 21) && (this.hard == false)){
				// If it is, change the ace to a 1 an make the hand hard
				this.score = this.score - 10;
				this.hard = true;
			}
			// Add the score of the card
			this.score = this.score + newCard.getScore();	
		}
	}
	
	// Commented out because irrelevant for blackjack
//	// If the card is in the hand, remove the card from the hand
//	public void removeCard(Card badCard) {
//		if(this.myHand.contains(badCard)) {
//			this.myHand.remove(badCard);
//		}
//	}
	
	// Gets the score of the current hand
	public int getScore() {
		return(this.score);
	}
	
	// Gets whether or not the current hand is hard
	public boolean getHard() {
		return(this.hard);
	}		

}
