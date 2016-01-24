/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3_daton_incompl;

/**
 *
 * @author user1
 */
public class tParejaCartas 
{
    tCarta[] dosCartas;
    public tParejaCartas(tCarta unaCarta,tCarta otraCarta)
    {
        dosCartas=new tCarta[2];
        dosCartas[0]=unaCarta;
        dosCartas[1]=otraCarta;        
    }
    tCarta get(int i)
    {
        return dosCartas[i];
    }
    
    void put (tCarta carta, int i)
    {
        dosCartas[i]=carta;
    }
    
    int size()
    {
        return 2;
            
    }
   }