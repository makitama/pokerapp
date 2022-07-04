package de.makitama.pokerapp.ranking;

public class Rank {
    private final Ranks type;

    private Rank (RankBuilder rankBuilder) {
        this.type = rankBuilder.type;
    }

    public static class RankBuilder {
        private final Ranks type;

        public RankBuilder(Ranks type) {
            this.type = type;
        }

        public Rank build() {
            return new Rank (this);
        }
    }

}
