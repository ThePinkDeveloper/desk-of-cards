package com.thepinkdev.deck_of_cards.entities;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.thepinkdev.deck_of_cards.data.PokerFace;
import com.thepinkdev.deck_of_cards.data.PokerSuit;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutFaceException;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutSuitException;

public class CardTest {

    @Test
    public void itShouldNotBeEqualsTwoCardsWithTheSameFaceAndSuitTest() {
		try {
			Card card1 = Card.createAPokerStyleCardByFaceAndSuit(PokerFace.ACE, PokerSuit.SPADES);
			Card card2 = Card.createAPokerStyleCardByFaceAndSuit(PokerFace.ACE, PokerSuit.SPADES);
			assertNotEquals(card1, card2);
		} catch (CardWithoutFaceException | CardWithoutSuitException e) {
			e.printStackTrace();
		}
    }
    
    @Test(expected = CardWithoutFaceException.class)
    public void itShouldBeExpectedACardWithoutFaceExceptionTest() throws CardWithoutFaceException, CardWithoutSuitException {
    	Card.createAPokerStyleCardByFaceAndSuit(null, PokerSuit.SPADES);
    }
    
    @Test(expected = CardWithoutSuitException.class)
    public void itShouldBeExpectedACardWithoutSuitExceptionTest() throws CardWithoutFaceException, CardWithoutSuitException {
    	Card.createAPokerStyleCardByFaceAndSuit(PokerFace.EIGHT, null);
    }
    
    @Test
    public void itShouldBeKnownTheNameOfACardTest() {
    	
    	final String EXPECTED = "8 of clubs";
    	String cardName = null;
    	
    	try {
    	Card card = Card.createAPokerStyleCardByFaceAndSuit(PokerFace.EIGHT, PokerSuit.CLUBS);
    	cardName = card.getCardName();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	assertNotNull(cardName);
    	assertTrue(EXPECTED.equals(cardName));
    }
    
    
}
