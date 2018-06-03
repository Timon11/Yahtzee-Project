package game;

public class Board {
	private int nrOfPlayers;
	
	private int[] aces;
	private int[] twos;
	private int[] threes;
	private int[] fours;
	private int[] fives;
	private int[] sixes;
	
	private int[] scoreUpper;
	private int[] bonus;
	private int[] totalScoreUpper;
	
	private int[] threeOfAKind;
	private int[] fourOfAKind;
	private int[] fullHouse;
	private int[] smStraight;
	private int[] lnStraight;
	private int[] yahtzee;
	private int[] chance;
	
	private int[] totalScoreLower;
	private int[] totalScore;
	
	Board(){
		this(1);
	}
	Board(int playerNr){
		this.nrOfPlayers = playerNr;
		
		aces = new int[nrOfPlayers];
		twos = new int[nrOfPlayers];
		threes = new int[nrOfPlayers];
		fours = new int[nrOfPlayers];
		fives = new int[nrOfPlayers];
		sixes = new int[nrOfPlayers];

		scoreUpper = new int[nrOfPlayers];
		bonus = new int[nrOfPlayers];
		totalScoreUpper = new int[nrOfPlayers];
		
		threeOfAKind = new int[nrOfPlayers];
		fourOfAKind = new int[nrOfPlayers];
		fullHouse = new int[nrOfPlayers];
		smStraight = new int[nrOfPlayers];
		lnStraight = new int[nrOfPlayers];
		yahtzee = new int[nrOfPlayers];
		chance = new int[nrOfPlayers];
		
		totalScoreLower = new int[nrOfPlayers];
		totalScore = new int[nrOfPlayers];

		drawBoard();
	}

	String filler = "000";
	
	void enterScore(int playerNr, int scoreType, int scoreAmount) {
		switch (scoreType) {
		//Upper Half
		case 1:
			aces[playerNr] = scoreAmount;
			break;
		case 2:
			twos[playerNr] = scoreAmount;
			break;
		case 3:
			threes[playerNr] = scoreAmount;
			break;
		case 4:
			fours[playerNr] = scoreAmount;
			break;
		case 5:
			fives[playerNr] = scoreAmount;
			break;
		case 6:
			sixes[playerNr] = scoreAmount;
			break;
		
		//Lower Half
		case 7:
			threeOfAKind[playerNr] = scoreAmount;
			break;
		case 8:
			fourOfAKind[playerNr] = scoreAmount;
			break;
		case 9:
			fullHouse[playerNr] = scoreAmount;
			break;
		case 10:
			smStraight[playerNr] = scoreAmount;
			break;
		case 11:
			lnStraight[playerNr] = scoreAmount;
			break;
		case 12:
			yahtzee[playerNr] = scoreAmount;
			break;
		case 13:
			chance[playerNr] = scoreAmount;
			break;
		}
	}
	
