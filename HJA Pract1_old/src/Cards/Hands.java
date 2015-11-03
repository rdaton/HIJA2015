package Cards;

import Cards.Card.*;
import Cards.Card.NumberCard;
import Suit.Suit;

public class Hands {
	
	private NumberCard mano;
	private Suit palo;
	
	public Hands(NumberCard mano, Suit palo) {
		
		this.mano = mano;
		this.palo = palo;
	}

    public Hands(int Number, Suit suit) {
       
        switch (Number)
                {
                    case 14:  mano=new As();  break;
                    case 13: mano=new King(); break;
                    case 12: mano=new Queen(); break;
                    case 11: mano=new Jack(); break;
                    case 10: mano=new Ten(); break;
                    case 9: mano=new Nine(); break;
                    case 8: mano=new Eight(); break;
                    case 7: mano=new Seven(); break;
                    case 6: mano=new Six(); break;
                    case 5: mano=new Five(); break;
                    case 4: mano=new Four(); break;
                    case 3: mano=new Three(); break;
                    case 2: mano=new Two(); break;
                  }
        palo=suit;
    }

	public NumberCard getMano() {
		return mano;
	}

	public void setMano(NumberCard mano) {
		this.mano = mano;
	}

	public Suit getPalo() {
		return palo;
	}

	public void setPalo(Suit palo) {
		this.palo = palo;
	}
	
	public String toString () {
		String cadena = "";
		cadena = cadena + mano + " - " + palo;
		return  cadena;
	}
	
	public int getNumber () {
		return mano.getValue();
	}
}
