package de.makitama.pokerapp.cards;

public class Card {

    private final CardSuit cardSuit;
    private final CardValue value;


    public Card(CardSuit cardSuit, CardValue value) {
        this.cardSuit = cardSuit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return cardSuit;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CardSuit: " + cardSuit + ", Value: " + value.getRating();
    }
}
