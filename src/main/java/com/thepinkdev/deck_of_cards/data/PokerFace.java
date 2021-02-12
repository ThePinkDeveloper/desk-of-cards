package com.thepinkdev.deck_of_cards.data;

import java.util.Arrays;
import java.util.List;

public enum PokerFace {

	ACE("ACE"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	JACK("JACK"),
	QUEEN("QUEEN"),
	KING("KING");
	
	private String faceName;
	
	/**
	 * Private constructor to avoid external manipulation
	 * @param faceName
	 */
	private PokerFace(String faceName) {
		this.faceName = faceName;
	}
	
	/**
	 * Retrieves a list of all poker faces
	 * @return
	 */
	public static List<PokerFace> getAListOfAllPokerFaces() {
		return Arrays.asList(PokerFace.values());
	}

	/**
	 * Retrieves the name of the selected face
	 * @return
	 */
	public String getFaceName() {
		return faceName;
	}
	
}
