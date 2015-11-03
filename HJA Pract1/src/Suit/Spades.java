package Suit;

public class Spades extends Suit{
	
	public  String toString () {
		return "s";
	}

	public static Suit parseSuit(String a) {
		Suit suit = null;
		if (a=="s") {
                suit = new Spades();
                return suit;        
                }
                return suit;
		}

	public String NombreString() {
		// TODO Auto-generated method stub
		return "Spades";
	}

}
