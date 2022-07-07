package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class HighCardTest {

    private final HighCard highCard = new HighCard();

    @Test
    void testRank_HighCard() {
        Optional<Rank> optionalRank = highCard.rank(List.of(CARD_S2, CARD_S5, CARD_C7, CARD_C8, CARD_D9));

        assertNotNull(optionalRank);
        assertTrue(optionalRank.isPresent());

        Rank rank = optionalRank.get();

        assertEquals(HandRankings.HIGH_CARD, rank.getType());
        assertEquals(List.of(9, 8, 7, 5, 2), rank.getRatings());
    }


}