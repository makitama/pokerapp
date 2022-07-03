package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.services.Service;

import java.util.List;

public class Pair {

    /*
     * 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the
     * cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair,
     * in decreasing order.
     */

    static boolean isPair(List<Card> hand) {
        return Service.isDistinctCardValueEqualsToGivenAmount(hand,4);
       // return hand.stream().mapToInt(card -> card.getValue().getRating()).distinct().count() == 4;
    }

    static List<Card> getPairCards(List<Card> hand) {
        return Service.getCardsWithDuplicatesValues(hand, 2);
    }
    //TODO ranked by cards not forming pair
}