package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import de.makitama.pokerapp.services.Service;

import java.util.List;
import java.util.Optional;

/**
 * Hand contains 5 cards of the same suit.
 * Hands which are both flushes are ranked using the rules for High Card.
 */
public class Flush implements Rule{

    private final HandRankings handRanking = HandRankings.FLUSH;

    public static boolean isFlush(List<Card> hand) {
        return hand.isEmpty() || hand.stream().map(Card::getSuit).distinct().count() <= 1;
    }

    @Override
    public Optional<Rank> rank(List<Card> hand) {

        if(isFlush(hand)) {
            Rank.RankBuilder rankBuilder = Rank.initiateRankingFor(handRanking);
            Service.reverseCards(hand).forEach(card -> rankBuilder.addRating(card.getValue().getRating()));

            return Optional.of(rankBuilder.build());
        }

        return Optional.empty();

    }

}