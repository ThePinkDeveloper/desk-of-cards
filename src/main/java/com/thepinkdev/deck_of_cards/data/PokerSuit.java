package com.thepinkdev.deck_of_cards.data;

import java.util.Arrays;
import java.util.List;

public enum PokerSuit {
	HEARTS("hearts"),
	SPADES("spades"),
	CLUBS("clubs"),
	DIAMONDS("diamonds");
	
	private String suitName;
	
	/**
	 * Private constructor to avoid external manipulation
	 * @param faceName
	 */
	private PokerSuit(String suitName) {
		this.suitName = suitName;
	}
	
	/**
	 * Retrieves a list of all poker suits
	 * @return
	 */
	public static List<PokerSuit> getAListOfAllPokerSuits() {
		return Arrays.asList(PokerSuit.values());
	}

	/**
	 * Retrieves the name of the selected suit
	 * @return
	 */
	public String getSuitName() {
		return suitName;
	}	
}
