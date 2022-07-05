package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

/**
 * 3 cards of the same value, with the remaining 2 cards forming a pair.
 * Ranked by the value of the 3 cards.
 */
public class FullHouse implements Rule {

    private final HandRankings handRanking = HandRankings.FULL_HOUSE;

    private boolean isPair(List<Card> hand) {
        //TODO
        return false;
    }


    @Override
    public Optional<Rank> rank(List<Card> hand) {
        Rank.RankBuilder rankBuilder = Rank.initiateRankingFor(handRanking);
        //TODO
        return Optional.empty();
    }
}
