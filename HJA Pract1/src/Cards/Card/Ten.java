package Cards.Card;

public class Ten extends NumberCard{
	
	private int value = 10;
		
	public String getString() {
			return "10";
	}
		
	public String toString() {
			return "Ten";
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
				number = new Ten();
	        }
			return number;
	}

}