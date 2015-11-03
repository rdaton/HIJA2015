package Cards.Card;

public class Jack extends NumberCard{
	
	private int value = 11;
		
	public String getString() {
			return "11";
	}
		
	public String toString() {
			return "Jack";
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
				number = new Jack();
	        }
			return number;
	}

}