package de.makitama.pokerapp.ranking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rank {

    private final Ranks type;
    private final List<Integer> ratings = new ArrayList<>();

    public static class RankBuilder {
        private final Ranks type;
        private final List<Integer> ratings = new ArrayList<>();

        public RankBuilder(Ranks type) {
            this.type = type;
        }

        public RankBuilder addRating(int rating) {
            ratings.add(rating);
            return this;
        }

        public Rank build() {
            return new Rank (this);
        }
    }

    private Rank (RankBuilder rankBuilder) {
        this.type = rankBuilder.type;
        this.ratings.addAll(rankBuilder.ratings);
    }

    public static RankBuilder initiateRankingFor(Ranks type) {
        return new RankBuilder(type);
    }

    /**
     *
     * @param rank - The Rank to be compared
     * @return   0 => both Ranks are equal
     *           1 => this object is ranked higher (aka is Winner)
     *          -1 => argument Rank is ranked higher (aka is Winner)
     */
    public int compareTo(Rank rank) {
        int winnerOfType = compareRanks(rank);
        if(winnerOfType == 0) {
            return compareValues(rank);
        }
        return winnerOfType;
    }

    public int compareRanks(Rank rank) {
        return this.type.compareTo(rank.type);
    }

    public int compareValues(Rank rank) {
        Iterator<Integer> thisIterater = this.ratings.iterator();
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

}
