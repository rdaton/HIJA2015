package Cards;

import Suit.Spades;
import Suit.Diamonds;
import Suit.Suit;
import Cards.Card.As;
import Cards.Card.Five;
import Cards.Card.Four;
import Cards.Card.NumberCard;
import Cards.Card.Two;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayCards cartas = new ArrayCards();
		
			NumberCard cart = new Two();
			NumberCard cart1 = new As();
			NumberCard cart2 = new Four();
			
			Suit palo = new Diamonds();
			Suit palo1 = new Spades();
			
			Hands carta = new Hands(cart,palo);
			Hands carta1 = new Hands(cart1,palo1);
			Hands carta2 = new Hands(cart2,palo);
			
		
			cartas.addCards(carta);
			cartas.addCards(carta1);
			cartas.addCards(carta2);
			
			System.out.println(cartas.getCard(0));
			System.out.println(cartas.getCard(1));
			System.out.println(cartas.getCard(2));
			
			System.out.println(cartas.CartasRepetidas());
			
			cartas.ordenar();		
			System.out.println("-----------------------------------------------------");
			System.out.println(cartas.getCard(0));
			System.out.println(cartas.getCard(1));
			System.out.println(cartas.getCard(2));
			
	}

}
