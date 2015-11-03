package Cards.Card;

public class King extends NumberCard{
	
	private int value = 13;
		
	public String getString() {
			return "13";
	}
		
	public String toString() {
			return "King";
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
				number = new King();
	        }
			return number;
	}

}