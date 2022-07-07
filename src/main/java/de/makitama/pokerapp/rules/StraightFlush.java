package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

/**
 * 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.
 */
public class StraightFlush implements Rule {

    private static boolean isStraightFlush(List<Card> hand) {
        if (hand.stream().map(Card::getSuit).distinct().count() != 1) {
            return false;
        }

        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i - 1).getValue().getRating() != hand.get(i).getValue().getRating() - 1) {
                return false;
            }
        }
        return true;
    }


    @Override
    public Optional<Rank> rank(List<Card> hand) {
        if (!isStraightFlush(hand)) {
            return Optional.empty();
        }

        // @formatter:off
        return Optional.of(Rank.initiateRankingFor(HandRankings.STRAIGHT_FLUSH)
                               .addRating(hand.get(hand.size() - 1).getValue().getRating())
                               .build());
        // @formatter:on
    }

}
