package com.thepinkdev.deck_of_cards.services.implementations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.thepinkdev.deck_of_cards.data.PokerFace;
import com.thepinkdev.deck_of_cards.data.PokerSuit;
import com.thepinkdev.deck_of_cards.entities.Card;
import com.thepinkdev.deck_of_cards.entities.Desk;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutFaceException;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutSuitException;

public class DeskOwnerTest {
	
	private static Logger LOGGER = Logger.getLogger(DeskOwner.class.getName());

	DeskOwner deskOwner;
	
	@Before
	public void initilize() {
    	deskOwner = DeskOwner.createAnOwnerWithAPokerStyleDesk();
	}
	
    @Test
    public void itShouldHave52CardsThePokerStyleDeskWonedByTheDeskOwnerWhenItIsCreatedTest() {
    	Desk pokerStyleDesk = deskOwner.getDesk();
    	
    	int APokerStyleDeskSize = 52;
    	assertEquals(APokerStyleDeskSize, pokerStyleDesk.size());
    }
    
    @Test
    public void itShouldBeAPokerStyleCardTheOneDealedByTheDeskOwnerTest() {
    	Card card = deskOwner.dealOneCard();
    	
    	boolean isAPokerStyleFacedCard = PokerFace.getAListOfAllPokerFaces().contains(card.getFace());
    	boolean isAPokerStyleSuitedCard = PokerSuit.getAListOfAllPokerSuits().contains(card.getSuit());
    	
    	assertTrue(isAPokerStyleFacedCard && isAPokerStyleSuitedCard);
    }
    
    @Test
    public void itShouldBeDifferentTheTopFiveCardsAfterShufflingTest() {
    	deskOwner.shuffle();
    	Desk desk = deskOwner.getDesk();
    	
    	List<Card> firstFiveCardsAfterShuffling1 = new ArrayList<>();
    	List<Card> firstFiveCardsAfterShuffling2 = new ArrayList<>();
    	
    	IntStream.rangeClosed(0, 4).forEach( i -> {
    		Card card = desk.get(i);
    		try {
    			firstFiveCardsAfterShuffling1
					.add(Card.createAPokerStyleCardByFaceAndSuit(card.getFace(), card.getSuit()));
			} catch (CardWithoutFaceException | CardWithoutSuitException e) {
				LOGGER.warning("A card without a face or suit can not be created.");
			}
    	});
    	
    	deskOwner.shuffle();
    	
    	IntStream.rangeClosed(0, 4).forEach( i -> {
    		Card card = desk.get(i);
    		try {
    			firstFiveCardsAfterShuffling2
					.add(Card.createAPokerStyleCardByFaceAndSuit(card.getFace(), card.getSuit()));
			} catch (CardWithoutFaceException | CardWithoutSuitException e) {
				LOGGER.warning("A card without a face or suit can not be created.");
			}
    	});
    	
    	boolean firstCardsAreEquals = firstFiveCardsAfterShuffling1.get(0).getCardName().equals(
    			firstFiveCardsAfterShuffling2.get(0).getCardName());
    	boolean secondCardsAreEquals = firstFiveCardsAfterShuffling1.get(1).getCardName().equals(
    			firstFiveCardsAfterShuffling2.get(1).getCardName());
    	boolean thirdCardsAreEquals = firstFiveCardsAfterShuffling1.get(2).getCardName().equals(
    			firstFiveCardsAfterShuffling2.get(2).getCardName());
    	boolean fourthCardsAreEquals = firstFiveCardsAfterShuffling1.get(3).getCardName().equals(
    			firstFiveCardsAfterShuffling2.get(3).getCardName());
    	boolean fifthCardsAreEquals = firstFiveCardsAfterShuffling1.get(4).getCardName().equals(
    			firstFiveCardsAfterShuffling2.get(4).getCardName());
    	
    	assertFalse(firstCardsAreEquals && secondCardsAreEquals && thirdCardsAreEquals &&
    			fourthCardsAreEquals && fifthCardsAreEquals); 	
    }
    
}
