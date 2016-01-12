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
public class tSimulador {
    private int[] jugadoresActivos;   
    private long[] puntos ;
    private long totalPuntos;
    private double[] porcentajes;
    private tCarta[] tablero;
    private int longTablero;
    private final int maxTablero=5;    
    static int dosMillones=2000;
    //el constructor lee la baraja ... almacena las cartas
    //deduce el numero de jugadores, tablero, etc
    public tSimulador()
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
        //aquí tengo dos posibilidades
        //o trabajo con rangos, o trabajo 
        //con cartas sueltas (ya implementado mediante 
        //tBaraja
        
        for (int j=0;j<dosMillones;j++)
            {
                partidaCartasSueltas();

            }
            calculaPorcentajes();
            
        //si la baraja está llena, eso significa que estamos trabajando con 
            //rangos
   /*         
        String[] listasRangosVista=new String[10];
        String[][] listaIndividual=new String[999][];        
        int tam[]=new int[10];
        List <tCarta> listasCartas[]=new ArrayList[10];
        //leo las listas de rango de cada uno
        for (int i=0;i<10;i++)
        {
            listasRangosVista[i]=VentanaPrincipal._unosControladores[i].dameCsvMatrizRangos();
            listasCartas[i]=new ArrayList();
        }
        //hago una lista de las cadenas de rangos de cada uno
        for (int i=0;i<10;i++)
        {
            tam[i]=listasRangosVista[i].length();
            listaIndividual[i]=listasRangosVista[i].split(",");
        }
                    
        int acum=0;
        int r=0;
        for (int i=0;i<10;i++)
            
            while ((acum<tam[i]) && tam[i]>0 && r<tam[i])
            {
               switch (listaIndividual[i][r].length())
            {
            case 2:
                listasCartas[i]=tBaraja.getInstance().damePares(
                    new tCarta(listaIndividual[i][r].charAt(0),'h').dameRango().toInt(), i,1);
                break;
            
            case 3:
                if (listaIndividual[i][r].charAt(2)=='s')
                    listasCartas[i]=tBaraja.getInstance().dameCartasuited(
                            new tCarta(unRango.charAt(0),'h').dameRango().toInt(),
                            new tCarta(unRango.charAt(1),'h').dameRango().toInt(),
                            idJugador);
                else if (unRango.charAt(2)=='o')
                    unaListaCartas=tBaraja.getInstance().dameCartasOffSet(
                            new tCarta(unRango.charAt(0),'h').dameRango().toInt(),
                            new tCarta(unRango.charAt(1),'h').dameRango().toInt(),
                            idJugador);
                break;        
        };
            }*/
        
    }
    
    //solo almacena empate para dos jugadores
    //convertir en lista!!
    void partidaCartasSueltas ()
    {       
        tResultadosPartida unosResultados=new tResultadosPartida();
        List<Integer> listaGanadores=new ArrayList();
        
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
     
       for (int i=0;i<10;i++) 
       {
           if (sentado(i))
           {
           unaListaCartas=tBaraja.getInstance().dameCartasJugador(i);
           unaListaCartas.addAll(unTableroTrabajo);          
           //creo la mano que voy a evaluar y saco su valor
           unaMano=new tMano(unaListaCartas);
           unosResultados.ponResultado(unaMano.toInt(),i);
           }
       }
        
       Iterator<Integer> unIterador=unosResultados.dameGanadores().iterator();
       while (unIterador.hasNext())
           puntos[unIterador.next()]++;
       //suelto las cartas que usé como relleno del tablero
       limpiaTableroRandom(tableroSup,longTableroSup);         
      totalPuntos++;  
    }

}
