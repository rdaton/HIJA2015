/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac2_daton_incompl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author barfelix
 */

public class  tControlador {
int unaLong; 
boolean[][] matrizBool; 
String[][] matrizRangos;
int[][] matrizColor;
List<String> claseParejasAbierto;
List<String> claseSolosSuited;
List<String> claseSolosOffSuited;
List<String> claseDiagonal;
List<String> claseInterCerradoSuited;
List<String> claseInterCerradoOffSuited;
List<String> claseInterAbiertoSuited;
List<String> claseInterAbiertoOffSuited;

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
    unaLong= tRango.enumRango.toArrayChar().length;
    matrizBool= new boolean[unaLong][unaLong];
    matrizRangos=new String[unaLong][unaLong];
    matrizColor=new int[unaLong][unaLong];
    claseParejasAbierto=new ArrayList<>();
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
public void asignaClase(String entrada)
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
    }
}

//presupongo cadenas bien formadas        
boolean parseaEntrada(String entrada)
{
    inicializaMatrices();
    boolean todoBien=true;    
    String[] partes = entrada.split(",");
    for (int i=0;i<partes.length;i++)
        asignaClase (partes[i]);
    
    return todoBien;
}

}
