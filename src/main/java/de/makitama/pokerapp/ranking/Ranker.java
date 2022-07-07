package de.makitama.pokerapp.ranking;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.rules.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Ranker {

    private final HashMap<HandRankings, Rule> rules = new HashMap<>();
    private final String equal = "Both hands are of equal worth";
    private final String firstHand = "First hand is winner!";
    private final String secondHand = "Second hand is winner!";

    public Ranker() {
        rules.put(HandRankings.HIGH_CARD, new HighCard());
        rules.put(HandRankings.PAIR, new Pair());
        rules.put(HandRankings.TWO_PAIRS, new TwoPairs());
        rules.put(HandRankings.THREE_OF_A_KIND, new ThreeOfAKind());
        rules.put(HandRankings.STRAIGHT, new Straight());
        rules.put(HandRankings.FLUSH, new Flush());
        rules.put(HandRankings.FULL_HOUSE, new FullHouse());
        rules.put(HandRankings.FOUR_OF_A_KIND, new FourOfAKind());
        rules.put(HandRankings.STRAIGHT_FLUSH, new StraightFlush());
    }

    /**
     * Please ensure that the following requirements are fulfilled:
     * list is sorted in ascending order of values,
     * list has the size of 5,
     * list is not null,
     * list is not empty,
     *
     * @param hand1 the first pokerhand that should be compared
     * @param hand2 the second pokerhand that should be compared
     * @return String with the chosen winner of the two hand arguments
     */
    public String chooseWinner(List<Card> hand1, List<Card> hand2) {
        int winner = compareTwoHands(hand1, hand2);
        return (winner == 0 ? equal : (winner == 1 ? firstHand : secondHand));
    }


    public int compareTwoHands(List<Card> hand1, List<Card> hand2) {
        checkRequirements(hand1);
        checkRequirements(hand2);

        Rank rankHand1 = rankHand(hand1);
        Rank rankHand2 = rankHand(hand2);

        return rankHand1.compareTo(rankHand2);
    }

    /**
     * @param hand hand that should be ranked
     * @return the highest possible Ranking for this specific hand of Cards, by applying the highest Rule that is possible.
     */
    public Rank rankHand(List<Card> hand) {

        // @formatter:off
        return Arrays.stream(HandRankings.values())
                .map(hr -> rules.get(hr).rank(hand))
                .flatMap(Optional::stream)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Something went terribly wrong. No Rule could be applied!"));
        // @formatter:on
    }

    private void checkRequirements(List<Card> hand) {
        if (hand == null || hand.isEmpty() || hand.size() != 5 || isUnsorted(hand)) {
            throw new IllegalArgumentException("One List is invalid. Please ensure that all prerequirements are fulfilled.");
        }
    }

    private boolean isUnsorted(List<Card> hand) {
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i - 1).getValue().getRating() > hand.get(i).getValue().getRating()) {
                return true;
            }
        }

        return false;
    }

}
