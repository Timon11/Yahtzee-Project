package game;

public class TurnCounter {
	int currentPlayerNr = 0;
	GamePlayer[] gamePlayer;
	GamePlayer currentPlayer;
	
	Dice[] diceArray = new Dice[5];		//creates an array of 5 dice

	TurnCounter(int playerNr){
		gamePlayer = new GamePlayer[playerNr];
		
		for(int i = 0; i < playerNr; i++) {
			gamePlayer[i] = new GamePlayer(i);
		}
		
		
		for(int r = 0; r < diceArray.length; r++) {
			diceArray[r] = new Dice();		//fills the dice array
			//System.out.println(diceArray[r].getValue());
		}

		currentPlayer = gamePlayer[currentPlayerNr];
		currentPlayer.startTurn();
	}	
}
