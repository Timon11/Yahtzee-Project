package game;

import java.util.ArrayList;

public class MainGame {
	
	int currentPlayer = 1;
	
	int ONES;
	int TWOS;
	int THREES;
	int FOURS;
	int FIVES;
	int SIXES;
	
	public static void main(String [] args) {
		MenuScreen menuScreen = new MenuScreen();
	//	Board gameBoard = new Board(menuScreen.getNumberOfPlayers());
		
		
		
		Dice[] diceArray = new Dice[5];		//creates an array of 5 dice
					
		for(int r = 0; r < diceArray.length; r++) {
			diceArray[r] = new Dice();		//fills the dice array
			//System.out.println(diceArray[r].getValue());
		}
		
		
	}
		
	static void countScores() {
		int ONES;
		int TWOS;
		int THREES;
		int FOURS;
		int FIVES;
		int SIXES;
	//	int UpperScore = ONES + TWOS + THREES + FOURS + FIVES + SIXES;
		boolean BONUS = false;
		int TotalUpper;
		if(BONUS == true) {
	//		TotalUpper = UpperScore + 35;
		}else {
	//		TotalUpper = UpperScore;
		}
		int ThreeOfAKind;
		int FourOfAKind;
		boolean FullHouse = false;
		boolean SmStraight = false;
		boolean LgStraight = false;
		boolean Yathzee = false;
		int Chance;
		int TotalLower = 0;
		
		
	}
}
