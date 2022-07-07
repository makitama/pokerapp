package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class ThreeOfAKindTest {

    private final ThreeOfAKind threeOfAKind = new ThreeOfAKind();

    @Test
    void testRank_ThreeOfAKind() {
        Optional<Rank> optionalRank = threeOfAKind.rank(List.of(CARD_D7, CARD_S7, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.THREE_OF_A_KIND, rank.getType());
        assertEquals(List.of(7), rank.getRatings());
    }

    @Test
    void testRank_NoThreeOfAKind() {
        Optional<Rank> optionalRank = threeOfAKind.rank(List.of(CARD_S2, CARD_S4, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }

}