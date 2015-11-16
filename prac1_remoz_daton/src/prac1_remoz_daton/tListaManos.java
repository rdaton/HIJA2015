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
 * @author barfelix
 */
public class tListaManos {
    private List<tMano> _listaManos;
    
    public tListaManos(List<String> listaManos)
    {
        _listaManos=null;
        if (listaManos!=null) 
        {
            _listaManos=new ArrayList<>();
            for (int i=0;i<listaManos.size();i++)
            {
                tListaCartas unaListaCartas=new tListaCartas(listaManos.get(i));
                tMano unaMano=new tMano (unaListaCartas.dameCartas());               
                _listaManos.add(unaMano);
            }
        }
                
    }
    
    public String toString()
    {
        StringBuffer unBuffer=new StringBuffer();
        
        for (int i=0;i<_listaManos.size();i++)
        {
            unBuffer.append(_listaManos.get(i));
            unBuffer.append("\n");
        }
        
        return unBuffer.toString();
    }
    
}
