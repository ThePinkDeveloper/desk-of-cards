package com.thepinkdev.deck_of_cards.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FacesTests {

    @Test
    public void itShouldOnlyBeThirteenFacesTest() {
    	int numberOfFaces = Face.getAListOfAllDefaultFaces().size();
        assertEquals(13, numberOfFaces);
    }
    
    @Test
    public void itShouldBeAceTheFirstValueOfTheListTest() {
    	Face firstFaceOfTheList = Face.getAListOfAllDefaultFaces().get(0);
    	assertEquals(Face.ACE, firstFaceOfTheList);
    }
	
    @Test
    public void itShouldBeKnownTheNameOfAFaceTest() {
    	String nameOfTwo = Face.TWO.getFaceName();
    	assertEquals("2", nameOfTwo);
    }
}
