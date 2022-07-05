package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import de.makitama.pokerapp.services.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Pair implements Rule{

    /*
     * 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the
     * cards forming the pair.
     * If these values are the same, the hands are ranked by the values of the cards not forming the pair,
     * in decreasing order.
     */

    private final HandRankings handRanking = HandRankings.PAIR;

    static boolean isPair(List<Card> hand) {
        return Service.isDistinctCardValueEqualsToGivenAmount(hand,4);
       // return hand.stream().mapToInt(card -> card.getValue().getRating()).distinct().count() == 4;
    }


    static List<Card> getPairCards(List<Card> hand) {
       return Service.getCardsWithDuplicatesValues(hand, 2);
    }

    private int getValueOfPair(List<Card> pairCards) {
        return pairCards.stream().mapToInt(card -> card.getValue().getRating()).sum();
    }


    @Override
    public Optional<Rank> rank(List<Card> hand) {
        if(isPair(hand)) {
            Rank.RankBuilder rankBuilder = Rank.initiateRankingFor(handRanking);
            List<Card> pairCards = getPairCards(hand);
            rankBuilder.addRating(getValueOfPair(pairCards));
            hand.stream().filter(card -> !pairCards.contains(card)).toList()
                    .forEach(card -> rankBuilder.addRating(card.getValue().getRating()));
            return Optional.of(rankBuilder.build());
        }
        return Optional.empty();
    }
}