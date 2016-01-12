/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author barfelix
 */
//existe una única baraja.. luego usaré patrón singleton
public class tBaraja {
    int nCartasLibres;
    static int unaLong=tRango.enumRango.toArrayChar().length; 
    static int otraLong=tPalo.enumPalo.toArrayChar().length;
    static private int[][] matrizBoolCartas=new int[unaLong][otraLong]; 
    static private tCarta[][] matrizCartasReales=new tCarta[unaLong][otraLong];    
    static private String[][] matrizCartas=new String[unaLong][otraLong];
    static private tBaraja instance=new tBaraja();
    static private boolean[] jugadoresRandom;
    //array que dice cuántas cartas tiene cada jugador
    static private int[] jugadoresActivos;
    
    
    private void init() {
        nCartasLibres=unaLong*otraLong;
    //inicializar matriz cartas sueltas
    tCarta unaCarta=null;
    for (int i=0;i<unaLong;i++)
    for (int j=0;j<otraLong;j++)
        {
            this.matrizBoolCartas[i][j]=-1;            
            unaCarta=new tCarta(
                    //tRango.enumRango.toArrayChar()[unaLong-i-1],
                    tRango.enumRango.toArrayChar()[i],
                    tPalo.enumPalo.toArrayChar()[j]
                            );
            //matrizCartasReales[unaLong-i-1][j]=unaCarta;
            matrizCartasReales[i][j]=unaCarta;
            matrizCartas[i][j]=unaCarta.toString();
        }
    
    
    //código para inicializar matrizCartas
    //inicializar matriz cartas sueltas
    /*
    StringBuffer otroBuffer=null;
    for (int i=0;i<unaLong;i++)
        for (int j=0;j<otraLong;j++)
        {         
            otroBuffer=new StringBuffer().
                    append(tRango.enumRango.toArrayChar()[unaLong-i-1]).
                    append(tPalo.enumPalo.toArrayChar()[j]);
            this.matrizCartas[i][j]=otroBuffer.toString();
        }
    */
    
    jugadoresActivos=new int[12];
    for (int i=0;i<12;i++) 
            jugadoresActivos[i]=0;
        
    jugadoresRandom=new boolean[12];
    for (int i=0;i<12;i++)
        jugadoresRandom[i]=false;
        
    }
    private tBaraja () 
    {
     init();    
    }
    
    public static tBaraja getInstance(){
        return instance;
    }
    
    
    
    public  String  dameCartaString (int r, int p)
    {                   
            return matrizCartas[r][p];        
    }
    
   tCarta dameCartaRandomJugador  (int idJugador)
   {
       
       tCarta unaCarta=null;
       boolean enc=false;
       int maxCartas=unaLong*otraLong;
       int unPuntero=0;
       int r=0;
       int p=0;       
       while (!enc && nCartasLibres>0){
           unPuntero=this.numAleatorio(0,maxCartas-1);
           r=unPuntero % unaLong;
           p=unPuntero % otraLong;
           enc=esLibre(r,p);           
       }  
       
       if (enc && nCartasLibres>-1)
       {    
       unaCarta=coger(r,p,idJugador);
       /*
       unaCarta=new tCarta(
                    tRango.enumRango.toArrayChar()[unaLong-r-1],
                    tPalo.enumPalo.toArrayChar()[p]
                           ); */
       }
               
       return unaCarta;
   }
    
   
   tCarta dameCartaRandomTablero ()
   {
       return dameCartaRandomJugador(11);
   }
   
   boolean soltarCartaTablero (int r, int p)
   {
       return soltar (r,p,11);
   } 
   
    static tCarta  dameCarta (int r, int p)
    {                   
            return matrizCartasReales[r][p];        
    }
    //10: lista negra; 
    //11 : común; 
    //-1 : libre ;
    
    boolean esComun (int r, int p)
    {
        return (matrizBoolCartas[r][p]==11);
    }
            
