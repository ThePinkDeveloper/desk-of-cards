package com.thepinkdev.deck_of_cards.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.thepinkdev.deck_of_cards.data.Faces;
import com.thepinkdev.deck_of_cards.data.Suits;
import com.thepinkdev.deck_of_cards.entities.Card;
import com.thepinkdev.deck_of_cards.entities.Desk;
import com.thepinkdev.deck_of_cards.exceptions.NegativeNumberException;
import com.thepinkdev.deck_of_cards.exceptions.ZeroNumberException;

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
	
	public static Integer randomNumberBetweenOneAndAnotherPositiveNumber (Integer positiveNumber)
			throws NegativeNumberException, ZeroNumberException {
		
		if (positiveNumber < 0) {
			throw new NegativeNumberException();
		} else if (positiveNumber == 0) {
			throw new ZeroNumberException();
		}
		
		Random seed = new Random(System.currentTimeMillis());
		return seed.nextInt(positiveNumber) + 1;
	}

}
