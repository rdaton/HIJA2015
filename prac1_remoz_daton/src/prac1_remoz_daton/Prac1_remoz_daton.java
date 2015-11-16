/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prac1_remoz_daton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
/**
 *
 * @author Daton
 */
public class Prac1_remoz_daton {
   private  static List<String> listaLineasEn1=null;
   private  static List<String> listaLineasSal1=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char unaOpcion=new String(args[0]).charAt(1);
        
       switch (unaOpcion)
       {
           case '1': parte1(args[1],args[2]);
           case '2': parte2(args[1],args[2]);
       }
    }
    //fuente
    //http://stackoverflow.com/questions/4716503/best-way-to-read-a-text-file-in-java
    static List<String> leerFichero(String nombreFichero)
    {
        try (FileInputStream inputStream = new FileInputStream(nombreFichero))
        {
            return IOUtils.readLines(inputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    //fuente .¿stackoverflow.com?
    static void escribirFichero(String nombreFichero, StringBuffer unBuffer)
    {
        File unFichero=new File(nombreFichero);
        
            try 
            {
                FileUtils.writeStringToFile(unFichero,unBuffer.toString());
            }
            catch (Exception g) 
            {
                g.printStackTrace();
            }
       
    }
    
        
    private static void parte1(String ficheroEntrada, String ficheroSalida)
    {
        listaLineasEn1=leerFichero(ficheroEntrada);
        tListaManos unaListaManos=new tListaManos(listaLineasEn1);
        
        //guardo la lista de manos en un String de salida.. que contiene
        //ya saltos de línea
        StringBuffer unBuffer=new StringBuffer().append(unaListaManos.toString());
        escribirFichero(ficheroSalida,unBuffer);
        
    }
    
    private static void parte2(String ficheroEntrada, String ficheroSalida)
    {
        
    }

    

}
