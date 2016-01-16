/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author user1
 */
public class tTupla 
{
    List<tParejaCartas> listaParejas;
    
    public tTupla()
    {
        listaParejas=new ArrayList();        
    }
    
    tParejaCartas get(int i)
    {
        return listaParejas.get(i);
    }
    
    void add (tParejaCartas unaPareja)
    {
        listaParejas.add(unaPareja);
    }
    
    void addAll (tTupla unaTupla)
    {
        Iterator<tParejaCartas> unIterador= unaTupla.iterator();
        while (unIterador.hasNext())
            listaParejas.add(unIterador.next());
    }
    
    int size()
    {
        return listaParejas.size();
            
    }
    
    void clear()
    {
        listaParejas.clear();
    }
    
    Iterator iterator()
    {
        return listaParejas.iterator();
    }
   }