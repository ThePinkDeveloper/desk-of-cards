package com.thepinkdev.deck_of_cards.entities;

import com.thepinkdev.deck_of_cards.data.Face;
import com.thepinkdev.deck_of_cards.data.Suit;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutFaceException;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutSuitException;

public class Card {
	
	private Face face;
	private Suit suit;
	
	private Card (Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}
	
	public static Card createACardByFaceAndSuit(Face face, Suit suit) 
			throws CardWithoutFaceException, CardWithoutSuitException {
		if (face == null) {
			throw new CardWithoutFaceException();
		}
		if (suit == null) {
			throw new CardWithoutSuitException();
		}
		return new Card(face, suit);
	}
	
	public Face getFace() {
		return face;
	}

	public Suit getSuit() {
		return suit;
	}

	public String getCardName() {
		return face.getFaceName() + " of " + suit.getSuitName();
	}
}
