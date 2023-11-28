package HW2;

public class BlackJackBasicTest {

	public static void main(String[] args) {
		// Create and shuffle a new deck
		Deck gameDeck = new Deck();
		gameDeck.shuffle();
		
		// Create a player with a standing value of 17 and have them play
		Player playerone = new Player(17, true);
		playerone.play(gameDeck);
		
		// Print the results of the game
		System.out.println(playerone);

	}
	

}
