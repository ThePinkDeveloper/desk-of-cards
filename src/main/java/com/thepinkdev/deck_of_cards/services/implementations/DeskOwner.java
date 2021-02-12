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
	
	private DeskOwner(Desk desk) {
		ownedDesk = desk;
	}
	
	public static DeskOwner createOwnerWithADefaultDesk() {
		Desk defaultDesk = Desk.createAPokerStyleDesk();
		return new DeskOwner(defaultDesk);
	}

	@Override
	public void shuffle() {
		
		Desk shuffledDesk = ownedDesk;
		
		Integer cardsInTheOwnedDesk = ownedDesk.size();
		IntStream.rangeClosed(1, cardsInTheOwnedDesk).forEach( iteration -> {
			Card dealedCard = dealOneCard();
			shuffledDesk.add(dealedCard);
		});

		ownedDesk = shuffledDesk;
	}

	@Override
	public Card dealOneCard() {
		
		Integer pickedCardNumber = pickARandomCardNumberFromTheDesk(ownedDesk);
		int pickedCardIndex = pickedCardNumber - 1;
		Card pickedCard = ownedDesk.get(pickedCardIndex);
		ownedDesk.remove(pickedCardIndex);
		
		return pickedCard;
	}
	
	private Integer pickARandomCardNumberFromTheDesk(Desk desk) {
		Integer cardsInTheDesk = desk.size();
		Integer pickedCardNumber = 0;
		try {
			pickedCardNumber = Generators.randomNumberBetweenOneAndAnotherPositiveNumber(cardsInTheDesk);
		} catch (NegativeNumberException e) {
			LOGGER.warning("You can not pick a negative card number.");
		} catch (ZeroNumberException e) {
			LOGGER.info("The desk is empty.");
		}
		
		return pickedCardNumber;
	}

	public Desk getDesk() {
		return ownedDesk;
	}

	public void setDesk(Desk desk) {
		this.ownedDesk = desk;
	}
	
	
	
	

}
