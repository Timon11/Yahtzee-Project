package game;

import java.util.Scanner;

public class GamePlayer {
	int myNumber;
	Scanner input = new Scanner(System.in);
	Dice[] diceArray = new Dice[5];		//creates an array of 5 dice
	int rerollTries;
	
	private int aces;
	int twos;
	int threes;
	int fours;
	int fives;
	int sixes;
	
	int threeOfAKind;
	int fourOfAKind;
	int fullHouse;
	int smStraight;
	int lnStraight;
	int yahtzee;
	int chance;
	
	GamePlayer(int myNumber){
		this.myNumber = myNumber;
		System.out.printf("Player %d\n", (myNumber + 1));
		
		for(int r = 0; r < diceArray.length; r++) {
			diceArray[r] = new Dice();		//fills the dice array
		}
		
		//startTurn();

	}
	
	
	
	void startTurn() {
		System.out.println("Type 'r' to roll the dice.");
		if(input.nextLine().equals("r")) {
			rollAllDice();
		}else {
			startTurn();
		}
	}
	
	void rollAllDice() {
		rerollTries = 0;
		for(int r = 0; r < diceArray.length; r++) {
			diceArray[r].Roll();
		}
		showDiceRolls();
	}
	
	void showDiceRolls() {
		System.out.println("You rolled: ");
		for(int r = 0; r < diceArray.length; r++) {
			System.out.println("Dice "+ (r + 1) + ": " + diceArray[r].getValue());
		}
		if(rerollTries < 2) {
			selectDice();
		}else {
			checkForScore();
		}
	}
	
	void selectDice(){
		System.out.println("Type the numbers (1-5) of the dice you want to reroll.");
		System.out.println("If none type '0'");
		String rerollThese = input.nextLine();
		if(rerollThese.equals("0")) {
			checkForScore();
		}else if((rerollThese.contains("1")) || (rerollThese.contains("2")) || (rerollThese.contains("3")) || (rerollThese.contains("4")) || (rerollThese.contains("5"))){
			rerollTries++;
			if(rerollThese.contains("1")){
				System.out.println("I want to reroll the first die");
				diceArray[0].Roll();
			}
			if(rerollThese.contains("2")){
				System.out.println("I want to reroll the second die");
				diceArray[1].Roll();
			}
			if(rerollThese.contains("3")){
				System.out.println("I want to reroll the third die");
				diceArray[2].Roll();
			}
			if(rerollThese.contains("4")){
				System.out.println("I want to reroll the fourth die");
				diceArray[3].Roll();
			}
			if(rerollThese.contains("5")){
				System.out.println("I want to reroll the fifth die");
				diceArray[4].Roll();
			}
			
			showDiceRolls();
			
		}else {
			rerollTries--;
			System.out.println("Please type the correct numbers");
			showDiceRolls();
		}
			
	}
		
