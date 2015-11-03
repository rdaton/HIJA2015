package Cards.Card;

public class Nine extends NumberCard{
	
	private int value = 9;
		
	public String getString() {
			return "9";
	}
		
	public String toString() {
			return "Nine";
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
				number = new Nine();
	        }
			return number;
	}

}