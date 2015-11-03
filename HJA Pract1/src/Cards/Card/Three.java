package Cards.Card;


public class Three extends NumberCard{
	
	private int value = 3;
	
	public String getString() {
		return "Three";
	}
	
	public String toString() {
		return "3";
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
			number = new Three();
		}
		return number;
	}

}