    boolean esNegra(int r, int p)
    {
        return (matrizBoolCartas[r][p]==10);
    }
      boolean esLibre (int r, int p)
    {
        return (matrizBoolCartas[r][p]==-1);
    }
    static boolean esMia (int r, int p, int id)
    {
        return (matrizBoolCartas[r][p]==id);
    }
    
    tCarta coger (int r, int p, int id)
    {
        if (matrizBoolCartas[r][p]!=-1) 
            return null;
        else
        {
            matrizBoolCartas[r][p]=id;
            nCartasLibres--;
            jugadoresActivos[id]++;
            return matrizCartasReales[r][p];
        }
    }
    
    boolean soltar (int r, int p, int id)
    {
        if (!esMia(r,p,id)) 
            return false;
        else
        {
            matrizBoolCartas[r][p]=-1;
            nCartasLibres++;
            jugadoresActivos[id]--;
            return true;
        }
    }
    

    void eliminaJugador (int idJugador)
    {
    for (int i=0;i<unaLong;i++)
    for (int j=0;j<otraLong;j++)
        {
            if (this.matrizBoolCartas[i][j]==idJugador)
            {
                this.matrizBoolCartas[i][j]=-1;
                nCartasLibres++;
                jugadoresActivos[idJugador]--;
            }
             
        }
    }
    
