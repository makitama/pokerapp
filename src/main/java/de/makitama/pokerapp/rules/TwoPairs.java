package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.RankingUtils;
import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the
 * value of their highest pair. Hands with the same highest pair are ranked by the value of their
 * other pair. If these values are the same the hands are ranked
 * by the value of the remaining card.
 */
public class TwoPairs implements Rule {

    @Override
    public Optional<Rank> rank(List<Card> hand) {

        List<Card> pair1 = RankingUtils.findCardsWithSameValue(hand, 2);

        if (pair1 == null) {
            return Optional.empty();
        }

        List<Card> remainingHand = new ArrayList<>(hand);
        remainingHand.removeAll(pair1);

        List<Card> pair2 = RankingUtils.findCardsWithSameValue(remainingHand, 2);

        if (pair2 == null) {
            return Optional.empty();
        }

        remainingHand.removeAll(pair2);

        int pair1Rating = pair1.get(0).getValue().getRating();
        int pair2Rating = pair2.get(0).getValue().getRating();
        boolean pair1IsHigher = pair1Rating > pair2Rating;

        // @formatter:off
        return Optional.of(Rank.initiateRankingFor(HandRankings.TWO_PAIRS)
                               .addRating(pair1IsHigher ? pair1Rating : pair2Rating)
                               .addRating(pair1IsHigher ? pair2Rating : pair1Rating)
                               .addRating(remainingHand.get(0).getValue().getRating())
                               .build());
        // @formatter:on
    }
    //TODO TESTING
}
