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

public class tBaraja 
{
    private char[]  _posiblesRangos;
    private char[]  _posiblesPalos;
    private tCarta[] _listaCartas;

    private void rellenaBaraja()
    {
        for (int i=0;i<_posiblesRangos.length;i++)
            for (int j=0;j<_posiblesPalos.length;j++)
                _listaCartas[i*j]=new tCarta(_posiblesRangos[i],_posiblesPalos[j]);
    }
    
    public tBaraja()
    {
            _posiblesPalos= tPalo.enumPalo.toArrayChar();
            _posiblesRangos=tRango.enumRango.toArrayChar();
            _listaCartas=new tCarta[_posiblesRangos.length*_posiblesPalos.length];
            rellenaBaraja();
    }

    public boolean equals (Object unObjeto)
    {
        if (unObjeto==null) return false;
        if (!(unObjeto instanceof tBaraja)) return false;
        
        //java usa punteros ... la asignación de abajo es solo de punteros
        boolean enc=this._listaCartas.length==((tBaraja) unObjeto)._listaCartas.length;
        int i=0;
        while (enc && i<this._listaCartas.length)
            {
            enc=this._listaCartas[i]==((tBaraja) unObjeto)._listaCartas[i];
            i++;
            };
        return enc;
    }
    
    public int size()
    {
        return this._listaCartas.length;
    }
    
    public tCarta get(int i)
    {
        return _listaCartas[i];
    }
    public String toString ()
    {
        StringBuffer unString=new StringBuffer();
        for (int i=0;i<_listaCartas.length;i++)
            unString.append(_listaCartas[i].toString());
        
        return unString.toString();
    }
    
    

}