package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

public interface Rule {

    /**
     *
     * @param hand the list of cards that should be ranked
     * @return Optional of Rank, inititalized for argument hand on specific Rule class
     */
    Optional<Rank> rank(List<Card> hand);

}
