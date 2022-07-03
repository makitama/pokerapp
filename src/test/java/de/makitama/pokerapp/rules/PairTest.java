package de.makitama.pokerapp.rules;

import static org.junit.jupiter.api.Assertions.*;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.cards.CardSuit;
import de.makitama.pokerapp.cards.CardValue;
import org.junit.jupiter.api.Test;

import java.util.List;

class PairTest {

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
		assertEquals(List.of(card3, card1), Pair.getPairCards(hand));
	}

}