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
public class tCarta {
    
    private tPalo _palo;
    private tRango _rango;
    
    public tCarta(char r, char p)
    {
        _rango=new tRango(r);
        _palo=new tPalo(p);
    }
    
    public tRango dameRango()
    {
        return _rango;
    }
    
    public tPalo damePalo()
    {
        return _palo;
    }
    
    public boolean equals (Object unObjeto)
    {
     if (unObjeto==null) return false;
     if (!(unObjeto instanceof tPalo)) return false;
     return (this._palo.equals(((tCarta) unObjeto)._palo)
             &&
             
             this._rango.equals(((tCarta) unObjeto)._rango)
             
             );
    }
    
    public String toString()
    {
        return  //StringBuffer es thread-safe
                new StringBuffer().append(_rango.toString()).append(_palo.toString()).toString();
        
    }
    
    
            
}
