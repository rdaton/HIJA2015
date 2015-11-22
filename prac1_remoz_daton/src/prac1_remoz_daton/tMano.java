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
    //lista de draws (dos cartas)
    private List<tMano> _listaDraws;
    //chapuza para no usar herencia... en fin ...
    boolean _esDraw;
    //la primera mano de mayor Rango (sin contar el palo)
    tCarta  _cartaMax;
    enumManos _tipoMano;
    tBaraja _Baraja;     
    public tMano(List<tCarta> listaCartas)
    {
        _esDraw=false;
        _listaDraws=null;
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
        
        if(!_esDraw)
            unBuffer.append(this.dameDraws());
        
        
        
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
    
    private void generarDraws ()
    {
        if(_esDraw) return;
        if (!_esDraw)
        {
            _listaDraws=new ArrayList<> ();
            analizarConComodines(_listaCartas.toString());
        }
    }
    
    tListaManos dameDraws()
    {
        //si no es una mano, sino un draw
        if (_esDraw)  return null;
        
        //si es una mano normal
        if (_listaDraws==null)            
            generarDraws();
        return new tListaManos (_listaDraws,0);

    }
    private void insertaDraw(tMano unDraw)
    {
        //listaDraw sólo tendrá dos elementos como mucho
        //si vacío
        if (_listaDraws.isEmpty()) _listaDraws.add(unDraw);
        //si un elemento
        else if (_listaDraws.size()==1)
        {
         //actualizo si mejor
            if  (unDraw.toInt()>_listaDraws.get(0).toInt())
                    _listaDraws.set(0, unDraw);
            else 
                    _listaDraws.add(unDraw);   
        }
        //si dos eleentos o más
        else if (_listaDraws.size()>1)
        {
            //actualizo si mejor
            if  (unDraw.toInt()>_listaDraws.get(0).toInt())
                    _listaDraws.set(0, unDraw);
            else if (unDraw.toInt()>_listaDraws.get(1).toInt())
                    _listaDraws.set(1, unDraw);
        }
              
    }
     
    
    /*
    Ah_Ac_2h_As_Ad

ww_ww_2h_As_Ad
Ah_ww_ww_As_Ad
Ah_Ac_ww_ww_Ad
Ah_Ac_2h_ww_ww

ww_Ac_ww_As_Ad
Ah_ww_2h_ww_Ad
Ah_Ac_ww_As_ww

ww_Ac_2h_ww_Ad
Ah_ww_2h_As_ww

ww_Ac_2h_As_ww
    */
    private String dameUnaCadenaDraw (int n)
    {
        String unString =_listaCartas.toString();
        
        switch(n)
        {
            case 0: unString=
                    new StringBuffer().append("wwww").append(unString.substring(7)).toString();
                break;            
            case 1: unString=
                    new StringBuffer().
                            append(unString.subSequence(0, 3)).
                            append("wwww").
                            append(unString.substring(11)).
                            toString();
                break;
            case 2: unString=
                    new StringBuffer().
                            append(unString.subSequence(0, 7)).
                            append("wwww").
                            append(unString.substring(15)).
                            toString();
                break;
                
            case 3: unString=
                    new StringBuffer().
                            append(unString.subSequence(0,11)).
                            append("wwww").
                            toString();
                break;
                
                
            case 4: unString=
                    new StringBuffer().
                            append("ww").
                            append(unString.subSequence(8,11)).
                            append("ww").
                            append(unString.substring(11)).
                            toString();
                break;
            
            case 5: unString=
                    new StringBuffer().                            
                            append(unString.subSequence(0,3)).
                            append("ww").
                            append(unString.subSequence(9,11)).
                            append("ww").
                            append(unString.substring(15)).
                            toString();
                break;   
                
            case 6: unString=
                    new StringBuffer().                            
                            append(unString.subSequence(0,7)).
                            append("ww").
                            append(unString.subSequence(13,15)).
                            append("ww").
                            toString();
                break;
            
            case 7:     
                   unString=
                    new StringBuffer().                            
                            append(unString.subSequence(0,3)).
                            append("ww").
                            append(unString.subSequence(13,15)).
                            append("ww").
                            append(unString.subSequence(17, 19))
                            .toString();       
                break;
                
            case 8:     
                   unString=
                    new StringBuffer().                            
                            append(unString.subSequence(0,7)).
                            append("ww").
                            append(unString.subSequence(13,15)).
                            append("ww")                            
                            .toString(); 
                break;
                
            case 9:     
                   unString=
                    new StringBuffer().                            
                            append("ww").
                            append(unString.subSequence(3,17)).                            
                            append("ww")                            
                            .toString();           
                break;
        }       
        
        return unString;
    }
    /*
       //http://stackoverflow.com/questions/767759/occurrences-of-substring-in-a-string
        String unString="WW";
        int nComodines=StringUtils.countMatches(unaMano, unString);
        assert(nComodines>2);        
        */
    private void analizarConComodines(String unaCadenaMano)
    {        
        //listaDraw sólo tendrá dos elementos
        _listaDraws.clear();
        //me hago un clon malo
        tMano unaMano=bitchBrian(_listaCartas,_listaCartas.get(0),0);
        unaMano._esDraw=true;
        

        unaMano._esDraw=false;

       //INCOMPLETO @Daton ....para optimizar, hago solo dos comparaciones
        for (int i=0;i<10;i++)
        {
        tMano unDraw=analizarConComodinesR(unaMano,dameUnaCadenaDraw(i), null);
        unDraw._esDraw=true;
        insertaDraw(unDraw); 
        }
        
    }
   
    //clonador malo.. para crear draws
    private tMano bitchBrian(List<tCarta> unaLista, tCarta unaCarta, int r)
    {
        List<tCarta> otraLista=new ArrayList<>();     
        for (int i=0;i<unaLista.size();i++)
        {
            if (i!=r) 
                otraLista.add(unaLista.get(i));
            else 
                otraLista.add(unaCarta);
        }
        tMano unaMano= new tMano(otraLista);
        unaMano._esDraw=true;
        return unaMano;
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
                for (int j=0;j<unaMano._Baraja.size();j++)
                {
                    punteroBaraja=unaMano._Baraja.get(j);
                    if (!unaMano._listaCartas.contains(punteroBaraja))
                       mejorMano=bitchBrian(unaMano._listaCartas,punteroBaraja,i/2);                                            
                }            
        };
        //caso base
        if (mejorMano==null||unaMano.toInt()>mejorMano.toInt()) 
            return unaMano;
        else
            return mejorMano;
    }
}
