package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class StraightFlushTest {

    private final StraightFlush straightFlush = new StraightFlush();

    @Test
    void testRank_StraightFlush() {
        Optional<Rank> optionalRank = straightFlush.rank(List.of(CARD_S6, CARD_S7, CARD_S8, CARD_S9, CARD_ST));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.STRAIGHT_FLUSH, rank.getType());
        assertEquals(List.of(10), rank.getRatings());
    }

    @Test
    void testRank_NoStraightFlush() {
        Optional<Rank> optionalRank = straightFlush.rank(List.of(CARD_S6, CARD_S7, CARD_C8, CARD_C9, CARD_DT));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }

}