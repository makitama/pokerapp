package de.makitama.pokerapp.ranking;

public enum HandRankings {

    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KIND(4),
    TWO_PAIRS(3),
    PAIR(2),
    HIGH_CARD(1);

    private final int rating;

    HandRankings(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

}
