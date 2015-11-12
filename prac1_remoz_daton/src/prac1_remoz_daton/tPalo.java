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
public class tPalo {
    
    enum enumPalo {DIAMANTE, PICA, CORAZON,TREBOL};
    private enumPalo _palo;
    
    public tPalo(char c)
    {
        switch (java.lang.Character.toLowerCase(c)) 
        {
            case 'd' : _palo=enumPalo.DIAMANTE; break;
            case 's' : _palo=enumPalo.PICA; break;
            case 'h' : _palo=enumPalo.CORAZON; break;
            case 'c' : _palo=enumPalo.TREBOL; break;        
            default: _palo=null;
        }    
    }
    
    public boolean equals(Object unObjeto)
    {
        if (unObjeto==null) return false;
        return ((tPalo) unObjeto)._palo==this._palo;
    }
    
    public String toString ()
    {
        switch (_palo)
        {
            case DIAMANTE: return "d";
            case PICA: return "s";
            case CORAZON: return "h";
            case TREBOL: return "c";
        }
    }
}
