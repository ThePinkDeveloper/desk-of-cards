package com.thepinkdev.deck_of_cards.utils;

import java.util.Random;

import com.thepinkdev.deck_of_cards.exceptions.NegativeNumberException;
import com.thepinkdev.deck_of_cards.exceptions.ZeroNumberException;

public class Generators {
	
	private Generators() {}
	
	public static Integer randomNumberBetweenOneAndAnotherPositiveNumber (Integer positiveNumber)
			throws NegativeNumberException, ZeroNumberException {
		
		if (positiveNumber < 0) {
			throw new NegativeNumberException();
		} else if (positiveNumber == 0) {
			throw new ZeroNumberException();
		}
		
		Random seed = new Random(System.currentTimeMillis());
		return seed.nextInt(positiveNumber) + 1;
	}

}
