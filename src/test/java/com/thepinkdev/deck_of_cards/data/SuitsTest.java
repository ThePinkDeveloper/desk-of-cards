package com.thepinkdev.deck_of_cards.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuitsTest {

    @Test
    public void itShouldOnlyBeFourSuitsTest() {
    	int numberOfSuits = PokerSuit.getAListOfAllPokerSuits().size();
        assertEquals(4, numberOfSuits);
    }
    
    @Test
    public void itShouldBeHeartsTheFirstValueOfTheListTest() {
    	PokerSuit firstSuitOfTheList = PokerSuit.getAListOfAllPokerSuits().get(0);
    	assertEquals(PokerSuit.HEARTS, firstSuitOfTheList);
    }
	
    @Test
    public void itShouldBeKnownTheNameOfASuitTest() {
    	String heartName = PokerSuit.HEARTS.getSuitName();
    	assertEquals("hearts", heartName);
    }
}
