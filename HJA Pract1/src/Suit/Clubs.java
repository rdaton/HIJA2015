package Suit;

public class Clubs extends Suit{
	
	public String toString () {
		return "c";
	}

	public static Suit parseSuit(String a) {
		Suit suit = null;
		if (a=="c") {
                suit = new Clubs();
                return suit;        
                }
                return suit;
		}
		
	

	public static String NombreString() {
		// TODO Auto-generated method stub
		return "Clubs";
	}

}
