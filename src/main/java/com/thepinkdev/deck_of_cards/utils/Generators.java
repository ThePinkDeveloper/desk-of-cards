package com.thepinkdev.deck_of_cards.utils;

import java.util.Arrays;
import java.util.List;

import com.thepinkdev.deck_of_cards.data.Faces;
import com.thepinkdev.deck_of_cards.data.Suits;
import com.thepinkdev.deck_of_cards.entities.Card;
import com.thepinkdev.deck_of_cards.entities.Desk;

public class Generators {
	
	private Generators() {}
	
	public static Card createCard(String face, String suit) {
		return new Card(face, suit);
	}
	
	public static Desk createDesk() {
		
		Desk desk = new Desk();
		
		List<Faces> listOfFaces = Arrays.asList(Faces.values());
		List<Suits> listOfSuit = Arrays.asList(Suits.values());
		
		listOfSuit.forEach( suit -> {
			listOfFaces.forEach( face -> {
				Card card = createCard(face.getFaceName(), suit.getSuitName());
				desk.add(card);
			});
		});
		
		return desk;
	}

}
