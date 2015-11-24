/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac2_daton_incompl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author barfelix
 */

public class  tControlador {
double porcentajeManual;
int unaLong; 
boolean[][] matrizBool; 
String[][] matrizRangos;
int[][] matrizColor;
double[][]  matrizChubukov;
List<String> claseSolosSuited;
List<String> claseSolosOffSuited;
List<String> claseDiagonal;
List<String> claseInterCerradoSuited;
List<String> claseInterCerradoOffSuited;
List<String> claseInterAbiertoSuited;
List<String> claseInterAbiertoOffSuited;
List<String> claseDiagonalAbierto;

public tControlador()
{
    
    inicializaMatrices();
    
}

boolean esDiagonal (int a, int b)
{
    return (a==b);
}

boolean esIzquierda (int a, int b)
{
    return (!(esDiagonal(a,b))&&(a>b)); 
}

private void inicializaMatrices() 
{
    porcentajeManual=0;
    unaLong= tRango.enumRango.toArrayChar().length;
    matrizBool= new boolean[unaLong][unaLong];
    matrizRangos=new String[unaLong][unaLong];
    matrizColor=new int[unaLong][unaLong];
    claseDiagonalAbierto=new ArrayList<>();
    claseSolosSuited=new ArrayList<>();
    claseSolosOffSuited=new ArrayList<>();
    claseDiagonal=new ArrayList<>();
    claseInterCerradoSuited=new ArrayList<>();
    claseInterCerradoOffSuited=new ArrayList<>();
    claseInterAbiertoSuited=new ArrayList<>();
    claseInterAbiertoOffSuited=new ArrayList<>();
    
    
    
    
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
//de 5 en 5
void porcentajeBaker(int n)
{
    if (n>=0 && n<=100)
        inicializaMatrices();
    else return;
    
    switch (n)
    {
        case 5: {};
        break;
        case 10: {};
        break;
        case 15: {};
        break;    
        case 20: {};
        break;            
        case 25: {};
        break;   
        case 30: {};
        break;
            
            
            
            
            
            
            
            
            
    }
}
//presupongo cadenas bien formadas        
public boolean asignaClase(String entrada)
{
    if (entrada.length()==2)
        this.claseDiagonal.add(entrada);    
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
    calculaPorcentaje();
    
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


//presupongo cadenas bien formadas        
boolean parseaEntrada(String entrada)
{
    inicializaMatrices();
    boolean todoBien=true;    
    String[] partes = entrada.split(",");
    for (int i=0;i<partes.length;i++)
    {
        if (!asignaClase (partes[i])) 
        {            
            this.inicializaMatrices();
            return false;        
        }
    }
    
    actualizaMatrices();
    return todoBien;
}
String dameCsvMatrizRangos ()
{
    StringBuffer unBuffer=new StringBuffer();
    for (int i=0;i<unaLong;i++)
    {
        for (int j=0;j<unaLong;j++)
        {
            if (this.matrizBool[i][j])
            {
               unBuffer.append(matrizRangos[i][j]);                
               if (i*j<((unaLong-1)*(unaLong-1)))
                   unBuffer.append(',');
            }
        }
    }
    return unBuffer.toString();
}
}
