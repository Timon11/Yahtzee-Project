package game;

import java.util.Scanner;

public class GamePlayer {
	int myNumber;
	Scanner input = new Scanner(System.in);
	Dice[] diceArray = new Dice[5];		//creates an array of 5 dice
	private int rerollTries;
	
	private boolean finishedRolling;
	
	private int aces;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	
	private int threeOfAKind;
	private int fourOfAKind;
	private int fullHouse;
	private int smStraight;
	private int lnStraight;
	private int yahtzee;
	private int chance;
	
	private boolean scoredAces = false;
	private boolean scoredTwos = false;
	private boolean scoredThrees = false;
	private boolean scoredFours = false;
	private boolean scoredFives = false;
	private boolean scoredSixes = false;
	
	private boolean scoredThreeOfAKind = false;
	private boolean scoredFourOfAKind = false;
	private boolean scoredFullHouse = false;
	private boolean scoredSmStraight = false;
	private boolean scoredLnStraight = false;
	private boolean scoredYahtzee = false;
	private boolean scoredChance = false;
	
	GamePlayer(int myNumber){
		this.myNumber = myNumber;
		System.out.printf("Player %d\n", (myNumber + 1));
		
		for(int r = 0; r < diceArray.length; r++) {
			diceArray[r] = new Dice();		//fills the dice array
		}
		
		//startTurn();

	}
	
	
	
