package Cards.Card;

public class Seven extends NumberCard{
	
	private int value = 7;
		
	public String getString() {
			return "7";
	}
		
	public String toString() {
			return "Seven";
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
				number = new Seven();
	        }
			return number;
	}

}
