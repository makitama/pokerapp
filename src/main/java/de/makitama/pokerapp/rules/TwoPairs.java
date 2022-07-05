package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.Rank;

import java.util.List;
import java.util.Optional;

public class TwoPairs implements Rule{

    /*
     * The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the
     * value of their highest pair. Hands with the same highest pair are ranked by the value of their
     * other pair. If these values are the same the hands are ranked
     * by the value of the remaining card.
     */

    @Override
    public Optional<Rank> rank(List<Card> hand) {

        return Optional.empty();
    }
    //TODO twoPairs
}
