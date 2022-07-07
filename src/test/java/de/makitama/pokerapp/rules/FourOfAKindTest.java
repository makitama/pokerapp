package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindTest {

    private final FourOfAKind fourOfAKind = new FourOfAKind();

    @Test
    void testRank_fourOfAKind() {
        Optional<Rank> optionalRank = fourOfAKind.rank(List.of(CARD_S2, CARD_C2, CARD_D2, CARD_H2, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.FOUR_OF_A_KIND, rank.getType());
        assertEquals(List.of(2), rank.getRatings());
    }

    @Test
    void testRank_noFourOfAKind() {
        Optional<Rank> optionalRank = fourOfAKind.rank(List.of(CARD_C2, CARD_S2, CARD_H2, CARD_D3, CARD_SQ));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isEmpty());
    }
}