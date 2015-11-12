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

    public class tBaraja 
    {
    private char[]  _posiblesRangos;
    private char[]  _posiblesPalos;
    private tCarta[][] _listaCartas;

    private void rellenaBaraja()
    {
        for (int i=0;i<_posiblesRangos.length;i++)
            for (int j=0;j<_posiblesPalos.length;j++)
                _listaCartas[i][j]=new tCarta(_posiblesRangos[i],_posiblesPalos[j]);
    }
    
    public tBaraja()
    {
            _posiblesPalos= tPalo.enumPalo.toArrayChar();
            _posiblesRangos=tRango.enumRango.toArrayChar();
            _listaCartas=new tCarta[_posiblesRangos.length][_posiblesPalos.length];
            rellenaBaraja();
    }


}