package com.thepinkdev.deck_of_cards.exceptions;

public class CardWithoutSuitException extends Exception {

	private static final long serialVersionUID = 7989826875862050498L;

	/**
	 * Exception to control that it can't be created a card without Suit 
	 */
	public CardWithoutSuitException() {
		super();
	}
}