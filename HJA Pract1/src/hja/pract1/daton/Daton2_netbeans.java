//fuente: http://rosettacode.org/wiki/Poker_hand_analyser
package hja.pract1.daton;

import Cards.Hands.*;
import Cards.Card.*;
import Cards.Hands;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 
public class Daton2_netbeans {
    static AlmacenRes  unAlmacenRes=new AlmacenRes();;
    final static Cards.ArrayCards miJugada=new Cards.ArrayCards();
    final static String faces = "AKQJT98765432";
    final static String suits = "HDSC";
    final static String[] deck = buildDeck();
    
    static private  List <String> abrirFichero(String nombreFichero)
    {
        List<String> unosString;
        unosString= new ArrayList<>();
        try{
          BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
          String line;
        while ((line = reader.readLine()) != null)
        {
        String unString=line;
        
        unosString.add(conversLinea(line));
        }
        reader.close();
        return unosString;   
            
        }
        
        catch(Exception e) {
        //System.err.format("Ha ocurrido una excepción", nombreFichero);
        //e.printStackTrace();
            e.printStackTrace();
        return null;
        }
    }
    
    
    
 
    
    static private String convers (String unString)
    {
        String tercerString="";
        tercerString+=unString.charAt(0);
        switch (unString.charAt(1))
			{
			 case 'c': tercerString+="C"; break;
			 case 'd': tercerString+="D"; break;
			 case 's': tercerString+="S"; break;
			 case 'h': tercerString+="H";break;
			 		 
			}
        
        return tercerString;
    }
    static private String conversLinea(String unString)
    {
        List<String> otrasCadenas=new ArrayList<>();
        String unaLinea="";
       
        for (int i=0; i<unString.length()-1;i+=2)
        {
            unaLinea+=convers(unString.substring(i, i+2));                    
           // if (i<unString.length()-2) unaLinea+=" ";
        }        
        
        return unaLinea;        
    }
   private static  String[] convers_legacy(String unString)
     {
         List<String> unaLista=new ArrayList<String>();
         
         for (int i=0; i<unString.length()-1;i+=2)
         {
             unaLista.add(unString.substring(i, i+2));         
         }
         String[] tercerString = unaLista.toArray(new String[unaLista.size()]);
         return  tercerString;
         
     }
   private static List<String> conversLinea2(String line) {
    List<String> unosString = new ArrayList <> ();
    unosString.add("");
    unosString.add("");
        int i=0;
        while(i<line.length()-1)
        {
            if (line.charAt(i)==';') {i+=3;break;}; //me salto el punto y coma
            unosString.set(0,unosString.get(0)+line.substring(i, i+2));
            i+=2;
        };
        
       while (i<line.length()-1)
       {
           unosString.set(1,unosString.get(1)+line.substring(i, i+2));
            i+=2;
       }
        
 return unosString;
    }
    static private  List <List<String>> abrirFichero2(String nombreFichero)
    {
        List<List<String>> unosString;
        unosString= new ArrayList<>();
        try{
          BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
          String line;
        while ((line = reader.readLine()) != null)
        {
        String unString=line;
        
        unosString.add(conversLinea2(line));
        }
        reader.close();
        return unosString;   
            
        }
        
        catch(Exception e) {
        //System.err.format("Ha ocurrido una excepción", nombreFichero);
        //e.printStackTrace();
            e.printStackTrace();
        return null;
        }
    }
   
    //j sirve para saber qué cartas añadir de la mesa
    private  static String combinar (String mano, String mesa, int j)
    {
        int long_max=mesa.length()%3;
        String unString="";
        
        unString=mano + mesa.substring(long_max);
        
        return unString;
        
    }
    
    private static void parte2 (String unFichero,String Salida)
   {
       //dos listas de listas de cartas ..
       //primera lista de cartas en mano
       //segunda lista de cartas comunes
       List <List<String>> otrosString;
       
       otrosString=abrirFichero2(unFichero);
       
       Iterator<String> iteradorJugador=otrosString.get(0).iterator();
       Iterator<String> iteradorMesa=otrosString.get(1).iterator();
       
        while (iteradorJugador.hasNext() && iteradorMesa.hasNext())
        {
        String unString=combinar (iteradorJugador.next(), iteradorMesa.next(),0);
        System.out.print(unString+"\n");
        System.out.println(analyzeHand(convers_legacy(unString)));
        }
       
       
   }
    
