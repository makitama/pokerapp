package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.RankingUtils;
import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import de.makitama.pokerapp.ranking.Rank.RankBuilder;

import java.util.List;
import java.util.Optional;

/**
 * 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the
 * cards forming the pair.
 * If these values are the same, the hands are ranked by the values of the cards not forming the pair,
 * in decreasing order.
 */

public class Pair implements Rule {

    private List<Card> getPairCards(List<Card> hand) {
        return RankingUtils.findCardsWithSameValue(hand, 2);
    }

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        List<Card> pairCards = getPairCards(hand);

        if (pairCards == null) {
            return Optional.empty();
        }

        RankBuilder rankBuilder = Rank.initiateRankingFor(HandRankings.PAIR);
        rankBuilder.addRating(pairCards.get(0).getValue().getRating());
        RankingUtils.reverseCards(hand).stream().filter(card -> !pairCards.contains(card))
                .forEach(card -> rankBuilder.addRating(card.getValue().getRating()));

        return Optional.of(rankBuilder.build());
    }
}