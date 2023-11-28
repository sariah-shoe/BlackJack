package HW2;

public class BlackJackOdds {

	public static void main(String[] args) {
		// Create my variables that won't change with each new iteration of the loop
		int gamblerWin = 0;
		int dealerWin = 0;
		int timesGamblerHard = 0;
		int timesDealerHard = 0;
		int ties = 0;
		int gameNumber = 5000;
		
		// Loop through a game for the number of games
		for(int i = 0; i < gameNumber; i ++) {
			// Create a new deck
			Deck gameDeck = new Deck();
			gameDeck.shuffle();
			
			//Randomly decide if the dealer and the gambler are doing soft or hard stands
			boolean dealerHard;
			if((int) (Math.random()*(3-1)+ 1) == 2) {
				dealerHard = false;
			}
			else {
				dealerHard = true;
				timesDealerHard += 1;
			}
			
			boolean gamblerHard;
			if((int) (Math.random()*(3-1)+ 1) == 2) {
				gamblerHard = false;
			}
			else {
				gamblerHard = true;
				timesGamblerHard +=1;
			}
			
			
			// Create new players with a random stand from 16-18
			Player dealer = new Player((int) (Math.random()*(19-16)+ 16), dealerHard);
			Player gambler = new Player((int) (Math.random()*(19-16)+ 16), gamblerHard);
			
			// Have each player play
			gambler.play(gameDeck);
			dealer.play(gameDeck);
			
			// If the gambler isn't bust then go into that set of win conditions
			if(gambler.isBust() == false) {
				
				// If the dealer is bust, the gambler gets a win
				if(dealer.isBust()) {
					gamblerWin += 1;
				}
				
				// Otherwise compare scores
				else {
					
					// If the gamblers score is less than the dealers, the dealer wins
					if(gambler.compareScores(dealer) < 0) {
						dealerWin += 1;
					}
					
					// If the gamblers score is more than  the deals, the gambler winds
					else if(gambler.compareScores(dealer) > 0) {
						gamblerWin += 1;
					}
					
					// If the scores are the same, neither wins
					else {
						ties += 1;
					}
					
				}
				
			}
			
			// If the player is bust, the dealer automatically wins
			else {
				dealerWin += 1;
			}	
		}
		
		// Print out the total number of wins for the  gambler and the dealer
		System.out.println("Dealer " + dealerWin + " vs Gambler " + gamblerWin);
		
		// Print out the times dealer and player played soft vs hard stands
		System.out.println("Dealer played hard stands " + timesDealerHard + " times and soft stands " + (5000-timesDealerHard));
		System.out.println("Gambler played hard stands " + timesGamblerHard + " times and soft stands " + (5000-timesGamblerHard));
		
		// Calculate percentages for dealer, gambler, and no winner
		System.out.println("Dealer won " + ((float)dealerWin/5000)*100 + "% of games");
		System.out.println("Gambler won " + ((float)gamblerWin/5000)*100 + "% of games");
		System.out.println("No winner " + ((float)ties/5000)*100 + "% of games");
		

	}

}
