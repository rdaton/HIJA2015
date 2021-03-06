package part1;
 class tCartaPalo{
		

		    enum  tPalo { CLUB, DIAMOND, SPADE, HEART,NONE};
		    enum  tCarta{ A,K,Q,J,T,NINE,EIGHT,SEVEN,SIX,FIVE,FOUR,THREE,TWO,NONE}
		
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
			 case 'n': _palo=tPalo.NONE;break;
			 
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
			default: _carta=tCarta.NONE;break;
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
			default: return 0;
			}
			
		}
		 
		 public String damePalo()
			{
			 switch (_palo)
				{
				 case CLUB: return "CLUB";
				 case SPADE: return "SPADE";
				 case HEART: return "HEART";
				 case DIAMOND: return "DIAMOND";
				 default: return "NONE";
				}
			}
		 
		//overridden method, has to be exactly the same like the following
			public boolean equals(Object obj) {
				if (!(obj instanceof tCartaPalo))
					return false;	
				if (obj == this)
					return true;
				//comparo por valor
				if (this._carta==((tCartaPalo)obj)._carta) 
					//palo 'NONE', que es palo genérico
				{
					if  (((tCartaPalo)obj)._palo==tPalo.NONE) return true;
					else 
					if (this._palo ==((tCartaPalo)obj)._palo) return true;
				}
				
				//comparo por palo
				else if (this._palo==((tCartaPalo)obj)._palo)
					//carta 'NONE',que es una carta de valor generico
				{
					if  (((tCartaPalo)obj)._carta==tCarta.NONE) return true;
					else 
					if (this._carta ==((tCartaPalo)obj)._carta) return true;
				}
				
				return false;
			
			}
		 
			public int hashCode(){
				//hasheo el palo (previamente convertido a String)
				String unaCadena=dameValor()+damePalo();
				//visto en http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
				int un_hash = 7;
				for (int i = 0; i < unaCadena.length(); i++) {
				    un_hash = un_hash*31 + unaCadena.charAt(i);
				}
				return un_hash;//for simplicity reason
			}
		
	}
	

		
	
