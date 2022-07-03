package de.makitama.pokerapp.rules;

import java.util.Comparator;
import java.util.List;

import de.makitama.pokerapp.cards.Card;

public class HighCard implements Rule{

	/*
	 * Hands which do not fit any higher category are ranked by the value of their highest card.
	 * If the highest cards have the same value, the hands are ranked by the next highest, and so on.
	 */


	public static Card getHighestCard(List<Card> hand) {
		//TODO Check isPresent() => Optional. => necessary?
		return hand.stream().max(Comparator.comparing(Card::getValue)).get();
	}
//TODO HighCard => nexthighest etc..


}