    int[] dameJugadoresActivos()
    {
        return jugadoresActivos;
    }
    void clear(){
       init(); 
    }  
     //http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
    int numAleatorio (int min, int max)
    {
    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    
    //devuelve las cartas que son del tablero..
    List<tCarta> dameTablero ()
    {
        return dameCartasJugador(11);
    }
    
    List<tCarta> dameCartasJugador( int idJugador)
    {
        return dameCartasJugador(idJugador,0);          
    }
    
    //tipojuego: 0 Holdem; 1: Omaha 
    List<tCarta> dameCartasJugador( int idJugador, int tipoJuego)
    {
        List<tCarta> unaListaCartas=null;
        //si el jugador tiene cartas
        
        if (!jugadoresRandom[idJugador])
        {
            if (jugadoresActivos[idJugador]>0) 
            {
               unaListaCartas=new ArrayList();
               for (int i=0;i<unaLong;i++)
                   for (int j=0;j<otraLong;j++)
                   {
                       if (esMia(i,j,idJugador))
                       {
                           unaListaCartas.add(matrizCartasReales[i][j]);
                       }

                   }
            }
        }
        //tengo que dar cartas random...
        //normalmente son dos(codigo 0), pero
        //si estoy jugando a Omaha(codigo 1), deben ser cuatro
        else if (jugadoresActivos[idJugador]>0) 
        {
             int tope=0;
             if (tipoJuego!=1)
                 tope=2;
             else 
                 tope=4;
             this.eliminaJugador(idJugador);
             unaListaCartas=new ArrayList();
             for (int i=0;i<tope;i++)
             {
                 unaListaCartas.add(this.dameCartaRandomJugador(idJugador));
             }
        }
        return unaListaCartas;               
    }
    
    
    boolean JugadorEsRandom (int idJugador)
    {
        return jugadoresRandom[idJugador];
    }
    
    void setJugadorARandom (int idJugador, boolean cond)
    {        
        if (!cond) 
        {
            eliminaJugador(idJugador);
            jugadoresActivos[idJugador]=0;
            jugadoresRandom[idJugador]=false;
        }
        else 
        {
        jugadoresRandom[idJugador]=true;
        jugadoresActivos[idJugador]=2;
        }        
        
    }
    
    //pares 6,suited 4, off-suited 12 
    List<tCarta> dameCartasSet(int una, int otra,int idJugador)
    {
        List cartasSet=new ArrayList();        
        for (int i=0;i<otraLong;i++)
        {
            if(esLibre(una,i)&&esLibre(otra,i))
            {
                cartasSet.add(coger(una,i,idJugador));
                cartasSet.add(coger(otra,i,idJugador));
            }            
        }
        return cartasSet;        
    }
    
    //pares 6,suited 4, off-suited 12 
    List<tCarta> dameCartasOffSet (int una, int otra, int idJugador)
    {
        List cartasOffSet=new ArrayList();
                
        if(esLibre(una,1)&&esLibre(otra,2))
            {
                cartasOffSet.add(coger(una,1,idJugador));
                cartasOffSet.add(coger(otra,2,idJugador));
            }            
        
        if(esLibre(una,1)&&esLibre(otra,3))
            {
                cartasOffSet.add(coger(una,1,idJugador));
                cartasOffSet.add(coger(otra,3,idJugador));
            }            
        
        if(esLibre(una,1)&&esLibre(otra,4))
            {
                cartasOffSet.add(coger(una,1,idJugador));
                cartasOffSet.add(coger(otra,4,idJugador));
            }            
        
        if(esLibre(una,2)&&esLibre(otra,3))
            {
                cartasOffSet.add(coger(una,2,idJugador));
                cartasOffSet.add(coger(otra,3,idJugador));
            }            
        
        if(esLibre(una,2)&&esLibre(otra,4))
            {
                cartasOffSet.add(coger(una,2,idJugador));
                cartasOffSet.add(coger(otra,4,idJugador));
            }            
        
        if(esLibre(una,3)&&esLibre(otra,4))
            {
                cartasOffSet.add(coger(una,3,idJugador));
                cartasOffSet.add(coger(otra,4,idJugador));
            }            
        
        
        //50%
        if(esLibre(una,2)&&esLibre(otra,1))
            {
                cartasOffSet.add(coger(una,2,idJugador));
                cartasOffSet.add(coger(otra,1,idJugador));
            }            
        
        if(esLibre(una,3)&&esLibre(otra,1))
            {
                cartasOffSet.add(coger(una,3,idJugador));
                cartasOffSet.add(coger(otra,1,idJugador));
            }            
        
        if(esLibre(una,4)&&esLibre(otra,1))
            {
                cartasOffSet.add(coger(una,4,idJugador));
                cartasOffSet.add(coger(otra,1,idJugador));
            }            
        
        if(esLibre(una,3)&&esLibre(otra,2))
            {
                cartasOffSet.add(coger(una,3,idJugador));
                cartasOffSet.add(coger(otra,2,idJugador));
            }            
        
        if(esLibre(una,4)&&esLibre(otra,2))
            {
                cartasOffSet.add(coger(una,4,idJugador));
                cartasOffSet.add(coger(otra,2,idJugador));
            }            
        
        if(esLibre(una,4)&&esLibre(otra,3))
            {
                cartasOffSet.add(coger(una,4,idJugador));
                cartasOffSet.add(coger(otra,3,idJugador));
            }            
        
        
        return cartasOffSet;        
    }
    
    //pares 6,suited 4, off-suited 12 
    
    List damePares (int unRango,int idJugador)
    {
         List cartasPares=new ArrayList();
                
        if(esLibre(unRango,1)&&esLibre(unRango,2))
            {
                cartasPares.add(coger(unRango,1,idJugador));
                cartasPares.add(coger(unRango,2,idJugador));
            }            
        
        if(esLibre(unRango,1)&&esLibre(unRango,3))
            {
                cartasPares.add(coger(unRango,1,idJugador));
                cartasPares.add(coger(unRango,3,idJugador));
            }            
        
        if(esLibre(unRango,1)&&esLibre(unRango,4))
            {
                cartasPares.add(coger(unRango,1,idJugador));
                cartasPares.add(coger(unRango,4,idJugador));
            }            
        
        if(esLibre(unRango,2)&&esLibre(unRango,3))
            {
                cartasPares.add(coger(unRango,2,idJugador));
                cartasPares.add(coger(unRango,3,idJugador));
            }            
        
        if(esLibre(unRango,2)&&esLibre(unRango,4))
            {
                cartasPares.add(coger(unRango,2,idJugador));
                cartasPares.add(coger(unRango,4,idJugador));
            }            
        
        if(esLibre(unRango,3)&&esLibre(unRango,4))
            {
                cartasPares.add(coger(unRango,3,idJugador));
                cartasPares.add(coger(unRango,4,idJugador));
            }            
        return cartasPares;
    }
    
}


