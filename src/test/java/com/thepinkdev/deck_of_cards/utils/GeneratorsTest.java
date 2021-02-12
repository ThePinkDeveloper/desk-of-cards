package com.thepinkdev.deck_of_cards.utils;

import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import org.junit.Test;

import com.thepinkdev.deck_of_cards.exceptions.ZeroOrNegativeNumberException;

public class GeneratorsTest {
	
	@Test(expected = ZeroOrNegativeNumberException.class)
    public void itShouldBeExpectedAnExceptionWhenGivenNumberIsLessThanZeroTest() throws ZeroOrNegativeNumberException {
    	Generators.randomNumberBetweenOneAndAnotherPositiveNumber(-1);
    }
	
	@Test(expected = ZeroOrNegativeNumberException.class)
    public void itShouldBeExpectedAnExceptionWhenGivenNumberIsEqualsZeroTest() throws ZeroOrNegativeNumberException {
    	Generators.randomNumberBetweenOneAndAnotherPositiveNumber(0);
    }
	
	@Test
	public void itShouldAlwaysGetARandomNumberBetweenOneAndAGivenNumber() {
		
		int givenNumber = 10;
		IntStream.rangeClosed(1, 100).forEach( i -> {
			int result;
			try {
				result = Generators.randomNumberBetweenOneAndAnotherPositiveNumber(givenNumber);
				assertTrue(result >= 1 && result <= 10);
			} catch (ZeroOrNegativeNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

}