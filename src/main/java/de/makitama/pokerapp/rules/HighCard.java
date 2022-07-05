package de.makitama.pokerapp.rules;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import de.makitama.pokerapp.cards.Card;
import de.makitama.pokerapp.ranking.HandRankings;
import de.makitama.pokerapp.ranking.Rank;

/**
 * Hands which do not fit any higher category are ranked by the value of their highest card.
 * If the highest cards have the same value, the hands are ranked by the next highest, and so on.
 */
public class HighCard implements Rule{

	private final HandRankings handRanking = HandRankings.HIGH_CARD;


	public static Card getHighestCard(List<Card> hand) {
		Optional<Card> card = hand.stream().max(Comparator.comparing(Card::getValue));
		return (card.orElse(null));
	}

	@Override
	public Optional<Rank> rank(List<Card> hand) {
		Rank.RankBuilder rankBuilder = Rank.initiateRankingFor(handRanking);
		Collections.reverse(hand);
		hand.forEach(card -> rankBuilder.addRating(card.getValue().getRating()));

		return Optional.of(rankBuilder.build());
	}

}