package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.RankingUtils;
import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 3 cards of the same value, with the remaining 2 cards forming a pair.
 * Ranked by the value of the 3 cards.
 */
public class FullHouse implements Rule {

    @Override
    public Optional<Rank> rank(List<Card> hand) {

        List<Card> triple = RankingUtils.findCardsWithSameValue(hand, 3);
        if (triple == null) {
            return Optional.empty();
        }
        List<Card> localHand = new ArrayList<>(hand);
        localHand.removeAll(triple);
        List<Card> pair = RankingUtils.findCardsWithSameValue(localHand, 2);

        if (pair == null) {
            return Optional.empty();
        }

        // @formatter:off
        return Optional.of(Rank.initiateRankingFor(HandRankings.FULL_HOUSE)
                               .addRating(triple.get(0).getValue().getRating())
                               .build());
        // @formatter:on
    }

}
