/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author barfelix
 */

public class  tControlador {
static String ficheroBaker="baker.txt";
static String ficheroBakerBak="baker.txt.bak";
static String[] tablaBaker=parseaBaker();
double porcentajeManual;
int unaLong; 
int otraLong;
int idJugador;
boolean[][] matrizBool; 
String[][] matrizRangos;
int[][] matrizColor;
int[][] matrizColorCartas;
double[][]  matrizChubukov;
List<String> claseSolosSuited;
List<String> claseSolosOffSuited;
List<String> claseDiagonal;
List<String> claseInterCerradoSuited;
List<String> claseInterCerradoOffSuited;
List<String> claseInterAbiertoSuited;
List<String> claseInterAbiertoOffSuited;
List<String> claseDiagonalAbierto;
List<String> claseCartasSueltas;

public tControlador( int j)
{
    idJugador=j;
    
    
        inicializaMatrices();
        inicializaListas();
    
    
}

boolean esDiagonal (int a, int b)
{
    return (a==b);
}

boolean esIzquierda (int a, int b)
{
    return (!(esDiagonal(a,b))&&(a>b)); 
}

private void inicializaListas(){
    claseDiagonalAbierto=new ArrayList<>();
    claseSolosSuited=new ArrayList<>();
    claseSolosOffSuited=new ArrayList<>();
    claseDiagonal=new ArrayList<>();
    claseInterCerradoSuited=new ArrayList<>();
    claseInterCerradoOffSuited=new ArrayList<>();
    claseInterAbiertoSuited=new ArrayList<>();
    claseInterAbiertoOffSuited=new ArrayList<>();
    claseCartasSueltas=new ArrayList<>();
}
private void inicializaMatrices() 
{
    porcentajeManual=0;
    unaLong= tRango.enumRango.toArrayChar().length;
    otraLong= tPalo.enumPalo.toArrayChar().length;
    matrizBool= new boolean[unaLong][unaLong];
    matrizRangos=new String[unaLong][unaLong];
    matrizColor=new int[unaLong][unaLong];
    this.matrizColorCartas=new int [unaLong][otraLong];
    
    
    
    
   
    //inicializar matriz suited/offsuited
    StringBuffer unBuffer=null;
    for (int i=0;i<unaLong;i++)
        for (int j=0;j<unaLong;j++)
    {

        matrizBool[i][j]=false;
        
        matrizColor[i][j]=0;        
        if (esDiagonal(i,j))
        {
        unBuffer=new StringBuffer().
                append(tRango.enumRango.toArrayChar()[unaLong-1-i]).
                append(tRango.enumRango.toArrayChar()[unaLong-1-j]);
        }
        else
        {
            if (esIzquierda(i,j))
            {
                unBuffer=new StringBuffer().
                append(tRango.enumRango.toArrayChar()[unaLong-1-j]).
                append(tRango.enumRango.toArrayChar()[unaLong-1-i]);
        
                unBuffer.append("o");
                matrizColor[i][j]=1;
            }    
            else
            {   
                unBuffer=new StringBuffer().
                append(tRango.enumRango.toArrayChar()[unaLong-1-i]).
                append(tRango.enumRango.toArrayChar()[unaLong-1-j]);
        
                unBuffer.append("s");            
                matrizColor[i][j]=2;
            }    
        }        
        matrizRangos[i][j]=unBuffer.toString();
        
        //matrizChubukov
         /*
        matrizChubukov=new double[][]
        { 
            {0,277,137,91.6,69.5,52,44.9,39.5,35.3,36.1,33.3,31.1,29},
            {166,477,43.3,36.3,31.4,23.9,19.9,18.6,17.4,16.1,15,14.1,13.3},
            {96,29.3,239,24.7,21.9,16.2,13.3,11.3,10.9,10.1,9.4,8.8,8.3},
            {68.1,25.4,16.4,159,18,12.8,10.3,8.5,7.3,7,6.4,6,5.5},
            {53.1,22.4,14.8,11.5,120,11.2,8.7,7,5.9,4.9,4.6,4.2,3.7},
            {40.8,17.8,11.7,8.8,7.4,95.7,7.6,6.1,5,4.1,3.2,3,2.6},
            {35.4,15.2,9.9,7.4,6,5.1,79,6,5.5,4.5,3.6,2.8,2.2,2},
            {31.3,14.2,8.5,6.3,5.1,4.2,3.7,67.4,4.1,3.2,2.5,2,1.6},
            {28,13.3,8.1,5.3,4.2,3.5,3,2.7,57.6,3.1,2.3,1.8,1.5},
            {28.2,12.3,7.5,5,3.4,2.8,2.4,2.1,1.9,49.3,2.4,1.9,1.5},
            {25.9,11.4,6.8,4.4,3.1,2.1,1.8,1.6,1.5,1.6,40.9,1.7,1.4},
            {24.2,10.6,6.2,3.9,2.7,2,1.5,1.3,1.3,1.3,1.1,32.7,1.2},
            {22.5,10,5.6,3.44,2.44,2.4,1.8,1.4,1.1,1,0.9,0.9,24}
           
        };
                 */
        
    
        
        
        
    }
    
    
}

static String[] parseaBaker()
{
    //intento leer el fichero de rangos.
    //si no está, o está dañado, uso el de respaldo
    FileReader lectorFichero=null;
        try {
        lectorFichero=new FileReader(ficheroBaker);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(tControlador.class.getName()).log(Level.SEVERE, null, ex);
        try {
            lectorFichero=new FileReader(ficheroBakerBak);
        } catch (FileNotFoundException ex1) {
            Logger.getLogger(tControlador.class.getName()).log(Level.SEVERE, null, ex1);
            return new String[1];
        }
        
    }
    BufferedReader unBufferFichero=new BufferedReader(lectorFichero);
    
    String cadenaFichero="";
    try {
        cadenaFichero=unBufferFichero.readLine();
    } catch (IOException ex) {
        Logger.getLogger(tControlador.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    //String cadenaFichero="88+,AJs+,KQs,AKo;77+,A9s+,KTs+,QTs+,AJo+,KQo;77+,A7s+,K9s+,QTs+,JTs,ATo+,KTo+,QJo;66+,A4s+,K8s+,Q9s+,J9s+,T9s,A9o+,KTo+,QTo+JTo;66+,A2s+,K6s+,Q8s+,J8s+,T8s+,A7o+,K9o+,QTo+,JTo;55+,A2s+,K5s+,Q7s+,J8s+,T8s+,98s,A7o+,A5o,K9o+,Q9o+,J9o+,T9o;55+,A2s+,K3s+,Q6s+,J7s+,T7s+,97s+,87s,A4o,K8o+,Q9o+,J9o+,T9o;44+,A2s+,K2s+,Q4s+,J7s+,T7s+,97s+,87s,A3o,K7o+,Q8o+,J8o+,T9o;44+,A2s+,K2s+,Q4s+,J6s+,T6s+,96s+,86s+,76s+,A2o+,K6o+,Q8o+,J8o+,T8o+,98o;33+, A2s+ K2s+,Q2s+,J4s+,T6s+,96s+,86s+,76s,65s,A2o+,K5o+,Q7o+,J7o+,T7o+,98o;33+,A2s+,K2s+,Q2s+,J3s+,T5s+,95s+,85s+,75s+,65s,A2o+,K4o+,Q6o+,J7o+,T7o+,97o+,87o;22+,A2s+,K2s+,Q2s+,J2s+,T3s+,95s+,85s+,75s+,64s+,54s,A2o+,K2o+,Q5o+,J7o+,97o+,87o;22+,A2s+,K2s+,Q2s+,J2s+,T2s+,94s+,84s+,74s+,64s+,54s,A2o+,K2o+,Q4o+,J6o+,T7o+,97o+,86o+,76o;22+,A2s+,K2s+,Q2s+,J2s+,T2s+,93s+,83s+,73s+,63s+,53s+,43s,A2o+,K2o+,Q3o+,J4o+,T6o+,96o+,86o+,76o;22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,83s+,73s+,63s+,52s+,43s,A2o+,K2o+,Q2o+,J4o+,T6o+,95o+,85o+,75o+,65o;22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,73s+,62s+,52s+,43s,A2o+,K2o+,Q2o+,J3o+,T5o+,95o+,85o+,75o+,65o,54o;22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,72s+,62s+,52s+,42s+,32s,A2o+,K2o+,Q2o+,J2o+,T3o+,95o+,85o+,74o+,64o+,54o;22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,72s+,62s+,52s+,42s+,32s,A2o+,K2o+,Q2o+,J2o+,T2o+,93o+,84o+,74o+,64o+,53o;22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,72s+,62s+,52s+,42s+,32s,A2o+,K2o+,Q2o+,J2o+,T2o+,92o+,83o+,73o+,63o+,52o+,43o;";
    String[] unaTablaBaker=new String[19];
    unaTablaBaker=cadenaFichero.split(";");    
    //para invoccaciones externas
    tablaBaker=unaTablaBaker;
    return unaTablaBaker;
    
}
//de 5 en 5
void porcentajeBaker(int n)
{
    if (n>=0 && n<=100)
    {
        inicializaMatrices();
        inicializaListas();
    }
    else return;
    StringBuffer unBuffer=new StringBuffer();
    
    switch (n)
    {
        case 5:  unBuffer.append(tablaBaker[0]);//"88+,AJs+,KQs,AKo");
        break;
        case 10: unBuffer.append(tablaBaker[1]);//"77+,A9s+,KTs+,QTs+,AJo+,KQo");
        break;
        case 15: unBuffer.append(tablaBaker[2]);//"77+,A7s+,K9s+,QTs+,JTs,ATo+,KTo+,QJo");
        break;    
        case 20: unBuffer.append(tablaBaker[3]);//"66+,A4s+,K8s+,Q9s+,J9s+,T9s,A9o+,KTo+,QTo+JTo");
        break;            
        case 25: unBuffer.append(tablaBaker[4]);//"66+,A2s+,K6s+,Q8s+,J8s+,T8s+,A7o+,K9o+,QTo+,JTo");
        break;   
        case 30: unBuffer.append(tablaBaker[5]);//"55+,A2s+,K5s+,Q7s+,J8s+,T8s+,98s,A7o+,A5o,K9o+,Q9o+,J9o+,T9o");
        break;
        case 35: unBuffer.append(tablaBaker[6]);//"55+,A2s+,K3s+,Q6s+,J7s+,T7s+,97s+,87s,A4o,K8o+,Q9o+,J9o+,T9o");
        break;    
        case 40: unBuffer.append(tablaBaker[7]);//"44+,A2s+,K2s+,Q4s+,J7s+,T7s+,97s+,87s,A3o,K7o+,Q8o+,J8o+,T9o");
        break;    
        case 45: unBuffer.append(tablaBaker[8]);//"44+,A2s+,K2s+,Q4s+,J6s+,T6s+,96s+,86s+,76s+,A2o+,K6o+,Q8o+,J8o+,T8o+,98o");
        break;    
        case 50: unBuffer.append(tablaBaker[9]);//"33+, A2s+ K2s+,Q2s+,J4s+,T6s+,96s+,86s+,76s,65s,A2o+,K5o+,Q7o+,J7o+,T7o+,98o");
        break;    
        case 55: unBuffer.append(tablaBaker[10]);//"33+,A2s+,K2s+,Q2s+,J3s+,T5s+,95s+,85s+,75s+,65s,A2o+,K4o+,Q6o+,J7o+,T7o+,97o+,87o");
        break;    
        case 60: unBuffer.append(tablaBaker[11]);//"22+,A2s+,K2s+,Q2s+,J2s+,T3s+,95s+,85s+,75s+,64s+,54s,A2o+,K2o+,Q5o+,J7o+,97o+,87o");
        break;    
        case 65: unBuffer.append(tablaBaker[12]);//"22+,A2s+,K2s+,Q2s+,J2s+,T2s+,94s+,84s+,74s+,64s+,54s,A2o+,K2o+,Q4o+,J6o+,T7o+,97o+,86o+,76o");
        break;    
        case 70: unBuffer.append(tablaBaker[13]);//"22+,A2s+,K2s+,Q2s+,J2s+,T2s+,93s+,83s+,73s+,63s+,53s+,43s,A2o+,K2o+,Q3o+,J4o+,T6o+,96o+,86o+,76o");
        break;    
        case 75: unBuffer.append(tablaBaker[14]);//"22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,83s+,73s+,63s+,52s+,43s,A2o+,K2o+,Q2o+,J4o+,T6o+,95o+,85o+,75o+,65o");
        break;
        case 80: unBuffer.append(tablaBaker[15]);//"22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,73s+,62s+,52s+,43s,A2o+,K2o+,Q2o+,J3o+,T5o+,95o+,85o+,75o+,65o,54o");
        break; 
        case 85: unBuffer.append(tablaBaker[16]);//"22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,72s+,62s+,52s+,42s+,32s,A2o+,K2o+,Q2o+,J2o+,T3o+,95o+,85o+,74o+,64o+,54o");
        break;
        case 90: unBuffer.append(tablaBaker[17]);//"22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,72s+,62s+,52s+,42s+,32s,A2o+,K2o+,Q2o+,J2o+,T2o+,93o+,84o+,74o+,64o+,53o+");
        break; 
        case 95: unBuffer.append(tablaBaker[18]);//"22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,72s+,62s+,52s+,42s+,32s,A2o+,K2o+,Q2o+,J2o+,T2o+,92o+,83o+,73o+,63o+,52o+,43o");
        break;
        case 100: {
            for (int i=0;i<unaLong;i++)
                for (int j=0;j<unaLong;j++)
                    matrizBool[i][j]=true;
            actualizaMatrices();            
        };
        break;
    }

  if (n!=100)
      this.parseaEntrada(unBuffer.toString());
}
boolean ma (int pos)
{
   tControlador otroControlador=new tControlador(idJugador);     
    StringBuffer unBuffer=new StringBuffer();
    
    switch (pos)
    {
        case 0: unBuffer.append("AA,KK,QQ,JJ,AKs,AKo,TT,AQs,AQo,99,AJs,KQs,88");
        break;
        case 1: unBuffer.append("88+,AQs+,AQo+,AJs,KQs,77,AJs,AJo,KQs,KQo,ATs");
        break;
        case 2: unBuffer.append("77+,AJs+,AJo+,ATs,KQs+,KQo+,66,ATo,A9s,KJs");
        break;
            //me falta "any two suited broadways"
        case 3: unBuffer.append("66+,ATs+,ATo+,A9s+,KQs,KQo,KJs,55,A8s,A9o,KJo,");
        break;    
            //me falta "any two suited broadways", any two "unsuited broadways"
        case 4: unBuffer.append("55+,A8s+,A9o+,KJo+,22+,A2s+");
                
        
            
    }
    otroControlador.parseaEntrada(unBuffer.toString());
   //ya tengo las dos matrices...devuelvo true, si  el rengo
   //introducido por el usuario se encuentra dentro de la matriz de janda
    boolean enc=true;
    
    for (int i=0;i<unaLong ;i++)
        for (int j=0;j<unaLong ;j++)
        {
           
            enc=!(matrizBool[i][j] && !otroControlador.matrizBool[i][j]);            
            if(!enc) return enc ;
        };
    
    return enc ;     
}
boolean janda(int pos){
    tControlador otroControlador=new tControlador(idJugador);     
    StringBuffer unBuffer=new StringBuffer();
    
    switch (pos)
    {
        case 0: unBuffer.append("33+,AKo-AJo,KQo,AKs-ATs,KQs-KTs,JTs-J9s,T9s,98s,87s,76s,65s");
        break;
        case 1: unBuffer.append("22+,AKo-ATo,KQo,AKs-A7s,A5s,KQs-KTs,QJs-QTs,JTs-J9s,T9s-T8s,98s-97s,87s-86s,76s-75s,65s,54s");
        break;
        case 2: unBuffer.append("22+,AKo-ATo,KQo-KJo,QJo,AKs-A2s,KQs-K6s,QJs-Q7s,JTs-J8s,T9s-T8s,98s-97s,87s-86s,76s-75s,65s-64s,54s");
        break;
        case 3: unBuffer.append("22+,AKo-A2o,KQo-K7o,QJo-Q9o, JTo-J9o,T9o-T8o,98o,87o,AKs-A2s,KQs-K2s,QJs-Q2s,JTs-J5s,T9s-T6s,98s-96s,"
                + "87s-85s,76s-74s,65s-64s,54s-53s,43s");
        break;    
        case 4: unBuffer.append("22+,AKo-A7o,KQo-K9o,QJo-Q9o,JTo-J9o,T9o,98o,AKs-A2s,KQs-K2s,QJs-Q4s,JTs-J7s,T9s-T7s,98s-97s,87s-86s,"
                + "76s-75s,65s-64s,54s");
        
            
    }
    otroControlador.parseaEntrada(unBuffer.toString());
   //ya tengo las dos matrices...devuelvo true, si  el rengo
   //introducido por el usuario se encuentra dentro de la matriz de janda
    boolean enc=true;
    
    for (int i=0;i<unaLong ;i++)
        for (int j=0;j<unaLong ;j++)
        {
           
            enc=!(matrizBool[i][j] && !otroControlador.matrizBool[i][j]);            
            if(!enc) return enc ;
        };
    
    return enc ;       
}
public boolean evaluar(int pos, int act, int juez)
{
    boolean unReturn=false;
    if (juez==1) 
    {
        if (act==0) unReturn=janda(pos);
        else if (act==1)
                    unReturn=!janda(pos);
    }
    else if (juez==0)
       {
        if (act==0) unReturn=ma(pos);
        else if (act==1)
                    unReturn=!ma(pos);
    }
    
    return unReturn;
}

//presupongo cadenas bien formadas        
public boolean asignaClase(String entrada)
{
    if (entrada.length()==2)
    {
        if (tPalo.esPalo(entrada.charAt(1)))
            this.claseCartasSueltas.add(entrada);
        else
            this.claseDiagonal.add(entrada);    
    }
    else 
    if (entrada.length()==3)
    {
        if (entrada.charAt(2)=='s')
            this.claseSolosSuited.add(entrada);
        else 
        if (entrada.charAt(2)=='o')
            this.claseSolosOffSuited.add(entrada);
        else
        if (entrada.charAt(2)=='+')
            this.claseDiagonalAbierto.add(entrada);            
    }
    
    else
    if (entrada.length()==4)
    {
        if (entrada.charAt(2)=='s')
            this.claseInterAbiertoSuited.add(entrada);
        else 
        if (entrada.charAt(2)=='o')
            this.claseInterAbiertoOffSuited.add(entrada);            
    }
    else
    if (entrada.length()==7)
    {
        if (entrada.charAt(2)=='s')
            this.claseInterCerradoSuited.add(entrada);
        else 
        if (entrada.charAt(2)=='o')
            this.claseInterCerradoOffSuited.add(entrada);
    }
    else return false;

return true;
}
void calculaPorcentaje()
{
    //peso manos iniciales
    //pares 6,suited 4, off-suited 12
    int sum=0;
    int total=0;
    int ptro=0;
    for (int i=0;i<unaLong;i++)   
    {
        for (int j=0;j<unaLong;j++)
        {
            //par
            if (esDiagonal(i,j))
                 ptro=6;
            //offsuited
            else if (esIzquierda(i,j))
                 ptro=12;
            //suited
            else 
                ptro=6;
            
            total+=ptro;
            if (matrizBool[i][j])
                sum+=ptro;
           
        }
    }
    double unPorcentaje=((double)(sum*100)/(double)(total));
    porcentajeManual=unPorcentaje;
}
void actualizaMatrices()
{
     
    actualizaDiagonal();
    actualizaDiagonalAbierto();
    actualizaSolosSuited();
    actualizaSolosOffSuited();
    actualizaInterAbiertoSuited();
    actualizaInterAbiertoOffSuited();
    actualizaInterCerradoSuited();
    actualizaInterCerradoOffSuited();
    actualizaCartasSueltas();
    calculaPorcentaje();
    
}



//al final, recorre la matriz de cartas sueltas y la convierte
//en pares de cartas (de dos en dos)
void actualizaCartasSueltas()
{
    char unaLetra=' ';
    char otraLetra=' ';
    String unPuntero=null;
    int i=0;
    int j=0;
    int r=0;
    Iterator <String> unIterador=this.claseCartasSueltas.iterator();
    
    while (unIterador.hasNext())
    {
        unPuntero=unIterador.next();
        unaLetra=unPuntero.charAt(0);
        otraLetra=unPuntero.charAt(1);
        i=new tRango(unaLetra).toInt();
        i=i;
        j=new tPalo(otraLetra).toInt();
        //si carta libre, la marco
        if (tBaraja.getInstance().esLibre(i,j))
            tBaraja.getInstance().coger(i, j, idJugador);
            
        
    }
    
    
}
void actualizaDiagonal()
{
    char unaLetra=' ';
    int i=0;
    Iterator<String> unIterador= this.claseDiagonal.iterator();
    while (unIterador.hasNext())
    {
        unaLetra=unIterador.next().charAt(0);
        i=new tRango(unaLetra).toInt(); 
        i=unaLong-1-i;
        this.matrizBool[i][i]=true;
    }
}
void actualizaDiagonalAbierto()
{
    char unaLetra=' ';
    int i=0;        
    Iterator<String> unIterador= this.claseDiagonalAbierto.iterator();
    while (unIterador.hasNext())
    {
        unaLetra=unIterador.next().charAt(0);
        i=new tRango(unaLetra).toInt();        
        while (i<unaLong)
        {
            unaLetra=tRango.enumRango.toArrayChar()[i];
            claseDiagonal.add
                    (new StringBuffer().append(unaLetra).append(unaLetra).toString());            
            i++;
            
        }
        
    }
    
    claseDiagonalAbierto.clear();
    actualizaDiagonal();
}        



void actualizaSolosSuited()
{
    String dosLetras="";
    int i=0;
    int j=0;
    Iterator<String> unIterador= this.claseSolosSuited.iterator();
    while (unIterador.hasNext())
    {
        
        dosLetras=unIterador.next().substring(0,2);
        i=new tRango(dosLetras.substring(0, 1).charAt(0)).toInt();
        i=unaLong-1-i;
        j=new tRango(dosLetras.substring(1, 2).charAt(0)).toInt();        
        j=unaLong-1-j;
        this.matrizBool[i][j]=true;
    }
}
void actualizaSolosOffSuited()
{
    String dosLetras="";
    int i=0;
    int j=0;
    Iterator<String> unIterador= this.claseSolosOffSuited.iterator();
    while (unIterador.hasNext())
    {
        
        dosLetras=unIterador.next().substring(0,2);
        i=new tRango(dosLetras.substring(0, 1).charAt(0)).toInt();
        i=unaLong-1-i;
        j=new tRango(dosLetras.substring(1, 2).charAt(0)).toInt();                
        j=unaLong-1-j;
        // como es Offsuited, hago su simetrico        
        this.matrizBool[j][i]=true;
    }
}

void actualizaInterAbiertoSuited()
{
    String dosLetras="";
    char unaLetra=' ';
    char otraLetra=' ';
    int i=0;
    int j=0;
    int r=0;
    Iterator<String> unIterador= this.claseInterAbiertoSuited.iterator();
    while (unIterador.hasNext())
    {
        dosLetras=unIterador.next();
        unaLetra=dosLetras.charAt(0);
        otraLetra=dosLetras.charAt(1);
        i=new tRango(unaLetra).toInt();
        i=unaLong-1-i;
        j=new tRango(otraLetra).toInt();        
        r=j;
        j=unaLong-1-j;
        while (j!=i)
        {
            otraLetra=tRango.enumRango.toArrayChar()[r];
            claseSolosSuited.add
                    (new StringBuffer().append(unaLetra).append(otraLetra).toString());            
            r++;
            j--;            
        }
        
    
    }
    
    claseInterAbiertoSuited.clear();
    actualizaSolosSuited();
    
    
}

void actualizaInterAbiertoOffSuited()
{
    String dosLetras="";
    char unaLetra=' ';
    char otraLetra=' ';
    int i=0;
    int j=0;
    int r=0;
    Iterator<String> unIterador= this.claseInterAbiertoOffSuited.iterator();
    while (unIterador.hasNext())
    {
        dosLetras=unIterador.next();
        unaLetra=dosLetras.charAt(0);
        otraLetra=dosLetras.charAt(1);
        i=new tRango(unaLetra).toInt();
        i=unaLong-1-i;
        j=new tRango(otraLetra).toInt();        
        r=j;
        j=unaLong-1-j;
        while (j!=i)
        {
            otraLetra=tRango.enumRango.toArrayChar()[r];
            claseSolosOffSuited.add
                    (new StringBuffer().append(unaLetra).append(otraLetra).toString());            
            r++;
            j--;            
        }
        
    }
    
    claseInterAbiertoOffSuited.clear();
    actualizaSolosOffSuited();
    
}


    void actualizaInterCerradoSuited()
    {
    String variasLetras="";
    char unaLetra=' ';
    char otraLetra=' ';
    char terceraLetra=' ';
    int unFinal=0;
    int i=0;
    int j=0;
    int r=0;
    Iterator<String> unIterador= this.claseInterCerradoSuited.iterator();
    while (unIterador.hasNext())
    {
        variasLetras=unIterador.next();
        unaLetra=variasLetras.charAt(0);
        otraLetra=variasLetras.charAt(1);
        terceraLetra=variasLetras.charAt(5);
        unFinal=new tRango(otraLetra).toInt();        
        j=new tRango(terceraLetra).toInt();                
        
        while (unFinal>=j)
        {
            otraLetra=tRango.enumRango.toArrayChar()[j];
            claseSolosSuited.add
                    (new StringBuffer().append(unaLetra).append(otraLetra).toString());            
            j++;
                        
        }
        
    
    }
    
    claseInterCerradoSuited.clear();
    actualizaSolosSuited();
    
        
    }
    
    void actualizaInterCerradoOffSuited()
    {
        
    String variasLetras="";
    char unaLetra=' ';
    char otraLetra=' ';
    char terceraLetra=' ';
    int unFinal=0;
    int i=0;
    int j=0;
    int r=0;
    Iterator<String> unIterador= this.claseInterCerradoOffSuited.iterator();
    while (unIterador.hasNext())
    {
        variasLetras=unIterador.next();
        unaLetra=variasLetras.charAt(0);
        otraLetra=variasLetras.charAt(1);
        terceraLetra=variasLetras.charAt(5);
        unFinal=new tRango(otraLetra).toInt();        
        j=new tRango(terceraLetra).toInt();                
        
        while (unFinal>=j)
        {
            otraLetra=tRango.enumRango.toArrayChar()[j];
            claseSolosOffSuited.add
                    (new StringBuffer().append(unaLetra).append(otraLetra).toString());            
            j++;
                        
        }
        
    
    }
    
    claseInterCerradoOffSuited.clear();
    actualizaSolosOffSuited();         
    }
    /*
    //pares 6,suited 4, off-suited 12 
    StringBuffer convierteSueltas(String unRango)
    {
        StringBuffer unBuffer=new StringBuffer();
        List<tCarta> unaListaCartas=new ArrayList();
        int onLong=unRango.length();
        
        switch (onLong)
        {
            case 2:
                unaListaCartas=tBaraja.getInstance().damePares(
                    new tCarta(unRango.charAt(0),'h').dameRango().toInt(), idJugador,
                        1
               );
                break;
            
            case 3:
                if (unRango.charAt(2)=='s')
                    unaListaCartas=tBaraja.getInstance().dameCartasSuited(
                            new tCarta(unRango.charAt(0),'h').dameRango().toInt(),
                            new tCarta(unRango.charAt(1),'h').dameRango().toInt(),
                            idJugador,
                            1);
                else if (unRango.charAt(2)=='o')
                    unaListaCartas=tBaraja.getInstance().dameCartasOffSet(
                            new tCarta(unRango.charAt(0),'h').dameRango().toInt(),
                            new tCarta(unRango.charAt(1),'h').dameRango().toInt(),
                            idJugador,
                            1);
                break;        
        };

        Iterator <tCarta> unIterador=unaListaCartas.iterator();
        while (unIterador.hasNext())
            unBuffer.append(unIterador.next()).append(',');
       
       return unBuffer;
    }
    */

//presupongo cadenas bien formadas        
boolean parseaEntrada(String entrada)
{
    inicializaListas();
    inicializaMatrices();
    //si cuadrado vacío
    if (entrada.length()==0) 
    {        
        tBaraja.getInstance().eliminaJugador(idJugador);
        return true;
    }
    boolean todoBien=true;    
    String[] partes = entrada.split(",");
    
    for (int i=0;i<partes.length;i++)
    {
        if (!asignaClase (partes[i])) 
        {            
          //  this.inicializaMatrices();
            return false;        
        }
    }
    //todoBien==true
    
    tBaraja.getInstance().eliminaJugador(idJugador);
    actualizaMatrices();
    return todoBien;
}
String dameCsvMatrizRangos ()
{
    //cartas sueltas
    StringBuffer unBuffer=new StringBuffer(); 
    List<tCarta> unasCartas=null;
    if (!tBaraja.getInstance().JugadorEsRandom(idJugador))
        unasCartas=tBaraja.getInstance().dameCartasJugador(idJugador);
   // if (unasCartas==null)
     //   return "";
    if (unasCartas!=null)
    {
    Iterator<tCarta> unIterador=unasCartas.iterator();
    while (unIterador.hasNext())
    {
        unBuffer.append(unIterador.next()).append(',');
    }
    };
    
   
   //rangos
    StringBuffer otroBuffer=new StringBuffer();
    for (int i=0;i<unaLong;i++)
    {
        for (int j=0;j<unaLong;j++)
        {
            if (this.matrizBool[i][j])
            {
                
               unBuffer.append(this.matrizRangos[i][j]);                
               if (i*j<((unaLong-1)*(unaLong-1)))
                   unBuffer.append(',');
             //  unBuffer.append(convierteSueltas(this.matrizRangos[i][j]));
               /*if (i*j<((unaLong-1)*(unaLong-1)))
                   unBuffer.append(',');*/
            }
        }
    }
    
  //  parseaEntrada(unBuffer.toString());
    return unBuffer.toString();
}
}
