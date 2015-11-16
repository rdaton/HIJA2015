/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prac1_remoz_daton;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
/**
 *
 * @author usuario_local
 */
public class Prac1_remoz_daton {
   
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
    
    List<String> leerFichero(String nombreFichero) 
    {
      //fuente
      //http://stackoverflow.com/questions/4716503/best-way-to-read-a-text-file-in-java
      FileInputStream inputStream=null;
      try
        {
         inputStream = new FileInputStream(nombreFichero);
         return IOUtils.readLines(inputStream);
        }
      catch(Exception e) {
          e.printStackTrace();
          if (inputStream!=null)
            try
            {
                inputStream.close();
            }
            catch (Exception f) {
                f.printStackTrace();
            };
                
      }
      finally{
          
           if (inputStream!=null)
            try
            {
                inputStream.close();
            }
            catch (Exception f) {
                f.printStackTrace();
            };
          
      }
    return new ArrayList<>();
    }
    
    
    
    private static void parte1(String ficheroEntrada, String ficheroSalida)
    {
        
    }
    
    private static void parte2(String ficheroEntrada, String ficheroSalida)
    {
        
    }

    

}
