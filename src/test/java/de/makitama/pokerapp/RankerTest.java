package de.makitama.pokerapp;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Ranker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static de.makitama.pokerapp.PredefinedCards.*;
import static org.junit.jupiter.api.Assertions.*;

class RankerTest {

    private final Ranker ranker = new Ranker();
    private final String expectedMessage = "One List is invalid. Please ensure that all prerequirements are fulfilled.";

    @Test
    public void testRankHand() {

        List<Card> HighCard_hand = List.of(CARD_S2, CARD_C5, CARD_D8, CARD_S9, CARD_HK);

        assertEquals(HandRankings.HIGH_CARD, ranker.rankHand(HighCard_hand).getType());
        assertEquals(List.of(13, 9, 8, 5, 2), ranker.rankHand(HighCard_hand).getRatings());

        List<Card> FullHouseHand = List.of(CARD_S2, CARD_S2, CARD_S2, CARD_C8, CARD_C8);
        assertEquals(HandRankings.FULL_HOUSE, ranker.rankHand(FullHouseHand).getType());
        assertEquals(List.of(2), ranker.rankHand(FullHouseHand).getRatings());
    }

    @Test
    void testCompareTwoHands_ReturnsEquals() {
        List<Card> pairHand = List.of(CARD_S2, CARD_C5, CARD_D8, CARD_S9, CARD_HK);
        List<Card> threeOfAKindHand = List.of(CARD_S2, CARD_C5, CARD_D8, CARD_S9, CARD_HK);
        assertEquals(0, ranker.compareTwoHands(threeOfAKindHand, pairHand));
    }

    @Test
    void testCompareTwoHands_ReturnsFirstHand() {
        List<Card> Straight = List.of(CARD_H3, CARD_D4, CARD_H5, CARD_H6, CARD_H7);
        List<Card> HighCard = List.of(CARD_S2, CARD_C5, CARD_D8, CARD_S9, CARD_HK);
        assertEquals(1, ranker.compareTwoHands(Straight, HighCard));
    }

    @Test
    void testChooseWinner_FirstHandWins() {
        String firstHand = "First hand is winner!";
        List<Card> Straight = List.of(CARD_H3, CARD_D4, CARD_H5, CARD_H6, CARD_H7);
        List<Card> HighCard = List.of(CARD_S2, CARD_C5, CARD_D8, CARD_S9, CARD_HK);
        assertEquals(firstHand, ranker.chooseWinner(Straight, HighCard));
    }

    @Test
    void testChooseWinner_SecondHandWins() {
        String secondHand = "Second hand is winner!";
        List<Card> pairHand = List.of(CARD_S5, CARD_C5, CARD_D8, CARD_S9, CARD_HK);
        List<Card> threeOfAKindHand = List.of(CARD_S2, CARD_C2, CARD_D2, CARD_S9, CARD_HK);
        assertEquals(secondHand, ranker.chooseWinner(pairHand, threeOfAKindHand));
    }

    @Test
    void testChooseWinner_NoHandWins() {
        String equal = "Both hands are of equal worth";
        List<Card> pairHand = List.of(CARD_S5, CARD_C5, CARD_D8, CARD_S9, CARD_HK);
        List<Card> pairHand2 = List.of(CARD_D5, CARD_H5, CARD_C8, CARD_H9, CARD_CK);
        assertEquals(equal, ranker.chooseWinner(pairHand, pairHand2));
    }


    @Test
    void testChooseWinner_IsInvalid_FewerThan5_True() {
        List<Card> fewerThanFiveElements = List.of(CARD_S2, CARD_S4, CARD_C7, CARD_C8);
        List<Card> threeOfAKindHand = List.of(CARD_S2, CARD_C5, CARD_D8, CARD_S9, CARD_HK);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> ranker.chooseWinner(fewerThanFiveElements, threeOfAKindHand));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testChooseWinner_IsInvalid_EmptyList_True() {
        List<Card> emptyList = List.of();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ranker.chooseWinner(emptyList, emptyList));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testChooseWinner_IsInvalid_ListIsNull_True() {
        List<Card> nullList = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ranker.chooseWinner(nullList, nullList));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testChooseWinner_isInvalid_UnsortedList_True() {
        List<Card> unsortedList = List.of(CARD_S4, CARD_S9, CARD_CT, CARD_C2, CARD_S7);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ranker.chooseWinner(unsortedList, unsortedList));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}