	void startTurn() {
		finishedRolling = false;
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
		if(rerollTries < 2 && finishedRolling == false) {
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
			finishedRolling = true;
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
    			if(scoredAces == false) {
        			scoreNumbers(1, "aces");
    			}else {
    				cantScoreAgain("aces");
    			}
    			break;
    		case "2":
    			if(scoredTwos == false) {
        			scoreNumbers(2, "twos");
    			}else {
    				cantScoreAgain("twos");
    			}
    			break;
    		case "3":
    			if(scoredThrees == false) {
        			scoreNumbers(3, "threes");
    			}else {
    				cantScoreAgain("threes");
    			}
    			break;
    		case "4":
    			if(scoredFours == false) {
        			scoreNumbers(4, "fours");
    			}else {
    				cantScoreAgain("fours");
    			}
    			break;
    		case "5":
    			if(scoredFives == false) {
        			scoreNumbers(5, "fives");
    			}else {
    				cantScoreAgain("fives");
    			}
    			break;
    		case "6":
    			if(scoredSixes == false) {
        			scoreNumbers(6, "sixes");
    			}else {
    				cantScoreAgain("sixes");
    			}
    			break;
    			
    		case "7": //Three of a kind
    			System.out.println("Score the 3 of a kind");
    			if(scoredThreeOfAKind == false) {
    				//TODO: Check if 3 are the same
        			int aces = 0;
        			int twos = 0;
        			int threes = 0;
        			int fours = 0;
        			int fives = 0;
        			int sixes = 0;
        			
        			for(int r = 0; r < diceArray.length; r++) {
        				switch (diceArray[r].getValue()) {
    	    	    		case 1:
    	    	    			aces ++;
    	    	    			break;
    	    	    		case 2:
    	    	    			twos ++;
    	    	    			break;
    	    	    		case 3:
    	    	    			threes ++;
    	    	    			break;
    	    	    		case 4:
    	    	    			fours ++;
    	    	    			break;
    	    	    		case 5:
    	    	    			fives ++;
    	    	    			break;
    	    	    		case 6:
    	    	    			sixes ++;
    	    	    			break;
        				}
        				//myScore += diceArray[r].getValue();
        			}
        			if (aces > 2 || twos > 2 || threes > 2 || fours > 2 || fives > 2 || sixes > 2) {
        				int myScore = 0;
            			for(int i = 0; i < diceArray.length; i++) {
            				myScore += diceArray[i].getValue();
            			}
            			setPlayerScores(7, myScore); 
        			}else {
        				dontHaveTarget(7, "three of a kind"); 
        			}
    			}else {
    				cantScoreAgain("three of a kind");
    			}
    			break;
    		case "8": //Four of a kind
    			System.out.println("Score the 4 of a kind");
    			if(scoredFourOfAKind == false) {
    				//Check if 4 are the same
        			int aces = 0;
        			int twos = 0;
        			int threes = 0;
        			int fours = 0;
        			int fives = 0;
        			int sixes = 0;
        			
        			for(int r = 0; r < diceArray.length; r++) {
        				switch (diceArray[r].getValue()) {
    	    	    		case 1:
    	    	    			aces ++;
    	    	    			break;
    	    	    		case 2:
    	    	    			twos ++;
    	    	    			break;
    	    	    		case 3:
    	    	    			threes ++;
    	    	    			break;
    	    	    		case 4:
    	    	    			fours ++;
    	    	    			break;
    	    	    		case 5:
    	    	    			fives ++;
    	    	    			break;
    	    	    		case 6:
    	    	    			sixes ++;
    	    	    			break;
        				}
        			}
        			if (aces > 3 || twos > 3 || threes > 3 || fours > 3 || fives > 3 || sixes > 3) {
        				int myScore = 0;
            			for(int i = 0; i < diceArray.length; i++) {
            				myScore += diceArray[i].getValue();
            			}
            			setPlayerScores(8, myScore); 
        			}else {
        				dontHaveTarget(8, "four of a kind"); 
        			}
    			}else {
    				cantScoreAgain("four of a kind");
    			}
    			break;
    		case "9": //FullHouse
    			System.out.println("Score the Full House");
    			break;
    		case "10": //Sm.Straight
    			System.out.println("Score the Sm. Straight");
    			if(scoredSmStraight == false) {
    				if(true) {//TODO: if small straight has been scored
    					setPlayerScores(10, true);
    				}else {
    					dontHaveTarget(10, "small straight"); 
    				}
    			}else {
    				cantScoreAgain("small straight");
    			}
    			break;
    		case "11": //Ln.Straight
    			System.out.println("Score the Ln. Straight");
    			break;
    		case "12": //Yahtzee
    			System.out.println("Score the YAHTZEE");
    			if(scoredYahtzee == false) {
    				//Check if 4 are the same
        			int aces = 0;
        			int twos = 0;
        			int threes = 0;
        			int fours = 0;
        			int fives = 0;
        			int sixes = 0;
        			
        			for(int r = 0; r < diceArray.length; r++) {
        				switch (diceArray[r].getValue()) {
    	    	    		case 1:
    	    	    			aces ++;
    	    	    			break;
    	    	    		case 2:
    	    	    			twos ++;
    	    	    			break;
    	    	    		case 3:
    	    	    			threes ++;
    	    	    			break;
    	    	    		case 4:
    	    	    			fours ++;
    	    	    			break;
    	    	    		case 5:
    	    	    			fives ++;
    	    	    			break;
    	    	    		case 6:
    	    	    			sixes ++;
    	    	    			break;
        				}
        			}
        			if (aces == 5 || twos == 5 || threes == 5 || fours == 5 || fives == 5 || sixes == 5) {
        				setPlayerScores(12, true); 
        			}else {
        				dontHaveTarget(12, "YAHTZEE");        				
        			}
    			}else {
    				cantScoreAgain("YAHTZEE");
    			}
    			break;
			
    		case "13": //Chance
    			System.out.println("Score the Chance");
    			if(scoredChance == false) {
    				int myScore = 0;
        			for(int r = 0; r < diceArray.length; r++) {
        				myScore += diceArray[r].getValue();
        			}
        			setPlayerScores(13, myScore); 
    			}else {
    				cantScoreAgain("chance");
    			}
    			break;
    			
    		default: //invalid input
	    		System.out.println("Please enter a valid input");
	    		checkForScore();
            	break;
		}
	}
		
