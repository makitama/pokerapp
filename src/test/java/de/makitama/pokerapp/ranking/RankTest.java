package de.makitama.pokerapp.ranking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @Test
    void compareRanksShouldReturnRightValue() {
        assertEquals(0, HandRankings.HIGH_CARD.compareTo(HandRankings.HIGH_CARD));
        assertEquals(1, HandRankings.HIGH_CARD.compareTo(HandRankings.PAIR));
        assertEquals(-1, HandRankings.PAIR.compareTo(HandRankings.HIGH_CARD));
    }
}