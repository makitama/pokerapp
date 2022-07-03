package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {

    /*
     * 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the
     * cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair,
     * in decreasing order.
     */

    static boolean isPair(List<Card> hand) {
        return hand.stream().mapToInt(card -> card.getValue().getRating()).distinct().count() == 4;
    }

    static List<Card> getPairCards(List<Card> hand) {

        for(int i=1; i<hand.size(); i++){
            if(hand.get(i).getValue() == hand.get(i-1).getValue()) {
                return List.of(hand.get(i), hand.get(i-1));
            }
        }
        return null;
    }
    //TODO ranked by cards not forming pair
}