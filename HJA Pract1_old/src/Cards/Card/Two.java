package Cards.Card;

public class Two extends NumberCard{
	
	private int value = 2;
	
	public String getString() {
		return "2";
	}
	
	public String toString() {
		return "Two";
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
			number = new Two();
		}
		return number;
	}

}
