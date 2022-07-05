package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.cards.CardSuit;
import de.makitama.pokerapp.cards.CardValue;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FourOfAKindTest {

    @Mock
    Rank rank;

    Card card1 = new Card(CardSuit.C, CardValue._8);
    Card card2 = new Card(CardSuit.H, CardValue._8);
    Card card3 = new Card(CardSuit.D, CardValue._8);
    Card card4 = new Card(CardSuit.S, CardValue._8);
    Card card5 = new Card(CardSuit.C, CardValue._3);

    private final List<Card> hand = List.of(card5, card2, card1, card3, card4);

    @Test
    void testRank() {
        assertNotNull(rank);
        when(rank.getType()).thenReturn(HandRankings.FOUR_OF_A_KIND);
        when(rank.getRatings()).thenReturn(List.of(card4.getValue().getRating() * 4));
        FourOfAKind fourOfAKind = new FourOfAKind();

        assertTrue(fourOfAKind.rank(hand).isPresent());
        assertEquals(rank.getRatings(), fourOfAKind.rank(hand).get().getRatings());
        assertEquals(rank.getType(), fourOfAKind.rank(hand).get().getType());
    }
}