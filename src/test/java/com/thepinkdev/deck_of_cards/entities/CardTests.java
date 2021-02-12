package com.thepinkdev.deck_of_cards.entities;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.thepinkdev.deck_of_cards.data.Face;
import com.thepinkdev.deck_of_cards.data.Suit;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutFaceException;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutSuitException;

public class CardTests {

    @Test
    public void itShouldNotBeEqualsTwoCardsWithTheSameFaceAndSuitTest() {
		try {
			Card card1 = Card.createACardByFaceAndSuit(Face.ACE, Suit.SPADES);
			Card card2 = Card.createACardByFaceAndSuit(Face.ACE, Suit.SPADES);
			assertNotEquals(card1, card2);
		} catch (CardWithoutFaceException | CardWithoutSuitException e) {
			e.printStackTrace();
		}
    }
    
    @Test(expected = CardWithoutFaceException.class)
    public void itShouldBeExpectedACardWithoutFaceExceptionTest() throws CardWithoutFaceException, CardWithoutSuitException {
    	Card.createACardByFaceAndSuit(null, Suit.SPADES);
    }
    
    @Test(expected = CardWithoutSuitException.class)
    public void itShouldBeExpectedACardWithoutSuitExceptionTest() throws CardWithoutFaceException, CardWithoutSuitException {
    	Card.createACardByFaceAndSuit(Face.EIGHT, null);
    }
    
    @Test
    public void itShouldBeKnownTheNameOfACardTest() {
    	
    	final String EXPECTED = "8 of clubs";
    	String cardName = null;
    	
    	try {
    	Card card = Card.createACardByFaceAndSuit(Face.EIGHT, Suit.CLUBS);
    	cardName = card.getCardName();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	assertNotNull(cardName);
    	assertTrue(EXPECTED.equals(cardName));
    }
    
    
}
