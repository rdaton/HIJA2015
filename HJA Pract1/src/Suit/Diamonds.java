package Suit;

public class Diamonds extends Suit{
		
	public String toString () {
		return "d";
	}

	public static Suit parseSuit(String a) {
		Suit suit = null;
		if (a=="d") {
                suit = new Diamonds();
                return suit;        }
                return suit;
		}

	public String NombreString() {
		// TODO Auto-generated method stub
		return "Diamonds";
	}

}
