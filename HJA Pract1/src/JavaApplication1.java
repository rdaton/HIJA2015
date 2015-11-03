

public class JavaApplication1 {
    public enum nCard {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE };
    public enum sCard{HEART, DIAMOND, SPADE, CLUB};
    public enum plays{HIGHER, PAIR, TOAK, DPAIR, STRAIGHT, FLUSH, FULL, POKER, SFLUSH, RFLUSH}
    
    private final int PCARDS = 2;
    private final int CCARDS = 5;
    private final int FCARDS = PCARDS + CCARDS;
    
    public class Player{
        public class Hand{
            private plays play;
            
            public class Card{ 
            public nCard number;
            private sCard suit;
                public Card( ){}
                public nCard getNumber() {
                    return number;
                }

                public void setNumber(nCard number) {
                    this.number = number;
                }

                public sCard getSuit() {
                    return suit;
                }

                public void setSuit(sCard suit) {
                    this.suit = suit;
                }
            
            }
           
           
            private Card pCard[] = new Card[PCARDS];
            private Card cCard[] = new Card[CCARDS];
            private Card fCard[] = new Card[FCARDS];
           
            public void concatenateCards(Card cards1[], Card cards2[], Card fCards[]){
                int size = cards1.length + cards2.length;
                fCards = new Card[size];
                System.arraycopy(cards1, 0, fCards, 0, cards1.length);
                System.arraycopy(cards2, 0, fCards, cards1.length, cards2.length);
            }
           
            public Card[] delCard(int pos, Card cards[]){
               int n = cards.length;
               int j = 0;
               Card fCards[] = new Card[cards.length - 1];
               
               for(int i = pos; i < n; i++){
                    if(i != pos){
                        fCards[j] = cards[i];
                        j++;
                    }
               }
               
               return fCards;
            }
            
            void parity(Card Card[], Card pCard[], plays play){
                int mirror = 1;
                Card auxCard[] = new Card[Card.length];
                System.arraycopy(Card, 0, auxCard, 0, auxCard.length);
                
                for (int i = 0; i < auxCard.length; i++){
                    mirror = 0;
                    for (int j = 0; j < auxCard.length; j++){
                        if(auxCard[i] != auxCard[j] && auxCard[i].number == auxCard[j].number){
                            pCard[mirror - 1] = auxCard[j];
                            mirror++;
                            auxCard = delCard(j,auxCard);
                        }
                        auxCard = delCard(i, auxCard);
                    }
                }                
                
                switch(mirror){
                    case 2:
                        play = plays.PAIR;
                        break;
                    case 3:
                        play = plays.TOAK;
                        break;
                    case 4:
                        play = plays.POKER;
                }
            }
            
            void flush(Card Card[], Card pCard[], plays play){
                int suit = 0;
                Card auxCard[] = new Card[Card.length];
                for(int i = 0; i < auxCard.length && auxCard.length > 4; i++){
                    for(int j = 0; j < auxCard.length; j++){
                        if(auxCard[i] != auxCard[j] && auxCard[i].suit == auxCard[j].suit){
                            pCard[suit] = auxCard[j];
                            suit ++;
                            auxCard = delCard(j,auxCard);      
                        }
                    }
                    if(suit >= 5) play = plays.FLUSH;
                    else play = null;
                }
            }
            
            void straight(Card card[], Card pCard[], plays play){
                
            
            
            }
            
            boolean menor(int n1, int n2){
                if(n2 == 2) return n1 == 14;
                else return n1 < n2;
            }
        
        }
    }
    
   
    
    public static void main (String[ ] Args){
        
        }
} 


    

