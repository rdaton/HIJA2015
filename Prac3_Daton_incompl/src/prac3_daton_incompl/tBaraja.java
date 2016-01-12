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
    List<tCarta> dameCartasSuited(int una, int otra,int idJugador, int sel2)
    {
        List cartasSet=new ArrayList();        
        int sel=0;
        for (sel=0;sel<4;sel++)
        {
            if((esLibre(una,sel) || esMia(una,sel,idJugador))
                    &&((esLibre(otra,sel)||esMia(otra,sel,idJugador))))
            {
                cartasSet.add(matrizCartasReales[una][sel]);
                cartasSet.add(matrizCartasReales[otra][sel]);
            }            
        }
        return cartasSet;        
    }
     //pares 6,suited 4, off-suited 12 
    List<tCarta> cogeCartasSuited(int una, int otra,int idJugador, int sel)
    {
        List cartasSet=new ArrayList();        
        
        
            if((esLibre(una,sel) || esMia(una,sel,idJugador))
                    &&((esLibre(otra,sel)||esMia(otra,sel,idJugador))))
            {
                cartasSet.add(coger(una,sel,idJugador));
                cartasSet.add(coger(otra,sel,idJugador));
            }            
        
        return cartasSet;        
    }
    
    void soltarCartasSuited(int una, int otra, int idJugador, int sel)
    {
        soltar(una,sel,idJugador);
        soltar(otra,sel,idJugador); 
    }
    
    //pares 6,suited 4, off-suited 12 
    List<tCarta> dameCartasOffSet (int una, int otra, int idJugador,int sel2)
    {
        List cartasOffSet=new ArrayList();
        int sel=0;
        for (sel=0;sel<12;sel++)
        {
        
        switch (sel)
        {
            case 0:
        if(esLibre(una,0)&&esLibre(otra,1))
            {
                cartasOffSet.add(matrizCartasReales [una][0]);
                cartasOffSet.add(matrizCartasReales [otra][1]);
            }            
        break;
            case 1:
        if(esLibre(una,0)&&esLibre(otra,2))
            {
                cartasOffSet.add(matrizCartasReales [una][0]);
                cartasOffSet.add(matrizCartasReales [otra][2]);
            }            
        break;
            case 2:
        if(esLibre(una,0)&&esLibre(otra,3))
            {
                cartasOffSet.add(matrizCartasReales [una][0]);
                cartasOffSet.add(matrizCartasReales [otra][3]);
            }            
        break;
            case 3:
        if(esLibre(una,1)&&esLibre(otra,2))
            {
                cartasOffSet.add(matrizCartasReales [una][1]);
                cartasOffSet.add(matrizCartasReales [otra][2]);
            }            
        break;
            case 4:
        if(esLibre(una,1)&&esLibre(otra,3))
            {
                cartasOffSet.add(matrizCartasReales [una][1]);
                cartasOffSet.add(matrizCartasReales [otra][3]);
            }      
        break;
            case 5:
        if(esLibre(una,2)&&esLibre(otra,3))
            {
                cartasOffSet.add(matrizCartasReales [una][2]);
                cartasOffSet.add(matrizCartasReales [otra][3]);
            }            
        
        break;
        //50%
            case 6:
        if(esLibre(una,1)&&esLibre(otra,0))
            {
                cartasOffSet.add(matrizCartasReales [una][1]);
                cartasOffSet.add(matrizCartasReales [otra][0]);
            }            
        break;
            case 7:
        if(esLibre(una,2)&&esLibre(otra,0))
            {
                cartasOffSet.add(matrizCartasReales [una][2]);
                cartasOffSet.add(matrizCartasReales [otra][0]);
            }            
        break;
            case 8:
        if(esLibre(una,3)&&esLibre(otra,0))
            {
                cartasOffSet.add(matrizCartasReales [una][3]);
                cartasOffSet.add(matrizCartasReales [otra][0]);
            }            
        break;
            case 9:
        if(esLibre(una,1)&&esLibre(otra,0))
            {
                cartasOffSet.add(matrizCartasReales [una][1]);
                cartasOffSet.add(matrizCartasReales [otra][0]);
            }            
        break;
            case 10:
        if(esLibre(una,3)&&esLibre(otra,1))
            {
                cartasOffSet.add(matrizCartasReales [una][3]);
                cartasOffSet.add(matrizCartasReales [otra][1]);
            }            
        break;
            case 11:
        if(esLibre(una,3)&&esLibre(otra,2))
            {
                cartasOffSet.add(matrizCartasReales [una][3]);
                cartasOffSet.add(matrizCartasReales [otra][2]);
            }            
        }
        }
        return cartasOffSet;        
    }
    
    //pares 6,suited 4, off-suited 12 
    List<tCarta> cogeCartasOffSet (int una, int otra, int idJugador,int sel)
    {
        List cartasOffSet=new ArrayList();
        switch (sel)
        {
            case 0:
        if(esLibre(una,0)&&esLibre(otra,1))
            {
                cartasOffSet.add(coger(una,0,idJugador));
                cartasOffSet.add(coger(otra,1,idJugador));
            }            
        break;
            case 1:
        if(esLibre(una,0)&&esLibre(otra,2))
            {
                cartasOffSet.add(coger(una,0,idJugador));
                cartasOffSet.add(coger(otra,2,idJugador));
            }            
        break;
            case 2:
        if(esLibre(una,0)&&esLibre(otra,3))
            {
                cartasOffSet.add(coger(una,0,idJugador));
                cartasOffSet.add(coger(otra,3,idJugador));
            }            
        break;
            case 3:
        if(esLibre(una,1)&&esLibre(otra,2))
            {
                cartasOffSet.add(coger(una,1,idJugador));
                cartasOffSet.add(coger(otra,2,idJugador));
            }            
        break;
            case 4:
        if(esLibre(una,1)&&esLibre(otra,3))
            {
                cartasOffSet.add(coger(una,1,idJugador));
                cartasOffSet.add(coger(otra,3,idJugador));
            }      
        break;
            case 5:
        if(esLibre(una,2)&&esLibre(otra,3))
            {
                cartasOffSet.add(coger(una,2,idJugador));
                cartasOffSet.add(coger(otra,3,idJugador));
            }            
        
        break;
        //50%
            case 6:
        if(esLibre(una,1)&&esLibre(otra,0))
            {
                cartasOffSet.add(coger(una,1,idJugador));
                cartasOffSet.add(coger(otra,0,idJugador));
            }            
        break;
            case 7:
        if(esLibre(una,2)&&esLibre(otra,0))
            {
                cartasOffSet.add(coger(una,2,idJugador));
                cartasOffSet.add(coger(otra,0,idJugador));
            }            
        break;
            case 8:
        if(esLibre(una,3)&&esLibre(otra,0))
            {
                cartasOffSet.add(coger(una,3,idJugador));
                cartasOffSet.add(coger(otra,0,idJugador));
            }            
        break;
            case 9:
        if(esLibre(una,1)&&esLibre(otra,0))
            {
                cartasOffSet.add(coger(una,1,idJugador));
                cartasOffSet.add(coger(otra,0,idJugador));
            }            
        break;
            case 10:
        if(esLibre(una,3)&&esLibre(otra,1))
            {
                cartasOffSet.add(coger(una,3,idJugador));
                cartasOffSet.add(coger(otra,1,idJugador));
            }            
        break;
            case 11:
        if(esLibre(una,3)&&esLibre(otra,2))
            {
                cartasOffSet.add(coger(una,3,idJugador));
                cartasOffSet.add(coger(otra,2,idJugador));
            }            
        }
        
        return cartasOffSet;        
    }
    
    void soltarCartasOffsuited (int una, int otra, int idJugador, int sel)
    {
        switch (sel)
        {
            case 0:
        
               soltar(una,0,idJugador);
               soltar(otra,1,idJugador);
                     
        break;
            case 1:
        if(esLibre(una,0)&&esLibre(otra,2))
            {
               soltar(una,0,idJugador);
               soltar(otra,2,idJugador);
            }            
        break;
            case 2:
        if(esLibre(una,0)&&esLibre(otra,3))
            {
               soltar(una,0,idJugador);
               soltar(otra,3,idJugador);
            }            
        break;
            case 3:
        if(esLibre(una,1)&&esLibre(otra,2))
            {
                soltar(una,1,idJugador);
                soltar(otra,2,idJugador);
            }            
        break;
            case 4:
        if(esLibre(una,1)&&esLibre(otra,3))
            {
                soltar(una,1,idJugador);
                soltar(otra,3,idJugador);
            }      
        break;
            case 5:
        if(esLibre(una,2)&&esLibre(otra,3))
            {
                soltar(una,2,idJugador);
                soltar(otra,3,idJugador);
            }            
        
        break;
        //50%
            case 6:
        if(esLibre(una,1)&&esLibre(otra,0))
            {
                soltar(una,1,idJugador);
                soltar(otra,0,idJugador);
            }            
        break;
            case 7:
        if(esLibre(una,2)&&esLibre(otra,0))
            {
               soltar(una,2,idJugador);
               soltar(otra,0,idJugador);
            }            
        break;
            case 8:
        if(esLibre(una,3)&&esLibre(otra,0))
            {
                soltar(una,3,idJugador);
                soltar(otra,0,idJugador);
            }            
        break;
            case 9:
        if(esLibre(una,1)&&esLibre(otra,0))
            {
                soltar(una,1,idJugador);
                soltar(otra,0,idJugador);
            }            
        break;
            case 10:
        if(esLibre(una,3)&&esLibre(otra,1))
            {
                soltar(una,3,idJugador);
                soltar(otra,1,idJugador);
            }            
        break;
            case 11:
        if(esLibre(una,3)&&esLibre(otra,2))
            {
                soltar(una,3,idJugador);
                soltar(otra,2,idJugador);
            }            
        }
        
    }
    
    //pares 6,suited 4, off-suited 12 
    
    List damePares (int unRango,int idJugador,int sel2)
    {
         List cartasPares=new ArrayList();
          
        int sel=0;
        for (sel=0;sel<6;sel++)
        {
        
        switch (sel)
        {
            case 0:
        if(esLibre(unRango,0)&&esLibre(unRango,1))
            {
                cartasPares.add(matrizCartasReales [unRango][0]);
                cartasPares.add(matrizCartasReales [unRango][1]);
            }            
        break;
            case 1:
        if(esLibre(unRango,0)&&esLibre(unRango,2))
            {
                cartasPares.add(matrizCartasReales [unRango][0]);
                cartasPares.add(matrizCartasReales [unRango][2]);
            }      
        break; 
            case 2:
        if(esLibre(unRango,0)&&esLibre(unRango,3))
            {
                cartasPares.add(matrizCartasReales [unRango][0]);
                cartasPares.add(matrizCartasReales [unRango][3]);
            }        
        break;    
            case 3:
        if(esLibre(unRango,1)&&esLibre(unRango,2))
            {
                cartasPares.add(matrizCartasReales [unRango][1]);
                cartasPares.add(matrizCartasReales [unRango][2]);
            }            
        break;
            case 4:
        if(esLibre(unRango,1)&&esLibre(unRango,3))
            {
                cartasPares.add(matrizCartasReales [unRango][1]);
                cartasPares.add(matrizCartasReales [unRango][3]);
            }            
        break;
            case 5:
        if(esLibre(unRango,2)&&esLibre(unRango,3))
            {
                cartasPares.add(matrizCartasReales [unRango][2]);
                cartasPares.add(matrizCartasReales [unRango][3]);
            }
        }    
        }
        return cartasPares;
    }
    List cogePares (int unRango,int idJugador,int sel)
    {
         List cartasPares=new ArrayList();
        
        switch (sel)
        {
            case 0:
        if(esLibre(unRango,0)&&esLibre(unRango,1))
            {
                cartasPares.add(coger(unRango,0,idJugador));
                cartasPares.add(coger(unRango,1,idJugador));
            }            
        break;
            case 1:
        if(esLibre(unRango,0)&&esLibre(unRango,2))
            {
                cartasPares.add(coger(unRango,0,idJugador));
                cartasPares.add(coger(unRango,2,idJugador));
            }      
        break; 
            case 2:
        if(esLibre(unRango,0)&&esLibre(unRango,3))
            {
                cartasPares.add(coger(unRango,0,idJugador));
                cartasPares.add(coger(unRango,3,idJugador));
            }        
        break;    
            case 3:
        if(esLibre(unRango,1)&&esLibre(unRango,2))
            {
                cartasPares.add(coger(unRango,1,idJugador));
                cartasPares.add(coger(unRango,2,idJugador));
            }            
        break;
            case 4:
        if(esLibre(unRango,1)&&esLibre(unRango,3))
            {
                cartasPares.add(coger(unRango,1,idJugador));
                cartasPares.add(coger(unRango,3,idJugador));
            }            
        break;
            case 5:
        if(esLibre(unRango,2)&&esLibre(unRango,3))
            {
                cartasPares.add(coger(unRango,2,idJugador));
                cartasPares.add(coger(unRango,3,idJugador));
            }
        }            
        return cartasPares;
    }
    void soltarPares (int unRango,int idJugador,int sel)
    {
         switch (sel)
        {
            case 0:
               soltar(unRango,0,idJugador);
               soltar(unRango,1,idJugador);
                       
        break;
            case 1:        
               soltar(unRango,0,idJugador);
               soltar(unRango,2,idJugador);
             
        break; 
            case 2:
               soltar(unRango,0,idJugador);
               soltar(unRango,3,idJugador);
        break;               
            case 3:       
               soltar(unRango,1,idJugador);
               soltar(unRango,2,idJugador);
                        
        break;
            case 4:        
               soltar(unRango,1,idJugador);
               soltar(unRango,3,idJugador);
                        
        break;
            case 5:
               soltar(unRango,2,idJugador);
               soltar(unRango,3,idJugador);                  
        
        }
    }
    
    List<tCarta> cogeDosCartasRandomRango(List<tCarta> listasCartas, int idJugador)
    {
        List<tCarta> unasCartas=new ArrayList();            
        if (listasCartas.isEmpty() || listasCartas.size() <2)
            return unasCartas;
        if (listasCartas.size()==2)
        {
            coger(listasCartas.get(0).dameRango().toInt(), 
                    listasCartas.get(0).damePalo().toInt(), idJugador);        
            coger(listasCartas.get(1).dameRango().toInt(), 
                    listasCartas.get(1).damePalo().toInt(), idJugador);
            
            return unasCartas;
        }
        int unPuntero=this.numAleatorio(0,listasCartas.size()-1);
        int Puntero2=this.numAleatorio(0,listasCartas.size()-1);
        while (Puntero2==unPuntero)
            Puntero2=this.numAleatorio(0,listasCartas.size()-1);
        
        unasCartas.add(coger(listasCartas.get(unPuntero).dameRango().toInt(), 
                    listasCartas.get(unPuntero).damePalo().toInt(), idJugador));        
        unasCartas.add(coger(listasCartas.get(Puntero2).dameRango().toInt(), 
                    listasCartas.get(Puntero2).damePalo().toInt(), idJugador));
        
        return unasCartas;
    }
}


