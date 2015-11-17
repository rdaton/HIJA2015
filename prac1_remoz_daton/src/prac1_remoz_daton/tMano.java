/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac1_remoz_daton;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Daton
 */
public class tMano 
{   
    enum enumManos {ESCALERA_REAL,ESCALERA_COLOR,POKER,FULL,COLOR,ESCALERA,
                    TRIO,DOBLE_PAREJA,PAREJA,CARTA_ALTA;}        
    
    //lista de cartas: 5 como mucho.. tal como dictan las reglas del poker
    private List<tCarta> _listaCartas ;
    //cartas representante de la mano (lo estrictamente minimo)
    private List<tCarta> _cartasRep;
    //la primera mano de mayor Rango (sin contar el palo)
    tCarta  _cartaMax;
    enumManos _tipoMano;
    tBaraja _Baraja;     
    public tMano(List<tCarta> listaCartas)
    {
        _Baraja=new tBaraja();
        _cartaMax=listaCartas.get(0);
        _cartasRep=new ArrayList<>();
        _listaCartas=new ArrayList<>();        
        for (int i=0;i<5;i++)
        {
            this._listaCartas.add(listaCartas.get(i));           
        }
        analizar();
    }
    //peso de la mano
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
        boolean enc = (this._listaCartas.size() == ((tMano) unObjeto)._listaCartas.size());
        int i=0;
        //¡COMPLETAR! esta parte hay que rehacerla
        while (enc && i<this._listaCartas.size())
        {
            enc=((tMano) unObjeto)._listaCartas.get(i).equals(this._listaCartas.get(i));
        }
        return enc;
    }
    
    public String toString()
    {
        StringBuffer unBuffer=new StringBuffer();
        for (int i=0;i<5;i++)
            unBuffer.append(this._listaCartas.get(i).toString());    
        
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
                            (" y de ").append(_cartasRep.get(1).dameRango().toString());break;
            case COLOR: otroBuffer.append(_cartasRep.get(0).damePalo().toString());break;
            case ESCALERA: otroBuffer.append(_cartasRep.get(0).dameRango().toString());break;
            case TRIO: otroBuffer.append(_cartasRep.get(0).dameRango().toString());break;
            case DOBLE_PAREJA: otroBuffer.append(_cartasRep.get(0).dameRango().toString()).append
                            (" y de ").append(_cartasRep.get(1).dameRango().toString());break;
            case PAREJA: otroBuffer.append(_cartasRep.get(0).dameRango().toString());break;
            case CARTA_ALTA: otroBuffer.append(_cartaMax.dameRango().toString());break;
            default: ;
        }
        unBuffer.append(otroBuffer);
        
        return unBuffer.toString();
    }
    
    //inspirado en  http://rosettacode.org/wiki/Poker_hand_analyser
    private void analizar()
    {
        
        _cartasRep.clear() ;
        
        
        int nRangos=tRango.enumRango.toArrayChar().length;
        int[] contadorRangos=new int[nRangos];
        for (int i=0; i<nRangos;i++) contadorRangos[i]=0;
        long contadorEscalera =0;
        boolean esEscalera=false;
        long contadorColor=0;
        boolean esColor=false;
        int total=0;        
        
        //parseo las cinco cartas y las reflejo en 
        //contadores y estructuras
        for (int i=0;i<_listaCartas.size();i++)
        {
            tCarta unaCarta=_listaCartas.get(i);
            if (unaCarta.dameRango().toInt() > _cartaMax.dameRango().toInt())
                _cartaMax=unaCarta;
            tRango unRango=unaCarta.dameRango();            
            contadorRangos[unRango.toInt()]++;
            
            contadorEscalera |= (1<<unRango.toInt());
            //¿son todas las cartas del mismo color?
            contadorColor |= (1 << unaCarta.damePalo().toString().toCharArray()[0]);
        }
        
        //desplazar  los bits lo más a la derecha posible
        while (contadorEscalera %2 == 0 )
            contadorEscalera >>=1;
        
        //escalera real, o escalera con un As es 00011111 ; 
        //A-2-3-4-5 es 1111000000001
         esEscalera=  (contadorEscalera == 0b11111) || 
                 (contadorEscalera==0b1111000000001);
        
        // unsets right-most 1-bit, which may be the only one set
        //¿?deshabilita el bit que vale 1,  de más a la derecha, que debe de ser el único activado??
        esColor= (contadorColor & (contadorColor - 1)) == 0;
        
        if (esColor && esEscalera)
        {
            this._tipoMano=enumManos.ESCALERA_REAL;
            _cartasRep.add(_listaCartas.get(0));
            return;
        }
        //evaluo todo lo que sea menor que escalera..
        //construyendo _cartasRep.
        //ojo, que en multiples cartas no nos interesan los colores.
        Integer otroRango=null;
        tCarta unaCarta=null;        
        for (int i=0;i<nRangos;i++)
        {            
            //Daton .. uff... tengo que crear una carta con su rango..
            //por el momento creo una carta con mismo rango, pero todos con corazón
            otroRango=i;
            unaCarta=new tCarta(tRango.enumRango.toArrayChar()[i],'h');
            if (contadorRangos[i]==4) 
            {
                this._tipoMano=enumManos.POKER;                  
                _cartasRep.add(unaCarta);
                return;
            }
            
            if (contadorRangos[i]==3)
            {
                _cartasRep.add(unaCarta);
                total+=3;
            }
            else if (contadorRangos[i]==2)
            {
               _cartasRep.add(unaCarta);
                total+=2;   
            }           
            
        }    
            
            
        if (total==5)
            {
                this._tipoMano=enumManos.FULL;
                //_cartasRep ya rellenada durante el parseo                
                return;
            }   
         if (esColor)
         {
             this._tipoMano=enumManos.COLOR;
             //vacío _cartasRep y lo meto una carta
             _cartasRep.clear();
             _cartasRep.add(_listaCartas.get(0));
             return;
         }
         
         if (esEscalera)
         {
            this._tipoMano=enumManos.ESCALERA;            
            _cartasRep.add(_cartaMax);
            return;
         }
         
         if (total==3)
         {
             this._tipoMano=enumManos.TRIO;
             //_cartasRep ya rellenada durante el parseo
             return;
         }
         
         if (total==4)
         {
             this._tipoMano=enumManos.DOBLE_PAREJA;
             //_cartasRep ya rellenada durante el parseo
             return;
         }
         
         if (total==2)
         {
             this._tipoMano=enumManos.PAREJA;
             //_cartasRep ya rellenada durante el parseo
             return;
         }
         
        //e.o.c.. sólo nos queda carta alta
        //_cartasRep ya rellenada durante el parseo        
        _tipoMano=enumManos.CARTA_ALTA;
    
    }
    
    private void analizarConComodines(String unaCadenaMano)
    {
        /*
       //http://stackoverflow.com/questions/767759/occurrences-of-substring-in-a-string
        String unString="WW";
        int nComodines=StringUtils.countMatches(unaMano, unString);
        assert(nComodines>2);
                */
    }
    
    //clonador malo
    private tMano bitchBrian(List<tCarta> unaLista, tCarta unaCarta, int i)
    {
        return new tMano(unaLista);
    }
    
    
    //esta parte tiene complejidad cúbica.
    //es ridiculo.
    // ¡a mejorar!
    private tMano analizarConComodinesR(tMano unaMano, String unaCadenaMano,tMano mejorMano)
    {
        //caso Recursivo
        tCarta punteroBaraja=null;        
        for (int i=0;i<unaCadenaMano.length()-1;i=i+2)
        {
         if(unaCadenaMano.substring(i, i+2)=="ww")
                for (int j=0;j<_Baraja.size();j++)
                {
                    punteroBaraja=_Baraja.get(0);
                    if (!_listaCartas.contains(punteroBaraja))
                       mejorMano=bitchBrian(this._listaCartas,punteroBaraja,i/2);                                            
                }            
        };
        //caso base
        if (mejorMano==null||this.toInt()>mejorMano.toInt()) 
            return this;
        else
            return mejorMano;
    }
}
