package com.thepinkdev.deck_of_cards.data;

import java.util.Arrays;
import java.util.List;

public enum Face {

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
	
	private Face(String faceName) {
		this.faceName = faceName;
	}
	
	public static List<Face> getAListOfAllDefaultFaces() {
		return Arrays.asList(Face.values());
	}

	public String getFaceName() {
		return faceName;
	}
	
}
