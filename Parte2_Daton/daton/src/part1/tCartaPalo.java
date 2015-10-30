package part1;
 class tCartaPalo{
		

		    enum  tPalo { CLUB, DIAMOND, SPADE, HEART};
		    enum  tCarta{ A,K,Q,J,T,NINE,EIGHT,SEVEN,SIX,FIVE,FOUR,THREE,TWO}
		
		 tPalo _palo;
		 tCarta _carta;
		 
		 public tCartaPalo(char unaCarta, char unPalo)
		 {
			switch (unPalo)
			{
			 case 'c': _palo=tPalo.CLUB; break;
			 case 'd': _palo=tPalo.DIAMOND; break;
			 case 's': _palo=tPalo.SPADE; break;
			 case 'h': _palo=tPalo.HEART;break;
			 
			}
			
			switch (unaCarta)
			{
			case 'A': _carta=tCarta.A;break; 
			case 'K': _carta=tCarta.K;break; 
			case 'Q': _carta=tCarta.Q;break; 
			case 'J': _carta=tCarta.J;break; 
			case 'T': _carta=tCarta.T;break; 
			case '9': _carta=tCarta.NINE;break;
			case '8': _carta=tCarta.EIGHT;break;
			case '7': _carta=tCarta.SEVEN;break; 
			case '6': _carta=tCarta.SIX;break; 
			case '5': _carta=tCarta.FIVE;break; 
			case '4': _carta=tCarta.FOUR;break;
			case '3': _carta=tCarta.THREE;break;
			case '2': _carta=tCarta.TWO;break; 
		
			}
			
			 
			 	
		 }
		 
		 public int dameValor() 
		{
			switch(_carta)
			{
			case A: return 14; 
			case K: return 13; 
			case Q: return 12; 
			case J: return 11; 
			case T: return 10; 
			case NINE: return 9; 
			case EIGHT: return 8; 
			case SEVEN: return 7; 
			case SIX: return 6; 
			case FIVE: return 5; 
			case FOUR: return 4; 
			case THREE: return 3; 
			case TWO: return 2; 
			default: return -1;
			}
			
		}
		 
		 public String damePalo()
			{
			 switch (_palo)
				{
				 case CLUB: return "CLUB";
				 case SPADE: return "SPADE";
				 case HEART: return "HEART";
				 case DIAMOND: return "DIAOND";
				 default: return "";
				}
			}
		
	}
	

		
	