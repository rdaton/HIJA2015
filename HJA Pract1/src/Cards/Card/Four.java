package Cards.Card;


public class Four extends NumberCard{
		
	private int value = 4;
		
	public String getString() {
			return "4";
	}
		
	public String toString() {
			return "Four";
	}

	public void setValue(int i) {
this.value = i;	}

	public int getValue() {
			return value;
	}

	public NumberCard parseNumber(String cadena) {
			NumberCard number = null;
			if(cadena.equalsIgnoreCase(this.toString())) {
				number = new Four();
	        }
			return number;
	}

}


