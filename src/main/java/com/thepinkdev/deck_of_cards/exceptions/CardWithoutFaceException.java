package com.thepinkdev.deck_of_cards.exceptions;

public class CardWithoutFaceException extends Exception {

	private static final long serialVersionUID = -5464596729875346524L;

	/**
	 * Exception to control that it can't be created a card without Face 
	 */
	public CardWithoutFaceException() {
		super();
	}
}