	void drawBoard() {

		System.out.printf("+-------------------------------");
		drawToPlayerNr((nrOfPlayers-1), "----------");
		System.out.println("---------+");
		
		System.out.printf("| YAHTZEE - SCORES              ");
		drawToPlayerNr((nrOfPlayers -1), "          ");
		System.out.println("         |");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(nrOfPlayers, "---------+");
		System.out.println("");
		
		
		System.out.printf("| UPPER SECTION | HOW          |");
		drawToPlayerNr(nrOfPlayers, " PLAYER  |");
		System.out.println("");
		
		System.out.printf("|               | TO SCORE     |");
		
		for(int i = 0; i < nrOfPlayers; i++) {
			switch (i) {
	    		case 0:	//start game
	    			System.out.print(" ONE     |");
	    			break;
	    		case 1:	//start game
	    			System.out.print(" TWO     |");
	    			break;
	    		case 2:	//start game
	    			System.out.print(" THREE   |");
	    			break;
	    		case 3:	//start game
	    			System.out.print(" FOUR    |");
	    			break;
			}
		}
		System.out.println("");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(nrOfPlayers, "---------+");
		System.out.println("");

		System.out.printf("| ACES          | COUNT ACES   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(aces[i]));
		}
		System.out.printf("\n");
		
		System.out.printf("| TWOS          | COUNT TWOS   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(twos[i]));
		}
		System.out.printf("\n");
		
		System.out.printf("| THREES        | COUNT THREES |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(threes[i]));
		}
		System.out.printf("\n");
		
		System.out.printf("| FOURS         | COUNT FOURS  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(fours[i]));
		}		
		System.out.printf("\n");
		
		System.out.printf("| FIVES         | COUNT FIVES  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(fives[i]));
		}		
		System.out.printf("\n");
		
		System.out.printf("| SIXES         | COUNT SIXES  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(sixes[i]));
		}		
		System.out.printf("\n");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(nrOfPlayers, "---------+");
		System.out.println("");
		
		System.out.printf("| TOTAL SCORE   | -----------> |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(scoreUpper[i]));
		}		
		System.out.printf("\n");
						
		System.out.printf("| BONUS: (63+)  | SCORE 35     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(bonus[i]));
		}		
		System.out.printf("\n");
		
		System.out.printf("| TOTAL UPPER   | -----------> |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(totalScoreUpper[i]));
		}		
		System.out.printf("\n");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(nrOfPlayers, "---------+");
		System.out.println("");
		
		System.out.printf("| LOWER SECTION                 ");
		drawToPlayerNr((nrOfPlayers -1), "          ");
		System.out.println("         |");
		
		System.out.printf("|                               ");
		drawToPlayerNr((nrOfPlayers -1), "          ");
		System.out.println("         |");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(nrOfPlayers, "---------+");
		System.out.println("");
		
		System.out.printf("| 3 OF A KIND   | TOTAL DICE   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(threeOfAKind[i]));
		}		System.out.printf("\n");
		
		System.out.printf("| 4 OF A KIND   | TOTAL DICE   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(fourOfAKind[i]));
		}		System.out.printf("\n");
		
		System.out.printf("| FULL HOUSE    | SCORE 25     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(fullHouse[i]));
		}		System.out.printf("\n");
		
		System.out.printf("| SM. STRAIGHT  | SCORE 30     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(smStraight[i]));
		}		System.out.printf("\n");
		
		System.out.printf("| LG. STRAIGHT  | SCORE 40     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(lnStraight[i]));
		}		System.out.printf("\n");
		
		System.out.printf("| YAHTZEE       | SCORE 50     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(yahtzee[i]));
		}		System.out.printf("\n");
		
		System.out.printf("| CHANCE        | TOTAL DICE   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(chance[i]));
		}		System.out.printf("\n");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(nrOfPlayers, "---------+");
		System.out.println("");
		
		System.out.printf("|    YAHTZEE    | UPPER SCORE  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(totalScoreUpper[i]));
		}		System.out.printf("\n");
		
		System.out.printf("|     BONUS     | LOWER SCORE  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(totalScoreLower[i]));
		}		System.out.printf("\n");
		
		System.out.printf("|               | TOTAL SCORE  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		for(int i = 0; i < nrOfPlayers; i++) {
			System.out.printf("   %s   |", turnScoreToString(totalScore[i]));
		}		System.out.printf("\n");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(nrOfPlayers, "---------+");
		System.out.println("");
	}
	
	void drawToPlayerNr(int playerNr, String whatToDraw) {
		for(int i = 0; i < playerNr; i++) {
			
			System.out.print(whatToDraw);
			
		}
	}
	void drawToPlayerNr(int playerNr, String whatToDraw, String filler) {
		for(int i = 0; i < playerNr; i++) {
			System.out.printf(whatToDraw, filler);
			
		}
	}
	
	void calculateFinalScores() {
		for(int i = 0; i < nrOfPlayers; i++) {
//			scoreUpper
//			bonus
//			totalScoreUpper
//			totalScoreLower
//			totalScore
			scoreUpper[i] = (aces[i] + twos[i] + threes[i] + fours[i] + fives[i] + sixes[i]);
			if(scoreUpper[i] >= 63) {
				bonus[i] = 35;
			}else {
				bonus[i] = 0;
			}
			totalScoreUpper[i] = (scoreUpper[i] + bonus[i]);
			totalScoreLower[i] = (threeOfAKind[i] + fourOfAKind[i] + fullHouse[i] + smStraight[i] + lnStraight[i] + yahtzee[i] + chance[i]);	
			totalScore[i] = (totalScoreUpper[i] + totalScoreLower[i]);
		}
	}
	
	String turnScoreToString(int myScore) {
		String scoreString = ("" + myScore);
		if(scoreString.length() == 1) {
			return ("  " + myScore);
		}else if(scoreString.length() == 2){
			return (" " + myScore);
		}else if(scoreString.length() == 3) {
			return ("" + myScore);
		}else {
			return "XXX";
		}
	}
}
