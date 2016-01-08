/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;

/**
 *
 * @author barfelix
 */
//existe una única baraja.. luego usaré patrón singleton
public class tBaraja {
    static int unaLong=tRango.enumRango.toArrayChar().length; 
    static int otraLong=tPalo.enumPalo.toArrayChar().length;
    static private int[][] matrizBoolCartas=new int[unaLong][otraLong]; 
    static private tCarta[][] matrizCartasReales=new tCarta[unaLong][otraLong];    
    static private String[][] matrizCartas=new String[unaLong][otraLong];
    static private tBaraja instance=new tBaraja();
    
    private tBaraja () 
    {
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
    
    public static tBaraja getInstance(){
        return instance;
    }
    
    
    
    public  String  dameCartaString (int r, int p)
    {
                   
            return matrizCartas[r][p];
        
    }
    
    //si le digo -1, -1, me da una carta aleatoria
    
    static tCarta  dameCarta (int r, int p)
    {
                   
            return matrizCartasReales[r][p];
        
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
            return true;
        }
    }
    

      void eliminaJugador (int idJugador)
    {
    for (int i=0;i<unaLong;i++)
    for (int j=0;j<otraLong;j++)
        {
            if (this.matrizBoolCartas[i][j]==idJugador)
                this.matrizBoolCartas[i][j]=-1;
             
        }
    }


}