	void dontHaveTarget(int target, String targetName) {
		
		System.out.println("You dont have "+ targetName + ", do you want to score 0 instead? (Y/N)");
		switch (input.nextLine()) {
    		case "Y":
    			if(target == 9 || target == 10 || target == 11 || target == 12) {
    				setPlayerScores(target, false);
    			}else {
        			setPlayerScores(target, 0); 	//Score 0
    			}
    			break;
    		case "y":
    			if(target == 9 || target == 10 || target == 11 || target == 12) {
    				setPlayerScores(target, false);
    			}else {
        			setPlayerScores(target, 0); 	//Score 0
    			}    			
    			break;
    		case "n":
    			showDiceRolls();        		//Restart Scoring
    			break;
    		case "N":
    			showDiceRolls();        		//Restart Scoring
    			break;
		}
	}
	
	void cantScoreAgain(String scoreName) {
		System.out.println("You have already scored " + scoreName + ", you can't do it again.");
		showDiceRolls(); 
	}
	
	boolean arrayContains(int target) {
		if(		diceArray[0].getValue() == target || 
				diceArray[1].getValue() == target || 
				diceArray[2].getValue() == target || 
				diceArray[3].getValue() == target || 
				diceArray[4].getValue() == target) {
			return true;
		}else {
			return false;
		}
	}
	
	void scoreNumbers(int target, String numberName) {
		int myScore = 0;

		if(arrayContains(target)) {
			
			for(int r = 0; r < diceArray.length; r++) {
				if(diceArray[r].getValue() == target) {
    				myScore += diceArray[r].getValue();
				}
			}
			setPlayerScores(target, myScore); 
			System.out.println("You score the " + numberName + " for " + myScore + " points.");

		}else {
			System.out.println("You dont have any "+ numberName + ", do you want to score 0 instead? (Y/N)");
			switch (input.nextLine()) {
        		case "Y":
        			setPlayerScores(target, 0); 	//Score 0
        			break;
        		case "y":
        			setPlayerScores(target, 0);		//Score 0
        			break;
        		case "n":
        			showDiceRolls();        		//Restart Scoring
        			break;
        		case "N":
        			showDiceRolls();        		//Restart Scoring
        			break;
			}
		}
	}
	
	void selectScore() {
		System.out.println("");
		System.out.println("Select where you would like your scores to be entered");
	}
	
	void playTurn() {
		System.out.println("Turn has started");
		
	}
	
	
	
	private void setPlayerScores(int scoreNr, int scoreTotal) {
		switch (scoreNr) {
		case 1:
			aces = scoreTotal;
			scoredAces = true;
			break;
		case 2:
			twos = scoreTotal;
			scoredTwos = true;
			break;
		case 3:
			threes = scoreTotal;
			scoredThrees = true;
			break;
		case 4:
			fours = scoreTotal;
			scoredFours = true;
			break;
		case 5:
			fives = scoreTotal;
			scoredFives = true;
			break;
		case 6:
			sixes = scoreTotal;
			scoredSixes = true;
			break;
			
		case 7:
			threeOfAKind = scoreTotal;
			scoredThreeOfAKind = true;
			break;
		case 8:
			fourOfAKind = scoreTotal;
			scoredFourOfAKind = true;
			break;
		
		case 13:
			chance = scoreTotal;
			scoredChance = true;
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
			scoredFullHouse = true;
			break;
		case 10:
			if(score == true) {
				smStraight = 30;
			}else {
				smStraight = 0;
			}
			scoredSmStraight = true;
			break;
		case 11:
			if(score == true) {
				lnStraight = 40;
			}else {
				lnStraight = 0;
			}
			scoredLnStraight = true;
			break;
		case 12:
			if(score == true) {
				yahtzee = 50;
			}else {
				yahtzee = 0;
			}
			scoredYahtzee = true;
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
