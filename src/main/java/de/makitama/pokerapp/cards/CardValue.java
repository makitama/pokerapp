package de.makitama.pokerapp.cards;

public enum CardValue {

	_2(1), 
	_3(2),
	_4(3),
	_5(4),
	_6(5),
	_7(6),
	_8(7),
	_9(8),
	_T(9),
	_J(10),
	_Q(11),
	_K(12),
	_A(13);
	
	public final int value;
	
	private CardValue (int value) {
		this.value = value;
	}
	
	public int getRating() {
		return value;
	}
	
}