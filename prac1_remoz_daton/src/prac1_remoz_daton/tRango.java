/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prac1_remoz_daton;

/**
 *
 * @author Daton
 */
public class tRango {
    
    enum enumRango {A,K,Q,J,T,NUEVE,OCHO,SIETE,SEIS,CINCO,CUATRO,TRES,DOS;
                      
     public static char[] toArrayChar()
            {
            return new char[]{'A','K','Q','J','T','9','8','7','6','5','4','3','2'};
            }
    
    
    };
    private enumRango _rango;
    
    public tRango(char c)
    {
        switch (java.lang.Character.toLowerCase(c)) 
        {
            case 'a' : _rango=enumRango.A; break;
            case 'k' : _rango=enumRango.K; break;
            case 'q' : _rango=enumRango.Q; break;
            case 'j' : _rango=enumRango.J; break;        
            case 't' : _rango=enumRango.T; break;
            case '9' : _rango=enumRango.NUEVE; break;
            case '8' : _rango=enumRango.OCHO; break;
            case '7' : _rango=enumRango.SIETE; break;        
            case '6' : _rango=enumRango.SEIS; break;
            case '5' : _rango=enumRango.CINCO; break;     
            case '4' : _rango=enumRango.CUATRO; break;     
            case '3' : _rango=enumRango.TRES; break;     
            case '2' : _rango=enumRango.DOS; break;     
                
            default: _rango=null;
        }    
    }
    
    
   
    public boolean equals(Object unObjeto)
    {
        if (unObjeto==null) return false;
        return ((tRango) unObjeto)._rango==this._rango;
    }
    
    public String toString ()
    {
        switch (_rango)
        {
            case A: return "A";
            case K: return "K";
            case Q: return "Q";
            case J: return "J";
            case T: return "T";
            case NUEVE: return "9";
            case OCHO: return "8";
            case SIETE: return "7";
            case SEIS: return "6";
            case CINCO: return "5";
            case CUATRO: return "4";
            case TRES: return "3";
            case DOS: return "2";
            default: return null;
        }
    }
    
    public int toInt()
    {
        switch (_rango)
        {
            case A: return 14;
            case K: return 13;
            case Q: return 12;
            case J: return 11;
            case T: return 10;
            case NUEVE: return 9;
            case OCHO: return 8;
            case SIETE: return 7;
            case SEIS: return 6;
            case CINCO: return 5;
            case CUATRO: return 4;
            case TRES: return 3;
            case DOS: return 2;
            default: return -1;
        }
        
    }
    
}
