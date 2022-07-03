package de.makitama.pokerapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.cards.CardSuit;
import de.makitama.pokerapp.cards.CardValue;

class GeneralTest {

	@Test
	void returnedCardValueIsCorrect() {
		Card card4 = new Card(CardSuit.H, CardValue._K);
		Card card5 = new Card(CardSuit.C, CardValue._3);
		
		assertEquals(2, card5.getValue().getRating());
		assertEquals(12, card4.getValue().getRating());
	}

}
