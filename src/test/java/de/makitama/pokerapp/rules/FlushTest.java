package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.cards.CardSuit;
import de.makitama.pokerapp.cards.CardValue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlushTest {

    Card card1 = new Card(CardSuit.C, CardValue._8);
    Card card2 = new Card(CardSuit.C, CardValue._2);
    Card card3 = new Card(CardSuit.C, CardValue._4);
    Card card4 = new Card(CardSuit.C, CardValue._K);
    Card card5 = new Card(CardSuit.C, CardValue._3);

    private final List<Card> hand = List.of(card2, card5, card1, card3, card4);

    @Test
    void FlushShouldBeFound() {
        assertTrue(Flush.isFlush(hand));
    }

    @Test
    void FlushShouldNotBeFound() {
        card3 =new Card(CardSuit.D, CardValue._8);
        List<Card> hand = List.of(card2, card5, card1, card3, card4);
        assertFalse(Flush.isFlush(hand));
    }

}