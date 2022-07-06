package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.RankingUtils;
import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

/**
 * Three of the cards in the hand have the same value.
 * Hands which both contain three of a kind are ranked by the value of the 3 cards.
 */
public class ThreeOfAKind implements Rule {

    private static List<Card> getCardsOfTriple(List<Card> hand) {
        return RankingUtils.findCardsWithSameValue(hand, 3);
    }

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        List<Card> cardsOfTriple = getCardsOfTriple(hand);

        if (cardsOfTriple == null) {
            return Optional.empty();
        }

        // @formatter:off
        return Optional.of(Rank.initiateRankingFor(HandRankings.THREE_OF_A_KIND)
                               .addRating(cardsOfTriple.get(0).getValue().getRating())
                               .build());
        // @formatter:on
    }
}
