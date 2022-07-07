package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class FlushTest {

    private final Flush flush = new Flush();

    @Test
    void testRank_Flush() {
        Optional<Rank> optionalRank = flush.rank(List.of(CARD_S2, CARD_S4, CARD_S7, CARD_S9, CARD_SQ));
        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.FLUSH, rank.getType());
        assertEquals(List.of(12, 9, 7, 4, 2), rank.getRatings());
    }

    @Test
    void testRank_noFlush() {
        Optional<Rank> optionalRank = flush.rank(List.of(CARD_S2, CARD_S4, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }

}