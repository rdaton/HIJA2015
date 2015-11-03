package Suit;

public class Hearts extends Suit{
	
	public String toString () {
		return "h";
	}

	public static Suit parseSuit(String a) {
		Suit suit = null;
		if (a=="h") {
                suit = new Hearts();
                return suit;        
                }
                return suit;
		}

	public String NombreString() {
		// TODO Auto-generated method stub
		return "Hearts";
	}

}

