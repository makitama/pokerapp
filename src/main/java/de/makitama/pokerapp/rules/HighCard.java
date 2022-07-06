package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.RankingUtils;
import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import de.makitama.pokerapp.ranking.Rank.RankBuilder;

import java.util.List;
import java.util.Optional;

/**
 * Hands which do not fit any higher category are ranked by the value of their highest card.
 * If the highest cards have the same value, the hands are ranked by the next highest, and so on.
 */
public class HighCard implements Rule {

    @Override
    public Optional<Rank> rank(List<Card> hand) {
        RankBuilder rankBuilder = Rank.initiateRankingFor(HandRankings.HIGH_CARD);
        RankingUtils.reverseCards(hand).forEach(card -> rankBuilder.addRating(card.getValue().getRating()));
        return Optional.of(rankBuilder.build());
    }

}