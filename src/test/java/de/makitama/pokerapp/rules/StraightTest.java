package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class StraightTest {

    private final Straight straight = new Straight();

    @Test
    void testRank_straight() {
        Optional<Rank> optionalRank = straight.rank(List.of(CARD_S6, CARD_S7, CARD_C8, CARD_C9, CARD_DT));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.STRAIGHT, rank.getType());
        assertEquals(List.of(10), rank.getRatings());
    }

    @Test
    void testRank_noStraight() {
        Optional<Rank> optionalRank = straight.rank(List.of(CARD_S2, CARD_S4, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }

}