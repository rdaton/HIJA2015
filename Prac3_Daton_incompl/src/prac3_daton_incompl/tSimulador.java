/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;

import java.util.ArrayList;
import java.util.Arrays;
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
    private double[] puntos ;
    private long totalPuntos;
    private double[] porcentajes;
    private tCarta[] tablero;
    private int longTablero;
    private final int maxTablero=5;    
    static int dosMillones=200;
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
        
        puntos= new double[10];
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
        if (tBaraja.getInstance().nCartasLibres<52)
        {
        for (int j=0;j<dosMillones;j++)
            {
                partidaCartasSueltas();

            }
            calculaPorcentajes();
        }  
        //si la baraja está llena, eso significa que estamos trabajando con 
            //rangos
            
        
        List <String> listasCartasString[]=new ArrayList[10];        
        List<tCarta> listasCartas[]=new ArrayList[10];
        //leo las listas de rango de cada  controlador
        //hago una lista de las cadenas de rangos de cada jugador
        
        for (int i=0;i<10;i++)
        {
            String unString=VentanaPrincipal._unosControladores[i].dameCsvMatrizRangos();
            if (!unString.isEmpty())
            {
                listasCartasString[i]=new ArrayList();
                String[] unasCadenas=unString.split(",");
                for (int j=0;j<unasCadenas.length;j++)
                    listasCartasString[i].add(unasCadenas[j]);
            }
            else
                listasCartasString[i]=null;
            
        }
        //aquí, ya tengo parseado todas las cadenas de cartas de los jugadores
        
       for (int i=0;i<10;i++)
            {
            if (listasCartasString[i]!=null)
            {
                Iterator<String> unIterador=listasCartasString[i].iterator();
                listasCartasString[i]=new ArrayList();
                while (unIterador.hasNext()){
                        String unString=unIterador.next();
                    
                        switch (unString.length())
                        {
                        case 2:
                            listasCartas[i]=new ArrayList();
                            listasCartas[i].addAll(tBaraja.getInstance().damePares(
                                new tCarta(unString.charAt(0),'h').dameRango().toInt(),
                                    i,
                                    1));                    
                            break;

                        case 3:                    
                            listasCartas[i]=new ArrayList();
                            if (unString.charAt(2)=='s')
                                listasCartas[i].addAll(tBaraja.getInstance().dameCartasSuited(
                                        new tCarta(unString.charAt(0),'h').dameRango().toInt(),
                                        new tCarta(unString.charAt(1),'h').dameRango().toInt(),
                                        i,
                                        1));
                            else if (unString.charAt(2)=='o')
                                listasCartas[i].addAll(tBaraja.getInstance().dameCartasOffSet(
                                        new tCarta(unString.charAt(0),'h').dameRango().toInt(),
                                        new tCarta(unString.charAt(1),'h').dameRango().toInt(),
                                        i,
                                        1));
                            break;        
                };
            }
                    }
            }
        partidaRangos(listasCartas);
                
                if (totalPuntos >0 )
                    calculaPorcentajes();
    }
    
    
    List<tParejaCartas>[] organizaParejas(List<tCarta> listasCartas_n[])
    {
        List<tParejaCartas>[] unaLista = new ArrayList[10];
        
        for (int i=0;i<unaLista.length;i++)
        {
            unaLista[i]=new ArrayList();
            if (listasCartas_n[i]!=null)
            {
            for (int j=0;j<listasCartas_n[i].size();j+=2)
            {
               tParejaCartas unaPareja= new tParejaCartas(listasCartas_n[i].get(j),
                                        listasCartas_n[i].get(j+1));               
                unaLista[i].add(unaPareja);
            }
            }
            
        }        
        return unaLista;
    }
    
    List<tTupla> parejasATuplas (List<tParejaCartas> ent)
    {
        List<tTupla> unaLista=new ArrayList();
        Iterator<tParejaCartas> unIterador=ent.iterator();
        tTupla unaTupla=null;
        while (unIterador.hasNext())
        {
            unaTupla=new tTupla();
            unaTupla.add(unIterador.next());
            unaLista.add(unaTupla);
        }        
        return unaLista;
    }
    void partidaRangos (List<tCarta> listasCartas_n[])
    {
     boolean error=false;
     int r=0;
     while (!error && r<listasCartas_n.length)
     {
         if (listasCartas_n[r] != null)
         {
             error=(listasCartas_n[r].size()%2!=0);
         }
         r++;
     }
     if (error) return;
     
     
    List<tParejaCartas>[] listasCartas=organizaParejas(listasCartas_n);     
     
     //aqui ya sabemos que todos tienen longitud par o cero
    
     List<tTupla> unAcumulador=new ArrayList();
     
     
     for (int i=0;i<listasCartas.length;i++)
     {
        if (listasCartas[i] != null && (listasCartas[i].size()>0))   
        {
           unAcumulador=mezcla(unAcumulador,parejasATuplas(listasCartas[i]));
        }
     }  
     
     //tengo generadas todas las tuplas
     //cada tupla es una partida posible
     //recorro todas las tuplas y voy sacando cartas
     //e invoco partidaCartasSueltas
     tTupla unPuntero=null;
     Iterator<tTupla> unIterador=unAcumulador.iterator();
     while (unIterador.hasNext())
     {          
          unPuntero=unIterador.next();
          sacaCartas(unPuntero); 
          for (int i=0;i<dosMillones;i++)
            partidaCartasSueltas();          
          liberarCartas(unPuntero);
          unPuntero=null;
      }
     
    }
    
    void sacaCartas(tTupla unaTupla)
    {
        Iterator<tParejaCartas> unIterador=unaTupla.iterator();
        int idJugador=0;
        tParejaCartas unaPareja=null;
        while (unIterador.hasNext())
        {
            unaPareja=unIterador.next();
            tBaraja.getInstance().coger(unaPareja.get(0).dameRango().toInt(), unaPareja.get(0).damePalo().toInt(), idJugador);
            tBaraja.getInstance().coger(unaPareja.get(1).dameRango().toInt(), unaPareja.get(1).damePalo().toInt(), idJugador);
            idJugador++;
        }
    }
    
    void liberarCartas(tTupla unaTupla)
    {
        Iterator<tParejaCartas> unIterador=unaTupla.iterator();
        int idJugador=0;
        tParejaCartas unaPareja=null;
        while (unIterador.hasNext())
        {
            unaPareja=unIterador.next();
            tBaraja.getInstance().soltar(unaPareja.get(0).dameRango().toInt(), unaPareja.get(0).damePalo().toInt(), idJugador);
            tBaraja.getInstance().soltar(unaPareja.get(1).dameRango().toInt(), unaPareja.get(1).damePalo().toInt(), idJugador);
            idJugador++;
        }
    }
    
    
    List <tTupla> mezcla(List<tTupla> aux1, List<tTupla> aux2)
    {
        //caso base
        if (aux1.isEmpty()) return aux2;
        List <tTupla> unaLista=new ArrayList();
        tTupla unaTupla=new tTupla();
        for (int i=0;i<aux1.size();i++)
            for (int j=0;j<aux2.size();j++)
            {
                unaTupla.addAll(aux1.get(i));
                unaTupla.addAll(aux2.get(j));
                unaLista.add(unaTupla);
                unaTupla=new tTupla();
             }
        return unaLista;
    }
  
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
       // si hay un solo ganador, le doy cien puntos
       int numGanadores=unosResultados.dameGanadores().size();
       if (numGanadores==1)
           puntos[unIterador.next()]++;
       else
       {       
       while (unIterador.hasNext())
       {
           
           int puntero=unIterador.next();
           double unPunto=(double)puntos[puntero]+((double)1/(double)numGanadores);
           puntos[puntero]=unPunto;
       }
       }
       //suelto las cartas que usé como relleno del tablero
       limpiaTableroRandom(tableroSup,longTableroSup);   
      //actualizo total puntos (cien en cada ronda)
      totalPuntos++;  
    }

}
