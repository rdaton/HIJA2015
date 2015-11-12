/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac1_remoz_daton;

/**
 *
 * @author Daton
 */
public class tMano 
{   
    enum enumManos {ESCALERA_REAL,ESCALERA_COLOR,POKER,FULL,COLOR,ESCALERA,
                    TRIO,DOBLE_PAREJA,PAREJA,CARTA_ALTA;}
    //lista de cartas: 5 como mucho.. tal como dictan las reglas del poker
    int n_cartas=5;
    private tCarta[] _listaCartas ;
    
    public tMano(tCarta[] listaCartas)
    {
        _listaCartas=new tCarta[5];
        for (int i=0;i<5;i++)
            this._listaCartas[i]=listaCartas[i];
    }
    
    public int toInt()
    {
        switch (_enum)
        {
            case A: return 14;
            case K: return 13;
            case Q: return 12;
            case J: return 11;
            case T: return 10;
            case NUEVE: return 9;
            case OCHO: return 8;
            case SIETE: return 7;
            case SEIS: return 6;
            case CINCO: return 5;
            case CUATRO: return 4;
            case TRES: return 3;
            case DOS: return 2;
            default: return -1;
        }
        
}
