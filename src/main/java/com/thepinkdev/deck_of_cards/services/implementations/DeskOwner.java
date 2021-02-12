package com.thepinkdev.deck_of_cards.services.implementations;

import java.util.logging.Logger;
import java.util.stream.IntStream;

import com.thepinkdev.deck_of_cards.entities.Card;
import com.thepinkdev.deck_of_cards.entities.Desk;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutFaceException;
import com.thepinkdev.deck_of_cards.exceptions.CardWithoutSuitException;
import com.thepinkdev.deck_of_cards.exceptions.ZeroOrNegativeNumberException;
import com.thepinkdev.deck_of_cards.services.DeskService;
import com.thepinkdev.deck_of_cards.utils.Generators;

public class DeskOwner implements DeskService{
	
	private static Logger LOGGER = Logger.getLogger(DeskOwner.class.getName());
	
	private Desk ownedDesk;
	
	/**
	 * Private constructor to avoid external manipulation
	 * @param desk
	 */
	private DeskOwner(Desk desk) {
		ownedDesk = desk;
	}
	
	/**
	 * Builder method. It retrieves a deskOwner with a poker-styled desk included.
	 * @return
	 */
	public static DeskOwner createAnOwnerWithAPokerStyleDesk() {
		Desk pokerStyleDesk = Desk.createAPokerStyleDesk();
		return new DeskOwner(pokerStyleDesk);
	}

	/**
	 * A MAIN METHOD. It calls 100 times the shuffling() helps method to improve
	 * randomness. 
	 */
	@Override
	public void shuffle() {
		// Repeat shuffling method 100 time to give randomness
		IntStream.rangeClosed(1, 100).forEach( i -> shuffling());
	}
	
	/**
	 * Private helper method. It takes a random card from the deskOwner's desk and put it
	 * in a temporal desk. It repeat the process for every card in the deskowner's desk.
	 * After all cards are in the temporal desk, the temporal desk becomes the deskowner's
	 * desk. 
	 */
	private void shuffling() {
		
		Desk shuffledDesk = ownedDesk;
		
		Integer cardsInTheOwnedDesk = ownedDesk.size();
		IntStream.rangeClosed(1, cardsInTheOwnedDesk).forEach( iteration -> {
			Card dealedCard = dealOneCard();
			try {
				shuffledDesk.add(Card.createAPokerStyleCardByFaceAndSuit(dealedCard.getFace(), dealedCard.getSuit()));
			} catch (CardWithoutFaceException e) {
				LOGGER.warning("A card without a face can not be created.");
			} catch (CardWithoutSuitException e) {
				LOGGER.warning("A card without a suit can not be created.");
			}
		});

		ownedDesk = shuffledDesk;
	}

	/**
	 * A MAIN METHOD. It deals one random card from the deskowner's desk
	 */
	@Override
	public Card dealOneCard() {
		
		Integer pickedCardNumber = pickARandomCardNumberFromTheDesk(ownedDesk);
		int pickedCardIndex = pickedCardNumber - 1;
		Card pickedCard = ownedDesk.get(pickedCardIndex);
		ownedDesk.remove(pickedCardIndex);
		
		return pickedCard;
	}
	
	/**
	 * Private helper method. It retrieves a random number between one and the size of the
	 * desk given as parameter.
	 * WARNING. As it uses the helper method randomNumberBetweenOneAndAnotherPositiveNumber
	 * it is recommended to use it several times to improve randomness 
	 *
	 * @param desk
	 * @return
	 */
	private Integer pickARandomCardNumberFromTheDesk(Desk desk) {
		
		Integer cardsInTheDesk = desk.size();
		Integer pickedCardNumber = 0;
		
		try {
			pickedCardNumber = Generators.randomNumberBetweenOneAndAnotherPositiveNumber(cardsInTheDesk);
		} catch (ZeroOrNegativeNumberException e) {
			LOGGER.info("The desk is empty.");
		}
		
		return pickedCardNumber;
	}
	
	/**
	 * Retrieves the deskowner's desk.
	 * @return
	 */
	public Desk getDesk() {
		return ownedDesk;
	}
}
