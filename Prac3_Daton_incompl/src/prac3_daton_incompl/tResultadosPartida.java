package prac3_daton_incompl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario_local
 */
public class tResultadosPartida {
    //almacena de  cada tipo de mano, cuántos jugadores la han ganado    
    Hashtable <Integer,List<Integer>> puntuaciones;
    int jugadaMaxima;    
    final static int posiblesJugadas=10;
    //existen 
    public tResultadosPartida ()
    {
        jugadaMaxima=-1;
        puntuaciones=new Hashtable();
    }
    
    void ponResultado(int valor, int idJugador)
    {        
        //sólo creo listas de jugadores para manos que 
        //se hayan producido, vaya
        if (valor>jugadaMaxima)
        {
            jugadaMaxima=valor;
            List<Integer> unaLista=new ArrayList();
            unaLista.add(valor);
            puntuaciones.put(valor,unaLista);            
        }
        //sólo me molesto en almacenar jugadas mayores que la jugada máxima
        else if (valor==jugadaMaxima)
        {
            puntuaciones.get(valor).add(idJugador);            
        };
        //e.o.c, no hago nada
    }
    
    List<Integer> dameGanadores ()
    {
        return puntuaciones.get(jugadaMaxima);
    }
    
    
}
