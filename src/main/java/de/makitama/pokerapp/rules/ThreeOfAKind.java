package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.services.Service;

import java.util.List;

public class ThreeOfAKind {

    /*
     * Three of the cards in the hand have the same value.
     * Hands which both contain three of a kind are ranked by the value of the 3 cards.
     */
    //TODO ThreeOfAKind RankingService

    public static boolean isThreeOfAKind(List<Card> hand) {
        return Service.isDistinctCardValueEqualsToGivenAmount(hand, 3);
    }

    public static List<Card> getValueOfTriple(List<Card> hand) {
        return Service.getCardsWithDuplicatesValues(hand, 3);
    }

}
