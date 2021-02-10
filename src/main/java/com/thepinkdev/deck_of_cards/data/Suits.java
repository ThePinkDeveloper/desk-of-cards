package com.thepinkdev.deck_of_cards.data;

public enum Suits {
	HEARTS("hearts"),
	SPADES("spades"),
	CLUBS("clubs"),
	DIAMONDS("diamonds");
	
	private String suitName;
	
	private Suits(String suitName) {
		this.suitName = suitName;
	}

	public String getSuitName() {
		return suitName;
	}

	public void setSuitName(String suitName) {
		this.suitName = suitName;
	}		
}
