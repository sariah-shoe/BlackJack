package HW2;
import java.util.ArrayList;

public class Deck {
	// Create the class variable
	private ArrayList<Card> myDeck;
	
	// Constructor for Deck class
	public Deck() {
		// Create an empty arraylist of cards
		this.myDeck = new ArrayList<Card>();
		
		// Create an empty deck by looping through each suit and then looping through each rank in the suit
		char[] suits = {'c','s','h','d'};
		for(char i : suits) {
			for (int j = 2; j < 15; j++) {
				this.myDeck.add(new Card(j, i));
			}
		}
	}
	
	// To string method
	public String toString() {
		// Create my starting string
		String returnStr = "Deck: [";
		
		// Loop through every card in the deck to add it to the string
		for(Card i : this.myDeck) {
			returnStr = returnStr + i.toString();
			
			// If it's not the last card in the deck, add a comma and space at end
			if(this.myDeck.indexOf(i) != (this.myDeck.size()-1)) {
				returnStr = returnStr + ", ";
			}
		}
		
		// Add my closing bracket and return the string
		returnStr = returnStr + "]";
		return(returnStr);
	}
	
	// Get the top card off the deck and deal it
	public Card deal() {
		// Save the card in a variable, remove the card, and return the saved card
		Card returnCard = this.myDeck.get(0);
		this.myDeck.remove(0);
		return(returnCard);
	}
	
	// Randomly shuffle the deck
	public void shuffle() {
		// Loop through the shuffling process 100 times
		for (int i = 0; i < 100; i++) {
			// Get two random values to swap places
			int randValueOne = (int)(Math.random()*52);
			int randValueTwo = (int)(Math.random()*52);
			
			// Save one index in a temporary variable and then do the swap
			Card tempCard = this.myDeck.get(randValueOne);
			this.myDeck.set(randValueOne, this.myDeck.get(randValueTwo));
			this.myDeck.set(randValueTwo, tempCard);
		}
	}
	
	// Put all the aces at the beginning of the deck
	public void stack() {
		// Create the variables I need to do the operation
		int aceIndex;
		Card tempCard;
		char[] suits = {'c','s','h','d'};
		
		// Loop through 4 times, one for each ace
		for(int i = 0; i < 4; i++) {
			// Find the index of the ith suit's ace and then move it to the ith position
			aceIndex = this.myDeck.indexOf(new Card(14,suits[i]));
			tempCard = this.myDeck.get(aceIndex);
			this.myDeck.set(aceIndex, this.myDeck.get(i));
			this.myDeck.set(i, tempCard);
		}
	}

}
