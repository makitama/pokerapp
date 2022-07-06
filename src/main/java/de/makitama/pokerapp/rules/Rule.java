package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

public interface Rule {

    /**
     * @param hand the list of cards that should be ranked; card values must be in ascending sort order
     * @return Optional of Rank, initialized for argument hand on specific Rule class
     */
    Optional<Rank> rank(List<Card> hand);

}
