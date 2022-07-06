package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.RankingUtils;
import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

/**
 * 4 cards with the same value. Ranked by the value of the 4 cards.
 */
public class FourOfAKind implements Rule {

    private static List<Card> getCardsForQuadruple(List<Card> hand) {
        return RankingUtils.findCardsWithSameValue(hand, 4);
    }

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        List<Card> cardsForQuadruple = getCardsForQuadruple(hand);

        if (cardsForQuadruple == null) {
            return Optional.empty();
        }

        // @formatter:off
        return Optional.of(Rank.initiateRankingFor(HandRankings.FOUR_OF_A_KIND)
                               .addRating(cardsForQuadruple.get(0).getValue().getRating())
                               .build());
        // @formatter:on
    }

}