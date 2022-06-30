package pokerapp;

public class Card {
	
	private CardSuit cardSuit;
	private CardValue value;
	
	
	public Card(CardSuit cardSuit, CardValue value) {
		this.cardSuit = cardSuit;
		this.value = value;
	}
	
	public CardSuit getCardSuit() {
		return cardSuit;
	}
	
	public CardValue getValue() {
		return value;
	}

}
