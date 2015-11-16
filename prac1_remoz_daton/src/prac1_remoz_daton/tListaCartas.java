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
public class tListaCartas {
    List<tCarta> _listaCartas;
    tMano       _mano;
    
    public tListaCartas (String unString)
    {
        _listaCartas=new ArrayList<>();
                
        for (int i=0;i<unString.length()-1; i=i+2)
        {
            _listaCartas.add(new tCarta(unString.charAt(i),unString.charAt(i+1)));
        };
        
        _mano= new tMano((_listaCartas));
    }
    
    public List<tCarta> dameCartas()
    {
        return _listaCartas;
    }
    
    public tMano dameMano()
    {
        return _mano;
    }
}
