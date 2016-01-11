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
 * @author barfelix
 */
//la clase simulador se dedica a simular partidas
//voy a suponer
public class tSimuladorOmaha {
    private int[] jugadoresActivos;   
    private long[] puntos ;
    private long totalPuntos;
    private double[] porcentajes;
    private tCarta[] tablero;
    private int longTablero;
    private final int maxTablero=5; 
    private final int maxTableroUsable=3;
    static int dosMillones=20000;
    //el constructor lee la baraja ... almacena las cartas
    //deduce el numero de jugadores, tablero, etc
    public tSimuladorOmaha()
    {
        init();        
    }
    
    //consulto a la baraja, si tiene algun tablero pre-existente
    void parseaTablero ()
    {
        int i=0;
        tablero=new tCarta[maxTablero];
        List<tCarta> unTablero=tBaraja.getInstance().dameTablero();
        if (unTablero!=null){
            Iterator<tCarta> unIterador=unTablero.iterator();
            while (unIterador.hasNext() && i<maxTablero)
            {
                tablero[i]=unIterador.next();
                i++;
            }        
            for (int r=i;r<maxTablero;r++)
            {
                tablero[r]=null;
            }
        }; //if (unTablero!=null)
        longTablero=i;
    }
    
    void parseaJugadoresActivos ()
    {
        jugadoresActivos=tBaraja.getInstance().dameJugadoresActivos();         
    }
    //jugador 10 son cartas negras; jugador 11 es tablero
    private boolean sentado (int i)
    {
        if (i>9) return false;
        return (jugadoresActivos[i]>1);
    }
    
    private void init() {
            
        parseaJugadoresActivos();
        
        puntos= new long[10];
        for (int i=0;i<10;i++) 
            puntos[i]=0; 
        
        porcentajes=new double[10];
        for (int i=0;i<10;i++) 
            porcentajes[i]=0;
                 
         parseaTablero();
    }
    
    
    tCarta[] generaTableroRandom (int ent)
    {
        tCarta[] tableroSup=new tCarta[ent];
        for (int i=0;i<ent;i++)
            tableroSup[i]=tBaraja.getInstance().dameCartaRandomTablero();
        return tableroSup;
    }
    
    void limpiaTableroRandom(tCarta[] tableroSup, int longTableroSup)
    {
        tCarta unaCarta=null;
        int r=0;
        int p=0;
        for (int i=0;i<longTableroSup;i++)
        {
            unaCarta=tableroSup[i];
            r=unaCarta.dameRango().toInt();
            p=unaCarta.damePalo().toInt();
            if (!tBaraja.getInstance().soltarCartaTablero(r, p))
                System.out.println("tablero: no he podido soltar " + unaCarta);
        };        
        
    }
    
    List<tCarta> generaTableroTrabajo(tCarta[] tableroSup,int longTableroSup)
    {        
        List<tCarta> unTableroTrabajo=new ArrayList();
        //meto las cartas del tablero fijo
        for (int i=0;i<longTablero;i++)
            unTableroTrabajo.add(tablero[i]);
        //meto las cartas del tablero random que me han pasado
        for (int i=longTablero;i<longTableroSup;i++)
            unTableroTrabajo.add(tableroSup[i]);        
        return unTableroTrabajo;
    }
    
    void calculaPorcentajes()
    {
        double unPorcentaje=0;
        double unPunto=0;
        for (int i=0;i<10;i++)
        {
            unPunto=puntos[i];
            unPorcentaje= unPunto/(double)totalPuntos;
            porcentajes[i]=(double)(unPorcentaje * 100);
        }
    }
    
    double damePorcentaje(int i)
    {
        return porcentajes[i];
    }
    void muchasPartidas()
    {
        for (int i=0;i<dosMillones;i++)
        {
            partida();
            totalPuntos++;            
        }
        calculaPorcentajes();
    }
    void partida ()
    {       
       //relleno las cartas que me faltan para el tablero
       //normalmente cinco como mucho
       int longTableroSup=maxTablero-longTablero;
       tCarta[] tableroSup=null;
       if (longTableroSup>0)
           tableroSup=generaTableroRandom(longTableroSup);
       
       //genero mi tablero de trabajo
       List<tCarta> unTableroTrabajo=generaTableroTrabajo(tableroSup,longTableroSup);
       
       //evaluo las mejores manos de  los jugadores
       List<tCarta> unaListaCartas=null;
       tMano unaMano=null;
       int valorMano=0;
       int maxMano=-1;
       int ganador1=-1;
       int ganador2=-1;
       for (int i=0;i<10;i++) 
       {
           if (sentado(i))
           {
           unaListaCartas=tBaraja.getInstance().dameCartasJugador(i);
           unaListaCartas.addAll(unTableroTrabajo);          
           //creo la mano que voy a evaluar y saco su valor
           unaMano=new tMano(unaListaCartas);
           valorMano=unaMano.toInt();        
           if (valorMano>maxMano)
           {
               maxMano=valorMano;
               ganador1=i;   
           }
           else if (valorMano==maxMano)
           {
               ganador2=i;
           }
           
               
           }
       }
       //victoria
       if (ganador1!=-1)
       {
       puntos[ganador1]++;
       //empate
       if (ganador2==ganador1)
            puntos[ganador2]++;
       };
       //suelto las cartas que usé como relleno del tablero
       limpiaTableroRandom(tableroSup,longTableroSup);       
    }

}