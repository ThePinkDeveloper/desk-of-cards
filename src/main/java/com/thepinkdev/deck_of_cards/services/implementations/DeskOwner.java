package com.thepinkdev.deck_of_cards.services.implementations;

import java.util.logging.Logger;
import java.util.stream.IntStream;

import com.thepinkdev.deck_of_cards.entities.Card;
import com.thepinkdev.deck_of_cards.entities.Desk;
import com.thepinkdev.deck_of_cards.exceptions.NegativeNumberException;
import com.thepinkdev.deck_of_cards.exceptions.ZeroNumberException;
import com.thepinkdev.deck_of_cards.services.DeskService;
import com.thepinkdev.deck_of_cards.utils.Generators;

public class DeskOwner implements DeskService{
	
	private static Logger LOGGER = Logger.getLogger(DeskOwner.class.getName());
	
	private Desk ownedDesk;
	
	public DeskOwner() {
		ownedDesk = Generators.createDesk();
	}
	
	public DeskOwner(Desk desk) {
		ownedDesk = desk;
	}

	@Override
	public void shuffle() {
		
		Desk shuffledDesk = new Desk();
		
		Integer cardsInTheOwnedDesk = ownedDesk.size();
		IntStream.rangeClosed(1, cardsInTheOwnedDesk).forEach( iteration -> {
			Card dealedCard = dealOneCard();
			shuffledDesk.add(dealedCard);
		});

		ownedDesk = shuffledDesk;
	}

	@Override
	public Card dealOneCard() {
		
		Integer cardsInTheOwnedDesk = ownedDesk.size();
		Integer pickedCardNumber = 0;
		
		try {
			pickedCardNumber = Generators.randomNumberBetweenOneAndAnotherPositiveNumber(cardsInTheOwnedDesk);
		} catch (NegativeNumberException e) {
			LOGGER.warning("You can not pick a negative card number.");
		} catch (ZeroNumberException e) {
			LOGGER.info("The desk is empty.");
		}
		
		int pickedCardIndex = pickedCardNumber - 1;
		Card pickedCard = ownedDesk.get(pickedCardIndex);
		ownedDesk.remove(pickedCardIndex);
		
		return pickedCard;
		
	}

	public Desk getDesk() {
		return ownedDesk;
	}

	public void setDesk(Desk desk) {
		this.ownedDesk = desk;
	}
	
	
	
	

}
