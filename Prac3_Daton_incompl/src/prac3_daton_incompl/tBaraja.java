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
    public static int[][] matrizBoolCartas=new int[unaLong][otraLong]; 
    static tCarta[][] matrizCartasReales=new tCarta[unaLong][otraLong];    
    public static String[][] matrizCartas=new String[unaLong][otraLong];
    static tBaraja instance=new tBaraja();
    
    private tBaraja () 
    {
    //inicializar matriz cartas sueltas
    tCarta unaCarta=null;
    for (int i=0;i<unaLong;i++)
    for (int j=0;j<otraLong;j++)
        {
            this.matrizBoolCartas[i][j]=0;            
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
    
    //si le digo -1, -1, me da una carta aleatoria
    //ojo .. matrizBoolCartas lleva lógica inversa
    static tCarta  dameCarta (int r, int p)
    {
                   
            return matrizCartasReales[r][p];
        
    }
    
    static void sacaCarta (int r, int p, int id)
    {
        matrizBoolCartas[r][p]=id;
    }




}
