package com.thepinkdev.deck_of_cards.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.thepinkdev.deck_of_cards.data.Face;
import com.thepinkdev.deck_of_cards.data.Suit;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutFaceException;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutSuitException;
import com.thepinkdev.deck_of_cards.services.implementations.DeskOwner;

public class Desk extends ArrayList<Card>{
	
	private static final long serialVersionUID = 4424508882955516193L;
	
	private static Logger LOGGER = Logger.getLogger(DeskOwner.class.getName());
	
	private Desk() {
		super();
	}
	
	public static Desk createAnEmptyDesk() {
		return new Desk();
	}
	
	public static Desk createAPokerStyleDesk() {
      	
		Desk desk = Desk.createAnEmptyDesk();
		List<Card> pokerStyleCards = createAllTheCardsForAPokerStyleDesk();
		desk.fillThisDeskWithCard(pokerStyleCards);
			
		return desk;
	}
	
	private static List<Card> createAllTheCardsForAPokerStyleDesk() {
		
		List<Card> cards = new ArrayList<>();
		
		List<Face> listOfFaces = Face.getAListOfAllDefaultFaces();
		List<Suit> listOfSuits = Suit.getAListOfAllDefaultSuits();
		
		listOfSuits.forEach( suit -> {
			listOfFaces.forEach( face -> {
				try {
					Card card = Card.createACardByFaceAndSuit(face, suit);
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
	
	private void fillThisDeskWithCard(List<Card> cards) {
		this.addAll(cards);
	}
}