	void checkForScore() {
		System.out.println("");
		System.out.println("You have these options to score: ");
		System.out.println("1.  Aces");
		System.out.println("2.  Twos");
		System.out.println("3.  Threes");
		System.out.println("4.  Fours");
		System.out.println("5.  Fives");
		System.out.println("6.  Sixes");
		System.out.println("");
		System.out.println("7.  3 of a kind");
		System.out.println("8.  4 of a kind");
		System.out.println("9.  Full House");
		System.out.println("10. Sm. Straight");
		System.out.println("11. Ln. Straight");
		System.out.println("12. YAHTZEE");
		System.out.println("13. Chance");
		System.out.println("");
		/*
		 * 1.  Aces
		 * 2.  Twos
		 * 3.  Threes
		 * 4.  Fours
		 * 5.  Fives
		 * 6.  Sixes
		 * 
		 * 7.  3 of a kind
		 * 8.  4 of a kind
		 * 9.  Full House
		 * 10. Sm. Straight
		 * 11. Ln. Straight
		 * 12. YAHTZEE
		 * 13. Chance
		 */

		System.out.println("Type the number (1 - 13) of the option you want to score.");

		switch (input.nextLine()) {
    		case "1":
    			if(true/*scored ones*/) {
        			System.out.println("Score the aces");
        			setPlayerScores(1, countUpAllDice()); 

    			}else {
    				System.out.println("You dont have any ones, do you want to score 0 instead? (Y/N)");
        			switch (input.nextLine()) {
		        		case "Y":
		        			setPlayerScores(1, 0); 	//Score 0
		        			break;
		        		case "y":
		        			setPlayerScores(1, 0);	//Score 0
		        			break;
		        		case "n":
		        			showDiceRolls();            	//Restart Scoring
		        			break;
		        		case "N":
		        			showDiceRolls();            	//Restart Scoring
		        			break;
        				}
    				}
    			break;
    		case "2":
    			System.out.println("Score the twos");
    			setPlayerScores(2, countUpAllDice()); 
    			break;
    		case "3":
    			System.out.println("Score the threes");
    			setPlayerScores(3, countUpAllDice()); 
    			break;
    		case "4":
    			System.out.println("Score the fours");
    			setPlayerScores(4, countUpAllDice()); 
    			break;
    		case "5":
    			System.out.println("Score the fives");
    			setPlayerScores(5, countUpAllDice()); 
    			break;
    		case "6":
    			System.out.println("Score the sixes");
    			setPlayerScores(6, countUpAllDice()); 
    			break;
    			
    		case "7":
    			System.out.println("Score the 3 of a kind");
    			setPlayerScores(7, countUpAllDice()); 
    			break;
    		case "8":
    			System.out.println("Score the 4 of a kind");
    			setPlayerScores(8, countUpAllDice()); 
    			break;
    		case "9":
    			System.out.println("Score the Full House");
    			break;
    		case "10":
    			System.out.println("Score the Sm. Straight");
    			break;
    		case "11":
    			System.out.println("Score the Ln. Straight");
    			break;
    		case "12":
    			if(false/*scored yahtzee*/) {
        			System.out.println("Score the YAHTZEE");
        			setPlayerScores(12, true);

    			}else {
    				System.out.println("You dont have YAHTZEE, do you want to score 0 instead? (Y/N)");
        			switch (input.nextLine()) {
		        		case "Y":
		        			setPlayerScores(12, false); 	//Score 0
		        			break;
		        		case "y":
		        			setPlayerScores(12, false); 	//Score 0
		        			break;
		        		case "n":
		        			showDiceRolls();            	//Restart Scoring
		        			break;
		        		case "N":
		        			showDiceRolls();            	//Restart Scoring
		        			break;
        				}
    				}
    			break;
    			
    		case "13":
    			System.out.println("Score the Chance");
    			setPlayerScores(13, countUpAllDice()); 
    			break;
    		default: //invalid input
	    		System.out.println("Please enter a valid input");
	    		checkForScore();
            	break;
		}
	}
	
	void selectScore() {
		System.out.println("");
		System.out.println("Select where you would like your scores to be entered");
	}
	
	private int countUpAllDice() {
		int myScore = 0;

		for(int r = 0; r < diceArray.length; r++) {
			myScore += diceArray[r].getValue();
		}
		return myScore;
	}
	
	void playTurn() {
		System.out.println("Turn has started");
		
	}
	
	
	
	private void setPlayerScores(int scoreNr, int scoreTotal) {
		switch (scoreNr) {
		case 1:
			aces = scoreTotal;
			break;
		case 2:
			twos = scoreTotal;
			break;
		case 3:
			threes = scoreTotal;
			break;
		case 4:
			fours = scoreTotal;
			break;
		case 5:
			fives = scoreTotal;
			break;
		case 6:
			sixes = scoreTotal;
			break;
			
		case 7:
			threeOfAKind = scoreTotal;
			break;
		case 8:
			fourOfAKind = scoreTotal;
			break;
		
		case 13:
			chance = scoreTotal;
			break;
		}	
	}
	private void setPlayerScores(int scoreNr, boolean score) {
		switch(scoreNr) {
		case 9:
			if(score == true) {
				fullHouse = 25;
			}else {
				fullHouse = 0;
			}
			break;
		case 10:
			if(score == true) {
				smStraight = 30;
			}else {
				smStraight = 0;
			}
			break;
		case 11:
			if(score == true) {
				lnStraight = 40;
			}else {
				lnStraight = 0;
			}
			break;
		case 12:
			if(score == true) {
				yahtzee = 50;
			}else {
				yahtzee = 0;
			}
			break;
		}
	}
	
	int getPlayerScores(int scoreType) {
		switch (scoreType) {
			case 1:
				return aces;
			case 2:
				return twos;
			case 3:
				return threes;
			case 4:
				return fours;
			case 5:
				return fives;
			case 6:
				return sixes;
				
			case 7:
				return threeOfAKind;
			case 8:
				return fourOfAKind;
			case 9:
				return fullHouse;
			case 10:
				return smStraight;
			case 11:
				return lnStraight;
			case 12:
				return yahtzee;
			case 13:
				return chance;
		}
		return 0;
	}
}
