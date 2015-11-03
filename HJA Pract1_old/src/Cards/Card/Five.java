package Cards.Card;

public class Five extends NumberCard{
	
	private int value = 5;
		
	public String getString() {
			return "5";
	}
		
	public String toString() {
			return "Five";
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
				number = new Five();
	        }
			return number;
	}

}