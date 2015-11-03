package Cards.Card;

public class Eight extends NumberCard{
	
	private int value = 8;	
	public String getString() {
			return "8";
	}
		
	public String toString() {
			return "Eight";
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
				number = new Eight();
	        }
			return number;
	}

}
