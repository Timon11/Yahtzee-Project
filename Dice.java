package game;

import java.util.Random;

public class Dice {
	Dice(){
		Roll();
	}
	private int myValue;
	Random randomNr = new Random();
	
	int Roll() {
		int randomNum = randomNr.nextInt(6);
//		System.out.println(randomNum +1);
		myValue = randomNum +1;
		return myValue;
	}
	
	int getValue() {
		return myValue;
	}
}
