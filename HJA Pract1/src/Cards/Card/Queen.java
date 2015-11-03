package Cards.Card;

public class Queen extends NumberCard{
	
	private int value = 12;
		
	public String getString() {
			return "12";
	}
		
	public String toString() {
			return "Queen";
	}

	public void setValue(int i) {
		this.value = i;
	}

	public int getValue() {
			return value;
	}

	public NumberCard parseNumber(String cadena) {
			NumberCard number = null;
			if(cadena.equalsIgnoreCase(this.toString())) {
				number = new Queen();
	        }
			return number;
	}

}