package com.thepinkdev.deck_of_cards.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuitsTests {

    @Test
    public void itShouldOnlyBeFourSuitsTest() {
    	int numberOfSuits = Suit.getAListOfAllDefaultSuits().size();
        assertEquals(4, numberOfSuits);
    }
    
    @Test
    public void itShouldBeHeartsTheFirstValueOfTheListTest() {
    	Suit firstSuitOfTheList = Suit.getAListOfAllDefaultSuits().get(0);
    	assertEquals(Suit.HEARTS, firstSuitOfTheList);
    }
	
    @Test
    public void itShouldBeKnownTheNameOfASuitTest() {
    	String heartName = Suit.HEARTS.getSuitName();
    	assertEquals("hearts", heartName);
    }
}
