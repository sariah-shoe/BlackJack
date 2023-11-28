package HW2;

public class Card {
	//Create my class variables, rank and suit
	private int cardRank;
	private char cardSuit;
	
	//Constructor for card class that sets rank and suit
	public Card(int rank, char suit) {
		this.cardRank = rank;
		this.cardSuit = suit;
	}
	
	// To string override to make Card readable
	public String toString() {
		//Create two arrays that have my face ranks and values with coordinating indexes
		int[] faceRanks = {11,12,13,14};
		char[] faceValues = {'J','Q','K','A'};
		
		// Go through the 4 possible face cards and see if this card is one, if so use corresponding rank and name
		for(int i = 0; i < 4; i++) {
			if (faceRanks[i] == this.cardRank) {
				return("Card: " + faceValues[i] + this.cardSuit);
			}
		}
		
		// If I didn't return before then I am not a face card so just return rank and suit
		return("Card: " + this.cardRank + this.cardSuit);	
	}
	
	//Copies the rank and suit over to a new card
	public Card(Card cr) {
		this.cardRank = cr.cardRank;
		this.cardSuit = cr.cardSuit;
	}
	
	//Equals method
	@Override
	public boolean equals(Object c) {
		// Check to see if the object is a card
		Card card = null;
		if(c instanceof Card) {
			card = (Card)c;
		}
		// If it is a card, then see if rank and suit values are true
		if (this.cardRank == card.cardRank && this.cardSuit == card.cardSuit) {
			return(true);
		}
		return(false);
	}
	
	// Method to get score of a card
	public int getScore() {
		// Initalize a return score variable
		int returnScore = 0;
		
		// Go through a loop that checks if a card is a face card
		for(int i = 11; i < 14; i ++) {
			// If the card is a face card, return score is 10
			if(this.cardRank == i) {
				returnScore = 10;
			}
		}
		
		// Check is the card is an ace, if it is return score is 11
		if(this.cardRank == 14) {
			returnScore = 11;
		}
		
		// Check if my return score has been changed, if not just set it to the card value
		if (returnScore == 0) {
			returnScore = this.cardRank;			
		}

		// Return whatever the return score resulted in
		return(returnScore);
		
	}
	
	public int getCardRank(){
		return(this.cardRank);
	}
	

}
