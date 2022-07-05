package de.makitama.pokerapp.ranking;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.rules.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Ranker {

    public final HashMap<HandRankings, Rule> rules = new HashMap<>();

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

    public String chooseWinnerOfTwoHands(List<Card> hand1, List<Card> hand2) {
        Rank rankHand1 = rankHand(hand1);
        Rank rankHand2 = rankHand(hand2);

        int winner = rankHand1.compareTo(rankHand2);
        String equal = "Both Hands are of equal worth";
        String firstHand = "First hand is winner! " + hand1.toString() + ", with Rank: " + rankHand1.getType();
        String secondHand = "Second hand is winner! " + hand2.toString() + ", with Rank: " + rankHand2.getType();
        return (winner == 0 ? equal : (winner == 1 ? firstHand : secondHand));
    }

    /**
     * @param hand hand that should be ranked
     * @return the highest possible Ranking for this specific hand of Cards, by applying the highest Rule that is possible.
     */
    private Rank rankHand(List<Card> hand) {

        Ranker ranker = new Ranker();
        HandRankings[] values = HandRankings.values();
        for (int i = values.length - 1; i >= 0; i--) {
            Optional<Rank> rank = ranker.rules.get(values[i]).rank(hand);
            if (rank.isPresent()) {
                return rank.get();
            }
        }
        throw new IllegalArgumentException("Something went terribly wrong. No Rule could be applied!");
    }


}
