package de.makitama.pokerapp.services;

import de.makitama.pokerapp.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public static boolean isDistinctCardValueEqualsToGivenAmount(List<Card> hand, int amount) {
        return hand.stream().mapToInt(card -> card.getValue().getRating()).distinct().count() == amount;
    }

    public static List<Card> getCardsWithDuplicatesValues(List<Card> hand, int amount) {
        List<Card> duplicates = new ArrayList<>();
        for(int i=1; i<hand.size(); i++) {
            if(hand.get(i-1).getValue() == hand.get(i).getValue()) {
                if(duplicates.isEmpty()) {
                    duplicates.add(hand.get(i - 1));
                }
                duplicates.add(hand.get(i));
            }
            if(duplicates.size() == amount) {
                return duplicates;
            }
        }
        return duplicates;
    }

}