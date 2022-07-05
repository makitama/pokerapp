package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.cards.CardSuit;
import de.makitama.pokerapp.cards.CardValue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HighCardTest {

    @Test
    void highestCardIsReturned() {
        Card card1 = new Card(CardSuit.C, CardValue._4);
        Card card2 = new Card(CardSuit.C, CardValue._2);
        Card card3 = new Card(CardSuit.H, CardValue._8);
        Card card4 = new Card(CardSuit.H, CardValue._K);
        Card card5 = new Card(CardSuit.C, CardValue._3);

        final List<Card> hand = List.of(card1, card2, card3, card4, card5);

        assertEquals(card4, HighCard.getHighestCard(hand));
        assertNotEquals(card2, HighCard.getHighestCard(hand));
    }

}