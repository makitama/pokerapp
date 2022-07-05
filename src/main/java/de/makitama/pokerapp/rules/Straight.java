package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

/**
 * Hand contains 5 cards with consecutive values.
 * Hands which both contain a straight are ranked by their highest card.
 */
public class Straight implements Rule {

    //TODO straight

    private final HandRankings handRanking = HandRankings.STRAIGHT;

    private boolean isStraight(List<Card> hand) {
        //TODO
        return false;
    }

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        if (!isStraight(hand)) {
            return Optional.empty();
        }
        Rank.RankBuilder rankBuilder = Rank.initiateRankingFor(handRanking);
        return Optional.of(rankBuilder.build());
    }

}
