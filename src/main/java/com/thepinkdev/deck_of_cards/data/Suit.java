package com.thepinkdev.deck_of_cards.data;

import java.util.Arrays;
import java.util.List;

public enum Suit {
	HEARTS("hearts"),
	SPADES("spades"),
	CLUBS("clubs"),
	DIAMONDS("diamonds");
	
	private String suitName;
	
	private Suit(String suitName) {
		this.suitName = suitName;
	}
	
	public static List<Suit> getAListOfAllDefaultSuits() {
		return Arrays.asList(Suit.values());
	}

	public String getSuitName() {
		return suitName;
	}	
}
