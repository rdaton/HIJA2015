package Cards.Card;


public class As extends NumberCard{
	
	private int value = 14;
		
	public String getString() {
			return "14";
	}
		
	public String toString() {
			return "As";
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
				number = new As();
	        }
			return number;
	}

}