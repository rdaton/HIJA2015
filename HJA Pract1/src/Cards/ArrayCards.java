package Cards;

import Suit.*;
import static Suit.Hearts.parseSuit;
import java.util.ArrayList;




public class ArrayCards {
	
	private  ArrayList <Hands> cartas;
	
        public ArrayCards(String unaJugada)
        {
            cartas=new ArrayList<>();
            int Number=0;
            Suit suit=new Suit();
            for (int i=0;i<unaJugada.length()-1;i+=2)
            {
                switch (unaJugada.charAt(0))
                {
                    case 'A': Number= 14; break;
                    case 'K': Number= 13;break;
                    case 'Q': Number=12; break;
                    case 'J': Number=11;break;
                    case 'T': Number=10; break;
                    case '9': Number=9; break;
                    case '8': Number=8; break;
                    case '7': Number=7; break;
                    case '6': Number=6; break;
                    case '5': Number=5; break;
                    case '4': Number=4; break;
                    case '3': Number=3; break;
                    case '2': Number=2; break;
                  }
                
                switch (unaJugada.toLowerCase().charAt(1))
                {
                    case 'h': suit= Hearts.parseSuit("h"); break;
                    case 'd': suit= Diamonds.parseSuit("d"); break;
                    case 'c': suit= Clubs.parseSuit("c"); break;
                    case 's': suit= Spades.parseSuit("s"); break;
                                }
                Hands unaCarta=(new Hands(Number,suit));
                
                cartas.add(unaCarta);
                
            }
        }
	public ArrayCards () {
		cartas = new ArrayList<Hands>();
	}
	
	public void addCards(Hands hand) {
		cartas.add(hand);
	}
	
	public int getCardsize () {
		return cartas.size();
	}
	
	public void removeCards (int i) {
		cartas.remove(i);
	}
	
	public Hands getCard(int i) {
        return cartas.get(i);
    }
	
	public void ordenar () {
	        for(int i=1;i < cartas.size();i++){  
	            for (int j=0 ; j < cartas.size() - 1; j++){  
	                if (cartas.get(j).getNumber() > cartas.get(j+1).getNumber()){ 
	                	Hands hands = cartas.get(j + 1);
	                	cartas.remove(j + 1);
	                	cartas.add(j + 1, cartas.get(j));
	                	cartas.remove(j);
	                	cartas.add(j, hands);
	                }  
	            }
	            }  
	}
	
	public boolean CartasRepetidas () {
		
		for (int i = 0; i < cartas.size(); i++) {
			for ( int j = 1 ; j < cartas.size(); j++) {

				if(Integer.toString(cartas.get(i).getNumber()).equals(Integer.toString(cartas.get(j).getNumber()))) {
					/*System.out.println(Integer.toString(cartas.get(i).getNumber()));
					System.out.println(Integer.toString(cartas.get(j).getNumber()));*/
					
					if(cartas.get(i).getPalo().toString().equals(cartas.get(j).getPalo().toString())) {
						return true;
					}
				}
				
			}
		}
		return false;
	}


}
