/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author barfelix
 */
//la clase simulador se dedica a simular partidas
//voy a suponer
public class tSimulador {
    private int[] jugadoresActivos;   
    private long[] puntos ;
    private int[] porcentajes;
    private tCarta[] tablero;
    private int longTablero;
    private final int maxTablero=5;
    private int nJugadores;
    static int dosMillones=2000000;
    //el constructor lee la baraja ... almacena las cartas
    //deduce el numero de jugadores, tablero, etc
    public tSimulador()
    {
        init();        
    }
    
    //consulto la baraja,a  ver cuántas preexistentes de tablero hay
    void parseaTablero ()
    {
        tablero=new tCarta[maxTablero];
        List<tCarta> unTablero=tBaraja.getInstance().dameTablero();
        Iterator<tCarta> unIterador=unTablero.iterator();
        int i=0;
        
        while (unIterador.hasNext() && i<maxTablero)
        {
            tablero[i]=unIterador.next();
            i++;
        }        
        longTablero=i;
        
        for (int r=i;r<maxTablero;r++)
        {
            tablero[r]=null;
        }
    }
    
    void parseaJugadoresActivos ()
    {
        jugadoresActivos=tBaraja.getInstance().dameJugadoresActivos();         
    }
    
    private boolean sentado (int i)
    {
        return jugadoresActivos[i]>1;
    }
    
    private void init() {
            
        parseaJugadoresActivos();
        
        puntos= new long[10];
        for (int i=0;i<10;i++) 
            puntos[i]=0; 
        
        porcentajes=new int[10];
        for (int i=0;i<10;i++) 
            porcentajes[i]=0;
                 
         parseaTablero();
    }
    
    
    void generaTableroRandom
    void partida ()
    {       
       if (longTablero<maxTablero)
           generaTableroRandom();
       
       
    }

}
