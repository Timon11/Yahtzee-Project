package game;

public class Board {
	Board(){
		this(1);
	}
	Board(int playerNr){
//		System.out.println("Number of players on this board = " + playerNr);
		drawBoard(playerNr);
	}
	
	String filler = "  ";
	
	void drawBoard(int playerNr) {

		System.out.printf("+-------------------------------");
		drawToPlayerNr((playerNr-1), "---------");
		System.out.println("--------+");
		
		System.out.printf("| YAHTZEE - SCORES              ");
		drawToPlayerNr((playerNr -1), "         ");
		System.out.println("        |");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(playerNr, "--------+");
		System.out.println("");
		
		
		System.out.printf("| UPPER SECTION | HOW          |");
		drawToPlayerNr(playerNr, " PLAYER |");
		System.out.println("");
		
		System.out.printf("|               | TO SCORE     |");//Draw: ONE    | TWO    | THREE  |\n");
		
		for(int i = 0; i < playerNr; i++) {
			switch (i) {
	    		case 0:	//start game
	    			System.out.print(" ONE    |");
	    			break;
	    		case 1:	//start game
	    			System.out.print(" TWO    |");
	    			break;
	    		case 2:	//start game
	    			System.out.print(" THREE  |");
	    			break;
	    		case 3:	//start game
	    			System.out.print(" FOUR   |");
	    			break;
			}
		}
		System.out.println("");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(playerNr, "--------+");
		System.out.println("");

		System.out.printf("| ACES          | COUNT ACES   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| TWOS          | COUNT TWOS   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| THREES        | COUNT THREES |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| FOURS         | COUNT FOURS  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| FIVES         | COUNT FIVES  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| SIXES         | COUNT SIXES  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(playerNr, "--------+");
		System.out.println("");
		
		System.out.printf("| TOTAL SCORE   | -----------> |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
						
		System.out.printf("| BONUS: (63+)  | SCORE 35     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| TOTAL UPPER   | -----------> |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(playerNr, "--------+");
		System.out.println("");
		
		System.out.printf("| LOWER SECTION                 ");
		drawToPlayerNr((playerNr -1), "         ");
		System.out.println("        |");
		
		System.out.printf("|                               ");
		drawToPlayerNr((playerNr -1), "         ");
		System.out.println("        |");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(playerNr, "--------+");
		System.out.println("");
		
		System.out.printf("| 3 OF A KIND   | TOTAL DICE   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| 4 OF A KIND   | TOTAL DICE   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| FULL HOUSE    | SCORE 25     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| SM. STRAIGHT  | SCORE 30     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| LG. STRAIGHT  | SCORE 40     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| YAHTZEE       | SCORE 50     |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("| CHANCE        | TOTAL DICE   |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(playerNr, "--------+");
		System.out.println("");
		
		System.out.printf("|    YAHTZEE    | UPPER SCORE  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("|     BONUS     | LOWER SCORE  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("|               | TOTAL SCORE  |");//   %s   |   %s   |   %s   |\n", filler, filler, filler);
		drawToPlayerNr(playerNr, "   %s   |", filler);
		System.out.printf("\n");
		
		System.out.printf("+---------------+--------------+");  
		drawToPlayerNr(playerNr, "--------+");
		System.out.println("");
		/*
		System.out.println("");
		System.out.println("");

		
		System.out.printf("+---------------------------------------------------------+\n");
		System.out.printf("| YAHTZEE - SCORES                                        |\n");
		System.out.printf("+---------------+-----------------------------------------+\n");
		System.out.printf("| UPPER SECTION | HOW          | PLAYER | PLAYER | PLAYER |\n");
		System.out.printf("|               | TO SCORE     | ONE    | TWO    | THREE  |\n");
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("| ACES          | COUNT ACES   |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| TWOS          | COUNT TWOS   |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| THREES        | COUNT THREES |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| FOURS         | COUNT FOURS  |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| FIVES         | COUNT FIVES  |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| SIXES         | COUNT SIXES  |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("| TOTAL SCORE   | -----------> |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| BONUS: (63+)  | SCORE 35     |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| TOTAL UPPER   | -----------> |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("| LOWER SECTION                                           |\n");
		System.out.printf("|                                                         |\n");
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("| 3 OF A KIND   | TOTAL DICE   |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| 4 OF A KIND   | TOTAL DICE   |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| FULL HOUSE    | SCORE 25     |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| SM. STRAIGHT  | SCORE 30     |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| LG. STRAIGHT  | SCORE 40     |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| YAHTZEE       | SCORE 50     |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("| CHANCE        | TOTAL DICE   |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("|    YAHTZEE    | UPPER SCORE  |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("|     BONUS     | LOWER SCORE  |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("|               | TOTAL SCORE  |   %s   |   %s   |   %s   |\n", filler, filler, filler);
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		*/
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
