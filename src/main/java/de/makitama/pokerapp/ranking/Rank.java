package de.makitama.pokerapp.ranking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rank {

    private final HandRankings type;

    private final List<Integer> ratings;

    private Rank(RankBuilder rankBuilder) {
        this.type = rankBuilder.type;
        this.ratings = List.copyOf(rankBuilder.ratings);
    }

    public static RankBuilder initiateRankingFor(HandRankings type) {
        return new RankBuilder(type);
    }

    /**
     * @param rank The Rank to be compared
     * @return 0 => both Ranks are equal;
     * 1 => this object is ranked higher (aka is Winner);
     * -1 => argument Rank is ranked higher (aka is Winner)
     */
    public int compareTo(Rank rank) {
        int winnerOfType = compareRanks(rank);
        if (winnerOfType == 0) {
            return compareValues(rank);
        }
        return winnerOfType;
    }

    public int compareRanks(Rank rank) {
        return Integer.compare(type.getRating(), rank.type.getRating());
    }

    private int compareValues(Rank rank) {
        Iterator<Integer> thisIterater = ratings.iterator();
        Iterator<Integer> argumentIterater = rank.ratings.iterator();

        while (thisIterater.hasNext()) {
            if (!argumentIterater.hasNext()) {
                throw new IllegalArgumentException("List of ratings of 'Other Rank' (" + rank + ") is smaller than this List");
            }
            Integer v1 = thisIterater.next();
            Integer v2 = argumentIterater.next();

            int winner = v1.compareTo(v2);
            if (winner != 0) {
                return winner;
            }
        }
        return 0;
    }

    public HandRankings getType() {
        return type;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public static class RankBuilder {
        private final HandRankings type;
        private final List<Integer> ratings = new ArrayList<>();

        public RankBuilder(HandRankings type) {
            this.type = type;
        }

        public RankBuilder addRating(int rating) {
            ratings.add(rating);
            return this;
        }

        public Rank build() {
            return new Rank(this);
        }
    }
}
