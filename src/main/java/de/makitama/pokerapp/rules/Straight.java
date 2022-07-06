package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

/**
 * Hand contains 5 cards with consecutive values.
 * Hands which both contain a straight are ranked by their highest card.
 */
public class Straight implements Rule {

    private boolean isStraight(List<Card> hand) {
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i - 1).getValue().getRating() != hand.get(i).getValue().getRating() - 1) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        if (!isStraight(hand)) {
            return Optional.empty();
        }

        // @formatter:off
        return Optional.of(Rank.initiateRankingFor(HandRankings.STRAIGHT)
                               .addRating(hand.get(hand.size() - 1).getValue().getRating())
                               .build());
        // @formatter:on
    }

    //TODO TESTING
}
