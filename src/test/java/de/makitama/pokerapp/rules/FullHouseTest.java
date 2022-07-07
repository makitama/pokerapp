package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class FullHouseTest {

    private final FullHouse fullHouse = new FullHouse();

    @Test
    void testRank_FullHouse() {
        Optional<Rank> optionalRank = fullHouse.rank(List.of(CARD_S7, CARD_D7, CARD_C7, CARD_C8, CARD_D8));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.FULL_HOUSE, rank.getType());
        assertEquals(List.of(7), rank.getRatings());
    }

    @Test
    void testRank_noFullHouse() {
        Optional<Rank> optionalRank = fullHouse.rank(List.of(CARD_S2, CARD_S4, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }

}