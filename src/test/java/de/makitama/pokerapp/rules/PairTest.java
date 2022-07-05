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
class PairTest {

    @Mock
    Rank rank;

    Card card1 = new Card(CardSuit.C, CardValue._8);
    Card card2 = new Card(CardSuit.C, CardValue._2);
    Card card3 = new Card(CardSuit.H, CardValue._8);
    Card card4 = new Card(CardSuit.H, CardValue._K);
    Card card5 = new Card(CardSuit.C, CardValue._3);

    private final List<Card> hand = List.of(card2, card5, card1, card3, card4);

    @Test
    void checkIfPair() {
        assertTrue(Pair.isPair(hand));
    }

    @Test
    void isGetPairCardsCorrect() {
        assertIterableEquals(Pair.getPairCards(hand), List.of(card1, card3));
    }

    @Test
    void testRank() {
        assertNotNull(rank);
        when(rank.getType()).thenReturn(HandRankings.PAIR);
        when(rank.getRatings()).thenReturn(List.of(card3.getValue().getRating() + card1.getValue().getRating(), card4.getValue().getRating(), card5.getValue().getRating(), card2.getValue().getRating()));
        Pair pair = new Pair();

        assertTrue(pair.rank(hand).isPresent());
        assertEquals(rank.getRatings(), pair.rank(hand).get().getRatings());
        assertEquals(rank.getType(), pair.rank(hand).get().getType());

    }

}