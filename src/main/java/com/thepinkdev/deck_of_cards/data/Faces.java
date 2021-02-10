package com.thepinkdev.deck_of_cards.data;

public enum Faces {

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
	
	private Faces(String faceName) {
		this.faceName = faceName;
	}

	public String getFaceName() {
		return faceName;
	}

	public void setFaceName(String faceName) {
		this.faceName = faceName;
	}
}
