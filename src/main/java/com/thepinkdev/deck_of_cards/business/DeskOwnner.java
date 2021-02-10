package com.thepinkdev.deck_of_cards.business;

import com.thepinkdev.deck_of_cards.entities.Card;
import com.thepinkdev.deck_of_cards.entities.Desk;

public interface DeskOwnner {

	public void shuffle(Desk desk);
	public Card dealOneCard();
}
