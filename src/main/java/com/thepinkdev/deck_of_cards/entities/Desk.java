package com.thepinkdev.deck_of_cards.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.thepinkdev.deck_of_cards.data.PokerFace;
import com.thepinkdev.deck_of_cards.data.PokerSuit;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutFaceException;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutSuitException;
import com.thepinkdev.deck_of_cards.services.implementations.DeskOwner;

public class Desk extends ArrayList<Card>{
	
	private static final long serialVersionUID = 4424508882955516193L;
	
	private static Logger LOGGER = Logger.getLogger(DeskOwner.class.getName());
	
	/**
	 * Private constructor to avoid external manipulation
	 * @param face
	 * @param suit
	 */
	private Desk() {
		super();
	}
	
	/**
	 * Builder method for this empty desk. It returns this desk with no cards in it.
	 * @return
	 */
	public static Desk createAnEmptyDesk() {
		return new Desk();
	}
	
	/**
	 * Builder method for this poker-styled desk. It returns this Desk filled will
	 * poker-styled cards sorted.
	 * @return
	 */
	public static Desk createAPokerStyleDesk() {
      	
		Desk desk = Desk.createAnEmptyDesk();
		List<Card> pokerStyleCards = createAllTheCardsForAPokerStyleDesk();
		desk.fillThisDeskWithCard(pokerStyleCards);
			
		return desk;
	}
	
	/**
	 * Private helper method. It helps to build a poker-styled desk. It created a list
	 * of poker-styled cards sorted and return that list. 
	 */
	private static List<Card> createAllTheCardsForAPokerStyleDesk() {
		
		List<Card> cards = new ArrayList<>();
		
		List<PokerFace> listOfFaces = PokerFace.getAListOfAllPokerFaces();
		List<PokerSuit> listOfSuits = PokerSuit.getAListOfAllPokerSuits();
		
		listOfSuits.forEach( suit -> {
			listOfFaces.forEach( face -> {
				try {
					Card card = Card.createAPokerStyleCardByFaceAndSuit(face, suit);
					cards.add(card);
				} catch (CardWithoutFaceException e) {
					LOGGER.warning("A card without a face can not be created.");
				} catch (CardWithoutSuitException e) {
					LOGGER.warning("A card without a suit can not be created.");
				}
			});
		});
		
		return cards;
	}
	
	/**
	 * Private helper method. It helps to add all the cards included in the list generated
	 * by createAllTheCardsForAPokerStyleDesk() private method, and then add all of them to
	 * this desk.
	 * @param cards
	 */
	private void fillThisDeskWithCard(List<Card> cards) {
		this.addAll(cards);
	}
}
