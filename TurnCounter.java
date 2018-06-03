package game;

public class TurnCounter {
	int currentPlayerNr = 0;
	GamePlayer[] gamePlayer;
	GamePlayer currentPlayer;
	
	Dice[] diceArray = new Dice[5];		//creates an array of 5 dice

	TurnCounter(int playerNr){
		gamePlayer = new GamePlayer[playerNr];
		Board gameBoard = new Board(playerNr);

		for(int i = 0; i < playerNr; i++) {
			gamePlayer[i] = new GamePlayer(i);
		}
		
		
		for(int r = 0; r < diceArray.length; r++) {
			diceArray[r] = new Dice();		//fills the dice array
			//System.out.println(diceArray[r].getValue());
		}
		
		int nrOfRounds = 13;//TODO: Set back to 13
		int currentRound = 0;
		
		
		while(currentRound < nrOfRounds) {
			//This is one round
			for(int i = 0; i < playerNr; i++) {
				gamePlayer[i].startTurn();
				gameBoard.enterScore(i, gamePlayer[i].getScoredThisRound(), gamePlayer[i].getPlayerScores(gamePlayer[i].getScoredThisRound()));
				gameBoard.drawBoard();
			}
			currentRound++;
		}
		if(currentRound == nrOfRounds) {
			//TODO: draw final scores
			gameBoard.calculateFinalScores();
			gameBoard.drawBoard();
		}
	}	
}
