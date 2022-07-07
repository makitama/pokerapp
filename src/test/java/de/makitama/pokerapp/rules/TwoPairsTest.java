package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class TwoPairsTest {

    private final TwoPairs twoPairs = new TwoPairs();

    @Test
    void testRank_twoPairs() {
        Optional<Rank> optionalRank = twoPairs.rank(List.of(CARD_S6, CARD_S7, CARD_C7, CARD_C8, CARD_D8));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.TWO_PAIRS, rank.getType());
        assertEquals(List.of(8, 7, 6), rank.getRatings());
    }

    @Test
    void testRank_noPairs() {
        Optional<Rank> optionalRank = twoPairs.rank(List.of(CARD_S2, CARD_S4, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }

    @Test
    void testRank_singlePair() {
        Optional<Rank> optionalRank = twoPairs.rank(List.of(CARD_S6, CARD_S7, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }

}