 static private void escribirFichero (AlmacenRes unAlmacen,String otroFichero) throws IOException
    {
       
        BufferedWriter out = null;
try  
{
    FileWriter fstream = new FileWriter(otroFichero, false); //true tells to append data.
    out = new BufferedWriter(fstream);
    
    for (int i=0; i<unAlmacen.dameLong();i++)
    {
        Score[] listaScores=new Score[10];
        int[] listaDraws=new int[10];
         unAlmacen.dameListas(i, listaScores, listaDraws);
         out.write("Mano " +i+"\n");
    out.write(listaScores[0].toString()+"\n");
    out.write("Draws de Mano "+i+"\n");
     for (int s=1;s<10;s++)
        {
            
           if ((listaDraws[s]>0)&&(s!=listaDraws[0]))
           out.write(listaScores[s].toString()+"\n");
        }
     out.write("\n"+"\n");
    }   
    }
catch (IOException e)
{
    System.err.println("Error: " + e.getMessage());
}
finally
{
    if(out != null) {
        out.close();
    }
}
    }
    
    private static void parte1(String nombreFichero,String salida)
    {
       
        List<String> unosString= new ArrayList<String>();
        unosString=abrirFichero(nombreFichero); //(args[0]);
        String cadenaWild="";
        Score otroScore;
        //array de draws .. para evitar que me salgan duduplicados
        
        int[] listaDraws= new int[10];
        //me guardo la lista de Scores, para imprimir luego
        Score[] listaScores=new Score[10];
        
        
        Iterator <String> unIterador=unosString.iterator();
        
        while (unIterador.hasNext())
        {
        System.out.println("Jugada principal"+"\n");
        
        String unString=unIterador.next();
        System.out.print(unString+"\n");
        //analizo jugadas concretas
        Score unScore=analyzeHand(convers_legacy(unString));
        //meto en celda 0 el Score.. es especial, porque es sin comodines
        listaDraws[0]=unScore.weight;
        listaScores[0]=unScore;
        System.out.println(unScore);
        System.out.print("\n");
        System.out.println("Busco Draws");
        //me pongo a buscar draws, a glope de wildcards... 10 combinaciones
        //diferentes nº combinatorio (5)
        //                           (2)
        
        //prefijo+WW+WW+sufijo
        
        
        for (int i=0;i<8;i+=2)
        {
            
        cadenaWild=unString.substring(0,i)+"WWWW"+unString.substring(i+4,unString.length());
        otroScore=analyzeHandWithWildcards(convers_legacy(cadenaWild)).score;
        listaDraws[otroScore.weight]++;
        listaScores[otroScore.weight]=otroScore;
        }
        
        //WW________WW
        
        cadenaWild="WW"+unString.substring(2,8)+"WW";
        otroScore = analyzeHandWithWildcards(convers_legacy(cadenaWild)).score;
        listaDraws[otroScore.weight]++;
        listaScores[otroScore.weight] = otroScore;
        
        //WW____WW______ 
        
        
        cadenaWild="WW"+unString.substring(2,6)+"WW"+unString.substring(8,10);
        otroScore=analyzeHandWithWildcards(convers_legacy(cadenaWild)).score;
        listaDraws[otroScore.weight]++;
        listaScores[otroScore.weight]=otroScore;
        
        // __WW____WW
        cadenaWild=unString.substring(0,2)+"WW"+unString.substring(4,8)+"WW";
        otroScore=analyzeHandWithWildcards(convers_legacy(cadenaWild)).score;
        listaDraws[otroScore.weight]++;
        listaScores[otroScore.weight]=otroScore;
        
        //**WW_WW**
            for (int i = 0; i < 6; i+=2) {

                cadenaWild = unString.substring(0, i) + "WW" + unString.substring(i + 2, i+4)
                        +"WW"+unString.substring(i + 6,unString.length());
                otroScore = analyzeHandWithWildcards(convers_legacy(cadenaWild)).score;
                listaDraws[otroScore.weight]++;
                listaScores[otroScore.weight] = otroScore;
            }
        
        // imprimo los draws, comparando con el Score fijo apuntado
        
        
       for (int s=1;s<10;s++)
        {
           if ((listaDraws[s]>0)&&(s!=listaDraws[0]))
               System.out.println(listaScores[s]+"\n");
        }
        
       
        unAlmacenRes.add(listaScores, listaDraws);
        
       
        }
        
        
        try {  
            escribirFichero(unAlmacenRes,salida);
        } catch (IOException ex) {
            Logger.getLogger(Daton2_netbeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        
       char unaOpcion=new String(args[0]).charAt(1);
        
       switch (unaOpcion)
       {
           case '1': parte1(args[1],args[2]);
           case '2': parte2(args[1],args[2]);
       }
        
        /*
        System.out.println("Regular hands:\n");
        for (String input : new String[]{"2H 2D 2S KS QD",
            "2H 5H 7D 8S 9D",
            "AH 2D 3S 4S 5S",
            "2H 3H 2D 3S 3D",
            "2H 7H 2D 3S 3D",
            "2H 7H 7D 7S 7C",
            "TH JH QH KH AH",
            "4H 4C KC 5D TC",
            "QC TC 7C 6C 4C",
            "QC TC 7C 7C TD"}) {
            System.out.println(analyzeHand(input.split(" ")));
        }
        */
       // for (int i=0; i<unString.length;i++)
       // System.out.print(unString[i]+"\n");
 
     //  String cadena ="TH WW WW QH AH" ;
    // System.out.println(analyzeHandWithWildcards(cadena.split(" ")));
        
       /* System.out.println("\nHands with wildcards:\n");
        for (String input : new String[]{"2H 2D 2S KS WW",
            "AH 8H 8S WW WW",
            "AH 2D 3S 4S WW",
            "2H 3H 2D 3S WW",
            "2H 7H 2D 3S WW",
            "2H 7H 7D WW WW",
            "TH JH QH WW WW",
            "4H 4C KC WW WW",
            "QC TC 7C WW WW",
            "QC TC 7H WW WW"}) {
            System.out.println(analyzeHandWithWildcards(input.split(" ")));
        }
       */
    }
 
    private static Score analyzeHand(final String[] hand) {
        if (hand.length != 5)
            return new Score("invalid hand: wrong number of cards", -1, 
                    hand,new Cards.ArrayCards(hand[0]));
 
        if (new HashSet<>(Arrays.asList(hand)).size() != hand.length)
            return new Score("invalid hand: duplicates", -1, 
                    hand,new Cards.ArrayCards(hand[0]));
        //faces_length es 14 o 13
        int[] faceCount = new int[faces.length()];
        long straight = 0, flush = 0;
        for (String card : hand) {
 
            int face = faces.indexOf(card.charAt(0));
            if (face == -1)
                return new Score("invalid hand: non existing face", -1, 
                        hand,new Cards.ArrayCards(hand[0]));
            straight |= (1 << face);
 
            faceCount[face]++;
 
            if (suits.indexOf(card.charAt(1)) == -1)
                return new Score("invalid hand: non-existing suit", -1, 
                        hand,new Cards.ArrayCards(hand[0]));
            flush |= (1 << card.charAt(1));
        }
 
        // shift the bit pattern to the right as far as possible
        while (straight % 2 == 0)
            straight >>= 1;
 
        // straight is 00011111; A-2-3-4-5 is 1111000000001
        boolean hasStraight = straight == 0b11111 || straight == 0b1111000000001;
 
        // unsets right-most 1-bit, which may be the only one set
        boolean hasFlush = (flush & (flush - 1)) == 0;
        //rehacer
        if (hasStraight && hasFlush)
            return new Score("straight-flush", 9, 
                    hand,new Cards.ArrayCards(hand[0]));
 
        int total = 0;
        int i=0;
        for (int count : faceCount) {
            i++;
            if (count == 4)
                return new Score("four-of-a-kind", 8, 
                        hand,new Cards.ArrayCards(hand[0]));
            if (count == 3)
                total += 3;
            else if (count == 2)
                total += 2;
        }
 
        if (total == 5)
            return new Score("full-house", 7, 
                    hand,new Cards.ArrayCards(hand[0]));
 
        if (hasFlush)
            return new Score("flush", 6, 
                    hand,new Cards.ArrayCards(hand[0]));
 
        if (hasStraight)
            return new Score("straight", 5, 
                    hand,new Cards.ArrayCards(hand[0]));
 
        if (total == 3)
            return new Score("three-of-a-kind", 4, 
                    hand,new Cards.ArrayCards(hand[0]));
 
        if (total == 4)
            return new Score("two-pair", 3, 
                    hand,new Cards.ArrayCards(hand[0]));
 
        if (total == 2)
            return new Score("one-pair", 2, 
                    hand,new Cards.ArrayCards(hand[0]));
 
        return new Score("high-card", 1, 
                hand,new Cards.ArrayCards(hand[0]));
    }
 
    private static WildScore analyzeHandWithWildcards(String[] hand) {
        if (Collections.frequency(Arrays.asList(hand), "WW") > 2)
            throw new IllegalArgumentException("too many wildcards");
 
        return new WildScore(analyzeHandWithWildcardsR(hand, null), hand.clone());
    }
 
    private static Score analyzeHandWithWildcardsR(String[] hand,
            Score best) {
 
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals("WW")) {
                for (String card : deck) {
                    if (!Arrays.asList(hand).contains(card)) {
                        hand[i] = card;
                        best = analyzeHandWithWildcardsR(hand, best);
                    }
                }
                hand[i] = "WW";
                break;
            }
        }
        Score result = analyzeHand(hand);
        if (best == null || result.weight > best.weight)
            best = result;
        return best;
    }
 
