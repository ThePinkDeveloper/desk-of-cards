package com.thepinkdev.deck_of_cards.utils;

import java.util.Random;

import com.thepinkdev.deck_of_cards.exceptions.ZeroOrNegativeNumberException;

public class Generators {
	
	private Generators() {}
	
	/**
	 * A MAIN METHOD. It retrieves a random number between one and a given number.
	 * It controls that the number given don't be negative or zero.
	 * WARNING low randomness. It is recommended to apply this method multiples times to
	 * improve randomness.  
	 * @param positiveNumber
	 * @return
	 * @throws ZeroOrNegativeNumberException
	 */
	public static Integer randomNumberBetweenOneAndAnotherPositiveNumber (int positiveNumber)
			throws ZeroOrNegativeNumberException {
		
		if (positiveNumber <= 0) {
			throw new ZeroOrNegativeNumberException();
		}
		
		Random seed = new Random(System.nanoTime());
		return seed.nextInt(positiveNumber) + 1;
	}

}
