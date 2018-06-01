package game;

import java.util.Scanner;

public class MenuScreen {
	MenuScreen(){
		drawMenu();
	}
	
	boolean validInput = true;
	boolean maxPlayerCap = false;
	boolean minPlayerCap = false;
		
	int minPlayers = 1;
	int maxPlayers = 4;
	
	int playerNr = minPlayers;
	

	void drawMenu() {	//Draws the menu
		Scanner input = new Scanner(System.in);

		System.out.printf("+---------------------------------------------------------+\n");
		System.out.printf("+                    Welcome to YahtZee!                  +\n");
		System.out.printf("+---------------------------------------------------------+\n");
		
		//This runs if the previous entry was invalid
		if(!validInput){
			System.out.printf("+                                                         +\n");
			System.out.printf("+              PLEASE ENTER A VALID INPUT!                +\n");
		}
		//This runs if the player tries to increase the player number after the max cap was reached
		if(maxPlayerCap){
			System.out.printf("+                                                         +\n");
			System.out.printf("+              MAXIMUM NR OF PLAYERS IS %d!               +\n", maxPlayers);
		}
		//This runs if the player tries to decrease the player number after the min cap was reached
		if(minPlayerCap){
			System.out.printf("+                                                         +\n");
			System.out.printf("+              MINIMUM NR OF PLAYERS IS %d!               +\n", minPlayers);
		}
		
		System.out.printf("+                                                         +\n");
		System.out.printf("+                    To start: press 's'                  +\n");
		System.out.printf("+                  (Number of Players: %d)                +\n", playerNr);
		System.out.printf("+                                                         +\n");
		System.out.printf("+    To increase number of players: press '+' (Max. %d)   +\n", maxPlayers);
		System.out.printf("+    To decrease number of players: press '-' (Min. %d)   +\n", minPlayers);
		System.out.printf("+                                                         +\n");
		System.out.printf("+                    To Quit: Press 'q'                   +\n");
		System.out.printf("+                                                         +\n");
		System.out.printf("+---------------------------------------------------------+\n");
		
		resetBooleans();
		
	    switch (input.nextLine()) {
	    	case "s":	//start game
	    		startGame();
	    		break;
	    		
	    	case "S":	//start game
	    		startGame();
	    		break;
	    		
	    	case "q":	//quit game
	    		quitGame();
	    		break;
	    		
	    	case "Q":	//quit game
	    		quitGame();
	    		break;
	    		
	    	case"+":	//increase number of players
	    		increasePlayerNr();
	    		break;
	    		
	    	case"-":	//decrease number of players
	    		decreasePlayerNr();
	    		break;
	    		
	    	default: //invalid input
	    		invalidInput();
            	break;
	    }
	}
	
	void startGame() {
		System.out.println("We Start");
	}
	
	void increasePlayerNr() {
		if(playerNr < maxPlayers) {
			playerNr++;
			drawMenu();
		}else {
			maxPlayerCap = true;
			drawMenu();
		}
	}
	
	void decreasePlayerNr() {
		if(playerNr > minPlayers) {
			playerNr--;
			drawMenu();
		}else {
			minPlayerCap = true;
			drawMenu();
		}
	}
		
	void quitGame() {
		System.out.println("We Quit");
	}
		
	void invalidInput() {
		validInput = false;
		drawMenu();
	}
	
	void resetBooleans() {	//resets the booleans to their defauld values
		maxPlayerCap = false;
		minPlayerCap = false;
		validInput = true;
	}
}
