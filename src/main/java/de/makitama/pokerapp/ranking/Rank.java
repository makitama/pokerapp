package de.makitama.pokerapp.ranking;

import java.util.ArrayList;
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

}
