package game;

public class Board {
	Board(){
		this(1);
	}
	Board(int playerNr){
		drawBoard(playerNr);
	}
	
	void drawBoard(int playerNr) {
		System.out.printf("+---------------------------------------------------------+\n");
		System.out.printf("|                     YAHTZEE - SCORES                    |\n");
		System.out.printf("+---------------+-----------------------------------------+\n");
		System.out.printf("| UPPER SECTION | HOW          | PLAYER | PLAYER | PLAYER |\n");
		System.out.printf("|               | TO SCORE     | ONE    | TWO    | THREE  |\n");
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("| ACES          | COUNT ACES   |   %d   |   %d   |   %d   |\n");
		System.out.printf("| TWOS          | COUNT TWOS   |   %d   |   %d   |   %d   |\n");
		System.out.printf("| THREES        | COUNT THREES |   %d   |   %d   |   %d   |\n");
		System.out.printf("| FOURS         | COUNT FOURS  |   %d   |   %d   |   %d   |\n");
		System.out.printf("| FIVES         | COUNT FIVES  |   %d   |   %d   |   %d   |\n");
		System.out.printf("| SIXES         | COUNT SIXES  |   %d   |   %d   |   %d   |\n");
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("| TOTAL SCORE   | -----------> |   %d   |   %d   |   %d   |\n");
		System.out.printf("| BONUS: (63+)  | SCORE 35     |   %d   |   %d   |   %d   |\n");
		System.out.printf("| TOTAL UPPER   | -----------> |   %d   |   %d   |   %d   |\n");
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("| LOWER SECTION                                           |\n");
		System.out.printf("|                                                         |\n");
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("| 3 OF A KIND   | TOTAL DICE   |   %d   |   %d   |   %d   |\n");
		System.out.printf("| 4 OF A KIND   | TOTAL DICE   |   %d   |   %d   |   %d   |\n");
		System.out.printf("| FULL HOUSE    | SCORE 25     |   %d   |   %d   |   %d   |\n");
		System.out.printf("| SM. STRAIGHT  | SCORE 30     |   %d   |   %d   |   %d   |\n");
		System.out.printf("| LG. STRAIGHT  | SCORE 40     |   %d   |   %d   |   %d   |\n");
		System.out.printf("| YAHTZEE       | SCORE 50     |   %d   |   %d   |   %d   |\n");
		System.out.printf("| CHANCE        | TOTAL DICE   |   %d   |   %d   |   %d   |\n");
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
		System.out.printf("|    YAHTZEE    | UPPER SCORE  |   %d   |   %d   |   %d   |\n");
		System.out.printf("|     BONUS     | LOWER SCORE  |   %d   |   %d   |   %d   |\n");
		System.out.printf("|               | TOTAL SCORE  |   %d   |   %d   |   %d   |\n");
		System.out.printf("+---------------+--------------+--------+--------+--------+\n");
	}
}
