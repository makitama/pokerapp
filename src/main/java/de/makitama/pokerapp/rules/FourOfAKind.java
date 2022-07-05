package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import de.makitama.pokerapp.services.Service;

import java.util.List;
import java.util.Optional;

/**
 * 4 cards with the same value. Ranked by the value of the 4 cards.
 */
public class FourOfAKind implements Rule {

    private final HandRankings handRanking = HandRankings.FOUR_OF_A_KIND;

    public static boolean isFourOfAKind(List<Card> hand) {
        return Service.isDistinctCardValueEqualsToGivenAmount(hand, 2);
    }

    public static List<Card> getCardsForQuadruple(List<Card> hand) {
        return Service.getCardsWithDuplicatesValues(hand, 4);
    }

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        if (!isFourOfAKind(hand)) {
            return Optional.empty();
        }
        Rank.RankBuilder rankBuilder = Rank.initiateRankingFor(handRanking);
        int worthOfQuadruple = getCardsForQuadruple(hand).stream().mapToInt(card -> card.getValue().getRating()).sum();
        rankBuilder.addRating(worthOfQuadruple);

        return Optional.of(rankBuilder.build());
    }
}