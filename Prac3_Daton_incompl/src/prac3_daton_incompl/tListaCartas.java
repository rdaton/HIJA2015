/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daton
 */
public class tListaCartas {
    List<tCarta> _listaCartas;   
    
    private void init(String unString)
    {
          _listaCartas=new ArrayList<>();
                
        for (int i=0;i<unString.length()-1; i=i+2)
        {
            _listaCartas.add(new tCarta(unString.charAt(i),unString.charAt(i+1)));
        };        
       
    }
    public tListaCartas (String unString)
    {
      init(unString);
    }
    
     public tListaCartas ()
    {
        init("");
    }
    
    public tListaCartas(List<tCarta> listaCartas, int r)
    {
        _listaCartas=new ArrayList<>();
        
        for (int i=0;i<listaCartas.size();i++)
        {
            _listaCartas.add(listaCartas.get(i));
        }
    }
    
    public void add (tCarta unaCarta)
    {
        if (_listaCartas.size()<5)
            _listaCartas.add(unaCarta);
           
    }
    
    public tCarta get (int r)
    {
        return _listaCartas.get(r);
    }
    
    public boolean isEmpty()
    {
        return (_listaCartas.size()==0);
    }
    
    public int size()
    {
        return _listaCartas.size();
    }
    public List<tCarta> dameCartas()
    {
        return _listaCartas;
    }
    public void clear()
    {
        _listaCartas.clear();
    }
    public boolean contains(tCarta unaCarta)
    {
        return _listaCartas.contains(unaCarta);
    }    
    
    @Override
    public String toString()
    {
        StringBuffer unBuffer=new StringBuffer();
        for (int i=0;i<_listaCartas.size();i++ )
        {
            unBuffer.append(_listaCartas.get(i).toString());
        }
        return unBuffer.toString();
    }
    
}