    private static String[] buildDeck() {
        String[] dck = new String[suits.length() * faces.length()];
        int i = 0;
        for (char s : suits.toCharArray()) {
            for (char f : faces.toCharArray()) {
                dck[i] = "" + f + s;
                i++;
            }
        }
        return dck;
    }

    
 
    private static class Score {
        final Cards.ArrayCards _cartas;
        final int weight;
        final String name;
        String[] hand;
 
        Score(String n, int w, String[] h, Cards.ArrayCards cartas) {
            
            
            _cartas=new Cards.ArrayCards();
            
            
            for (int i=0;i<cartas.getCardsize();i++)
                _cartas.addCards((Hands) cartas.getCard(i));
            weight = w;
            name = n;
            hand = h != null ? h.clone() : h;
        }
 
        @Override
        public String toString() {
            Hands cartaAlta=_cartas.getCard(0);
            String unaCadena=cartaAlta.toString();
            return Arrays.toString(hand) + " " + name ; //+ " de " + unaCadena ;
            
        }
    }
 
    private static class WildScore {
        final String[] wild;
        final Score score;
 
        WildScore(Score s, String[] w) {
            score = s;
            wild = w;
        }
 
        @Override
        public String toString() {
            return String.format("%s%n%s%n", Arrays.toString(wild),
                    score.toString());
        }
     
    }
static class AlmacenRes
{
    static List<Score[]> _listaScores;
    static List<int[]> _listaDraws;
     int _longitud;
    public AlmacenRes()
    {
        _longitud=0;
        _listaScores=new ArrayList<>();
        _listaDraws=new ArrayList<>();
    }
    public void dameListas(int i,Score[] listaScores,int[] listaDraws)
    {
        Score[] unaListaScores=_listaScores.get(i);
        int[] unaListaDraws=_listaDraws.get(i);
        for (int j=0;j<10;j++)
        {
            listaScores[j]=unaListaScores[j];
            listaDraws[j]=unaListaDraws[j];
        }
    }
    
    public int dameLong()
    {
        return _longitud;
    }
    public void add (Score[] listaScores,int[] listaDraws)
    {
        _listaScores.add(listaScores);
        _listaDraws.add(listaDraws);
        _longitud++;
    }
}







}