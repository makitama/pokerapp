package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;

import java.util.List;

public class Flush implements Rule{

    /*
     * Hand contains 5 cards of the same suit.
     * Hands which are both flushes are ranked using the rules for High Card.
     */

    public static boolean isFlush(List<Card> hand) {

        return hand.isEmpty() || hand.stream().map(Card::getCardSuit).distinct().count() <= 1;

    }

    //TODO hands that are both flushes

}