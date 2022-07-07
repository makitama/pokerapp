package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.RankingUtils;
import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

/**
 * Hand contains 5 cards of the same suit.
 * Hands which are both flushes are ranked using the rules for High Card.
 */
public class Flush implements Rule {

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        if (hand.stream().map(Card::getSuit).distinct().count() != 1) {
            return Optional.empty();
        }

        Rank.RankBuilder rankBuilder = Rank.initiateRankingFor(HandRankings.FLUSH);
        RankingUtils.reverseCards(hand).forEach(card -> rankBuilder.addRating(card.getValue().getRating()));
        return Optional.of(rankBuilder.build());
    }

}