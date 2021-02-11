package com.thepinkdev.deck_of_cards.services;

import com.thepinkdev.deck_of_cards.entities.Card;

public interface DeskService {

	public void shuffle();
	public Card dealOneCard();
}
