/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac2_daton_incompl;

/**
 *
 * @author barfelix
 */

public class tControlador {
int unaLong= tRango.enumRango.toArrayChar().length;
private  boolean[][] matrizBool= new boolean[unaLong][unaLong];
private  String[][] matrizLabels= new String[unaLong][unaLong];
private int[][] matrizColores=new int[unaLong][unaLong];

private void inicializaMatrices() 
{
    for (int i=0;i<unaLong;i++)
        for (int j=0;j<unaLong;j++)
    {
        matrizBool[i][j]=false;
        if (i==j)
            matrizColores=0;
        if ()
    }
}
}
