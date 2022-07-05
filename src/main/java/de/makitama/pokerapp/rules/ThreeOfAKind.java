package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import de.makitama.pokerapp.services.RankingUtils;

import java.util.List;
import java.util.Optional;

public class ThreeOfAKind implements Rule {

    private final HandRankings handRanking = HandRankings.THREE_OF_A_KIND;

    /*
     * Three of the cards in the hand have the same value.
     * Hands which both contain three of a kind are ranked by the value of the 3 cards.
     */
    //TODO ThreeOfAKind RankingService

    public static boolean isThreeOfAKind(List<Card> hand) {
        return RankingUtils.isDistinctCardValueEqualsToGivenAmount(hand, 3);
    }

    public static int getValueOfTriple(List<Card> hand) {
        List<Card> tripleCards = RankingUtils.getCardsWithDuplicateValues(hand, 3);
        return tripleCards.stream().mapToInt(card -> card.getValue().getRating()).sum();
    }

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        if (!isThreeOfAKind(hand)) {
            return Optional.empty();
        }
        Rank.RankBuilder rankBuilder = Rank.initiateRankingFor(handRanking);
        rankBuilder.addRating(getValueOfTriple(hand));
        return Optional.of(rankBuilder.build());
    }
}
