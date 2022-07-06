package de.makitama.pokerapp;

import de.makitama.pokerapp.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RankingUtils {

    private RankingUtils() {
        //Utility class
    }

    public static List<Card> findCardsWithSameValue(List<Card> hand, int minAmount) {
        List<Card> duplicates = new ArrayList<>();

        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i - 1).getValue() == hand.get(i).getValue()) {
                if (duplicates.isEmpty()) {
                    duplicates.add(hand.get(i - 1));
                }
                duplicates.add(hand.get(i));
            } else {
                duplicates.clear();
            }
            if (duplicates.size() == minAmount) {
                return duplicates;
            }
        }
        return null;
    }

    public static List<Card> reverseCards(List<Card> hand) {
        List<Card> newHand = new ArrayList<>(hand);
        Collections.reverse(newHand);
        return newHand;
    }

}