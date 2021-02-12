package com.thepinkdev.deck_of_cards.entities;

import com.thepinkdev.deck_of_cards.data.PokerFace;
import com.thepinkdev.deck_of_cards.data.PokerSuit;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutFaceException;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutSuitException;

public class Card {
	
	private PokerFace face;
	private PokerSuit suit;
	
	/**
	 * Private constructor to avoid external manipulation
	 * @param face
	 * @param suit
	 */
	private Card (PokerFace face, PokerSuit suit) {
		this.face = face;
		this.suit = suit;
	}
	
	/**
	 * Builder method. It controls that no card can be created without
	 * face or suit and all cards created are poker-styled.
	 * @param face
	 * @param suit
	 * @return
	 * @throws CardWithoutFaceException
	 * @throws CardWithoutSuitException
	 */
	public static Card createAPokerStyleCardByFaceAndSuit(PokerFace face, PokerSuit suit) 
			throws CardWithoutFaceException, CardWithoutSuitException {
		if (face == null) {
			throw new CardWithoutFaceException();
		}
		if (suit == null) {
			throw new CardWithoutSuitException();
		}
		return new Card(face, suit);
	}
	
	/**
	 * Retrieves the poker-styled Face of a card.
	 * @return
	 */
	public PokerFace getFace() {
		return face;
	}
	
	/**
	 * Retrieves the poker-styled Suit of a card.
	 * @return
	 */
	public PokerSuit getSuit() {
		return suit;
	}

	/**
	 * Retrieves the card name using the Face name and the Suit name.
	 * @return
	 */
	public String getCardName() {
		return face.getFaceName() + " of " + suit.getSuitName();
	}
}
