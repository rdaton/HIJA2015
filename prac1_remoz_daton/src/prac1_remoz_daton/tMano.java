/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac1_remoz_daton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daton
 */
public class tMano 
{   
    enum enumManos {ESCALERA_REAL,ESCALERA_COLOR,POKER,FULL,COLOR,ESCALERA,
                    TRIO,DOBLE_PAREJA,PAREJA,CARTA_ALTA;}
        
    //cartas representante de la mano
    List<tCarta> _cartasRep;
    //lista de cartas: 5 como mucho.. tal como dictan las reglas del poker
    private tCarta[] _listaCartas ;
    enumManos _tipoMano;
        
    public tMano(List<tCarta> listaCartas)
    {
        _listaCartas=new tCarta[5];
        //ojo... hay que calsificar la mano
        //y habría que rellenar bien la lista de cartas representantes
        //PENDIENTE
        _tipoMano=enumManos.ESCALERA_REAL;
        _cartasRep=new ArrayList<>();
        for (int i=0;i<5;i++)
        {
            this._listaCartas[i]=listaCartas.get(i);
            _cartasRep.add(listaCartas.get(i));
        }
    }
    //   este orden no es suficiente.
    //falta poner un orden inerno entre
    //manos que tinen un toInt igual.
    //¡ PENDIENTE !!!
    public int toInt()
    {
        int unLong=enumManos.values().length;
        switch (_tipoMano)
        {
            case ESCALERA_REAL: return unLong;
            case ESCALERA_COLOR: return unLong-1;
            case POKER: return  unLong-2;
            case FULL: return unLong-3;
            case COLOR: return unLong-4;
            case ESCALERA: return unLong-5;
            case TRIO: return unLong-6;
            case DOBLE_PAREJA: return unLong-7;
            case PAREJA: return unLong-8;
            case CARTA_ALTA: return unLong-9;
            default: return -1;
        }
    }
    
    public boolean equals (Object unObjeto)
    {
        if (unObjeto==null) return false;
        if (!(unObjeto instanceof tMano)) return false;
        if (((tMano)unObjeto)._tipoMano!=this._tipoMano) return false;
        boolean enc = (this._listaCartas.length == ((tMano) unObjeto)._listaCartas.length);
        int i=0;
        //¡COMPLETAR! esta parte hay que rehacerla
        while (enc && i<this._listaCartas.length)
        {
            enc=((tMano) unObjeto)._listaCartas[i].equals(this._listaCartas[i]);
        }
        return enc;
    }
    
    public String toString()
    {
        StringBuffer unBuffer=new StringBuffer();
        for (int i=0;i<5;i++)
            unBuffer.append(this._listaCartas[i].toString());    
        
        String unString="";
        switch (_tipoMano)
        {
            case ESCALERA_REAL: unString=" Escalera Real"; break;
            case ESCALERA_COLOR: unString=" Escalera de Color";break;
            case POKER: unString=" Poker";break;
            case FULL: unString=" Full";break;
            case COLOR: unString=" Color";break;
            case ESCALERA: unString=" Escalera";break;
            case TRIO: unString=" Trio";break;
            case DOBLE_PAREJA: unString=" Doble Pareja";break;
            case PAREJA: unString=" Pareja";break;
            case CARTA_ALTA: unString=" Carta Alta";break;
            default: unString="";
        }
        unBuffer.append(unString);
        
        StringBuffer otroBuffer=new StringBuffer().append(" de ");
        switch (_tipoMano)
        {
            case ESCALERA_REAL: otroBuffer.append(_cartasRep.get(0).damePalo().toString()); break;
            case ESCALERA_COLOR: otroBuffer.append(_cartasRep.get(0).damePalo().toString());break;
            case POKER: otroBuffer.append(_cartasRep.get(0).dameRango().toString());break;
            case FULL: otroBuffer.append(_cartasRep.get(0).dameRango().toString()).append
                            (" y de ").append(_cartasRep.get(3).dameRango().toString());break;
            case COLOR: otroBuffer.append(_cartasRep.get(0).damePalo().toString());break;
            case ESCALERA: otroBuffer.append(_cartasRep.get(0).dameRango().toString());break;
            case TRIO: otroBuffer.append(_cartasRep.get(0).dameRango().toString());break;
            case DOBLE_PAREJA: otroBuffer.append(_cartasRep.get(0).dameRango().toString()).append
                            (" y de ").append(_cartasRep.get(3).dameRango().toString());break;
            case PAREJA: otroBuffer.append(_cartasRep.get(0).dameRango().toString());break;
            case CARTA_ALTA: otroBuffer.append(_cartasRep.get(0).dameRango().toString());break;
            default: ;
        }
        unBuffer.append(otroBuffer);
        
        return unBuffer.toString();
    }
    
}
