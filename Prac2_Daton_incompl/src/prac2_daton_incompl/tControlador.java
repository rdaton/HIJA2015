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
//Double[][] 
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
        
        //matrizColor
        
        
        
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
