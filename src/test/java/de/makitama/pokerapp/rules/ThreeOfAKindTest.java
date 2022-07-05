package de.makitama.pokerapp.rules;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.cards.CardSuit;
import de.makitama.pokerapp.cards.CardValue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeOfAKindTest {

    @Test
    void ShouldFindTriple() {
        Card card1 = new Card(CardSuit.C, CardValue._8);
        Card card2 = new Card(CardSuit.C, CardValue._2);
        Card card3 = new Card(CardSuit.H, CardValue._8);
        Card card4 = new Card(CardSuit.H, CardValue._8);
        Card card5 = new Card(CardSuit.C, CardValue._3);

        List<Card> hand = List.of(card2, card5, card1, card3, card4);

        assertTrue(ThreeOfAKind.isThreeOfAKind(hand));
    }

    @Test
    void ShouldFailToFindTriple() {
        Card card1 = new Card(CardSuit.C, CardValue._7);
        Card card2 = new Card(CardSuit.C, CardValue._2);
        Card card3 = new Card(CardSuit.H, CardValue._8);
        Card card4 = new Card(CardSuit.H, CardValue._8);
        Card card5 = new Card(CardSuit.C, CardValue._3);

        List<Card> hand = List.of(card2, card5, card1, card3, card4);

        assertFalse(ThreeOfAKind.isThreeOfAKind(hand));
    }

}