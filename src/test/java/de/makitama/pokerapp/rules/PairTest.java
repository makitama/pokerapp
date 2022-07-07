package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    private final Pair pair = new Pair();

    @Test
    void testRank_singlePair() {
        Optional<Rank> optionalRank = pair.rank(List.of(CARD_S6, CARD_S7, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.PAIR, rank.getType());
        assertEquals(List.of(7, 9, 8, 6), rank.getRatings());
    }

    // basically not a valid case
    @Test
    void testRank_twoPairs() {
        Optional<Rank> optionalRank = pair.rank(List.of(CARD_S6, CARD_S7, CARD_C7, CARD_C8, CARD_D8));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.PAIR, rank.getType());
        assertEquals(List.of(7, 8, 8, 6), rank.getRatings());
    }

    @Test
    void testRank_noPairs() {
        Optional<Rank> optionalRank = pair.rank(List.of(CARD_S2, CARD_S4, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }

}