/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;
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
    
    
    private void init() {
        nCartasLibres=unaLong*otraLong;
    //inicializar matriz cartas sueltas
    tCarta unaCarta=null;
    for (int i=0;i<unaLong;i++)
    for (int j=0;j<otraLong;j++)
        {
            this.matrizBoolCartas[i][j]=-1;            
            unaCarta=new tCarta(
                    tRango.enumRango.toArrayChar()[unaLong-i-1],
                    tPalo.enumPalo.toArrayChar()[j]
                            );
            matrizCartasReales[i][j]=unaCarta;
        }
    
    
    //código para inicializar matrizCartas
    //inicializar matriz cartas sueltas
    StringBuffer otroBuffer=null;
    for (int i=0;i<unaLong;i++)
        for (int j=0;j<otraLong;j++)
        {         
            otroBuffer=new StringBuffer().
                    append(tRango.enumRango.toArrayChar()[unaLong-i-1]).
                    append(tPalo.enumPalo.toArrayChar()[j]);
            this.matrizCartas[i][j]=otroBuffer.toString();
        }
        
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
       coger(r,p,idJugador);
       unaCarta=new tCarta(
                    tRango.enumRango.toArrayChar()[unaLong-r-1],
                    tPalo.enumPalo.toArrayChar()[p]
                           );
       }
       return unaCarta;
   }
    
   
   tCarta dameCartaRandomTablero ()
   {
       return dameCartaRandomJugador(-2);
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
    
    boolean coger (int r, int p, int id)
    {
        if (matrizBoolCartas[r][p]!=-1) 
            return false;
        else
        {
            matrizBoolCartas[r][p]=id;
            nCartasLibres--;
            return true;
        }
    }
    
     boolean soltar (int r, int p, int id)
    {
        if (matrizBoolCartas[r][p]==-1 || !esMia(r,p,id)) 
            return false;
        else
        {
            matrizBoolCartas[r][p]=-1;
            nCartasLibres++;
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
            }
             
        }
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
}


