package Cards.Card;

public class Six extends NumberCard{
	
	private int value = 6;
		
	public String getString() {
			return "6";
	}
		
	public String toString() {
			return "Six";
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
				number = new Four();
	        }
			return number;
	}

}