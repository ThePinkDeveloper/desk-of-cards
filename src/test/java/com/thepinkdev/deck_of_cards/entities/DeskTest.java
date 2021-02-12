package com.thepinkdev.deck_of_cards.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class DeskTest {

    @Test
    public void itShouldBeEmptyAnEmptyCreatedDeskTest() {
		Desk desk = Desk.createAnEmptyDesk();
		assertTrue(desk.isEmpty());
    }
    
    @Test
    public void itShouldHave52CardsAPokerStyleDeskTest() {
		final int numberOfCardOnAPokerStyleDesk = 52;
    	Desk desk = Desk.createAPokerStyleDesk();
		assertEquals(numberOfCardOnAPokerStyleDesk, desk.size());
    }
    
    @Test
    public void aPokerStyleDeskShouldOnlyHaveOneSingleCardCopyForFaceAndClubTest() {
    	Desk desk = Desk.createAPokerStyleDesk();
    	desk.forEach( card -> {
    		List<Card> copiesOfACardInTheDesk = 
    				desk.stream().filter( c -> c.equals(card)).collect(Collectors.toList());
    		assertTrue(1 == copiesOfACardInTheDesk.size());
    	});
    }
	
}
