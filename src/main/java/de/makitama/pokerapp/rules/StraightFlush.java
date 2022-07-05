package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.Rank;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.
 */
public class StraightFlush implements Rule {

    public static boolean isStraightFlush(List<Card> hand) {

        //TODO straightFlush

        Collections.min(hand, Comparator.comparing(Card::getValue));
        //Flush.isFlush(hand) && hand.stream().
        return false;
    }


    @Override
    public Optional<Rank> rank(List<Card> hand) {
        if (!isStraightFlush(hand)) {
            return Optional.empty();
        }
        //TODO
    }
}
