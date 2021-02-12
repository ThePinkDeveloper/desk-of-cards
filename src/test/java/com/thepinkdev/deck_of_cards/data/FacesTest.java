package com.thepinkdev.deck_of_cards.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FacesTest {

    @Test
    public void itShouldOnlyBeThirteenFacesTest() {
    	int numberOfFaces = PokerFace.getAListOfAllPokerFaces().size();
        assertEquals(13, numberOfFaces);
    }
    
    @Test
    public void itShouldBeAceTheFirstValueOfTheListTest() {
    	PokerFace firstFaceOfTheList = PokerFace.getAListOfAllPokerFaces().get(0);
    	assertEquals(PokerFace.ACE, firstFaceOfTheList);
    }
	
    @Test
    public void itShouldBeKnownTheNameOfAFaceTest() {
    	String nameOfTwo = PokerFace.TWO.getFaceName();
    	assertEquals("2", nameOfTwo);
    }
}
