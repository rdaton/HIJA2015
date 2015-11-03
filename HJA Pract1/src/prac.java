

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.lang.model.type.NullType;

public class prac {


		 
		  public static void main(String args[]) {

			  ArrayList<String> valores = new ArrayList<String>();
		      ArrayList<String> palos = new ArrayList<String>();

		      ArrayList<String> jugada = new ArrayList<String>();
		      
		      ProcesarFicheroEntrada(args[0], valores, palos);
		      
		    System.out.println(valores);
		    System.out.println(palos);
		    
		    MejorMano(valores, palos,jugada);
		    Draw(valores, palos);



		  }
	  
		  public static int ValorCarta(String Entrada)
		  {			  
			  //otorgamos los siguientes valores
			  // T=10 | J=11 | Q=12 | K=13 | A=14
			  if (Entrada.equals("A"))
				  return 14;
			  else if (Entrada.equals("K"))
				  return 13;
			  else if (Entrada.equals("Q"))
				  return 12;
			  else if (Entrada.equals("J"))
				  return 11;
			  else if (Entrada.equals("T"))
				  return 10;
			  else if (Entrada.equals("9"))
				  return 9;
			  else if (Entrada.equals("8"))
				  return 8;
			  else if (Entrada.equals("7"))
				  return 7;
			  else if (Entrada.equals("6"))
				  return 6;
			  else if (Entrada.equals("5"))
				  return 5;
			  else if (Entrada.equals("4"))
				  return 4;
			  else if (Entrada.equals("3"))
				  return 3;
			  else if (Entrada.equals("2"))
				  return 2;
			  else 
				  return 1;						  			  
		  }
		  
		  
		  public static boolean HayPareja( ArrayList<String> valoresArg,ArrayList<String> pareja,ArrayList<String> palosArg,ArrayList<String> jugada )
		  {
			  int i=0, posicion=0,j=0;
			  boolean encontrado = false;
			  boolean HayPareja = false;
			  String aux1,aux2,paux1,paux2;

			  ArrayList<String> valores = new ArrayList<String>();
			  valores=(ArrayList<String>) valoresArg.clone();			  
			  while ( (i<valores.size()-1)  && (!encontrado))
			  {
				  aux1=valores.get(i);
				  paux1=palosArg.get(i);
				  
				  posicion=i+1;
				  while (((j=(posicion))<valores.size()) && (!encontrado))
				  {
					  aux2=valores.get(j);
					  paux2=palosArg.get(j);
					  if (aux1.equals(aux2)){
						  encontrado=true;
						  HayPareja=true;
						  pareja.add(aux1);
						  jugada.add(aux1);
						  jugada.add(paux1);
						  pareja.add(aux2);
						  jugada.add(aux2);
						  jugada.add(paux2);
					  	  }
					  else
						  posicion++;
				  }			  
				  i++;
			  }
			return HayPareja;
		  }
		  
		  public static boolean HayDoblesParejas (ArrayList<String> valores,ArrayList<String> Doblepareja,ArrayList<String> palosArg )
		  {
			  ArrayList<String> pareja1 = new ArrayList<String>();
			  ArrayList<String> pareja2 = new ArrayList<String>();
			  ArrayList<String> aux = new ArrayList<String>();
			  ArrayList<String> aux2 = new ArrayList<String>();
			  
			  ArrayList<String> copiaValores = new ArrayList<String>();			  
			  copiaValores=(ArrayList<String>) valores.clone();
			  ArrayList<String> palos = new ArrayList<String>();
			  palos=(ArrayList<String>) palosArg.clone();
			  
			  int parejas=0;
			  boolean HayDobles=false;
			  
			  //se busca si hay 1 pareja. Si la encuentra la borra, para buscar una segunda
			  if (HayPareja(copiaValores, pareja1,palos,aux)){
				  parejas++;	
				  copiaValores.remove(pareja1.get(0));
				  palos.remove(aux.get(1));
			  	  copiaValores.remove(pareja1.get(1));
			  	palos.remove(aux.get(3));
			  }
			  if (HayPareja(copiaValores, pareja2,palos,aux2))
				  parejas++;	
			  if (parejas==2)
			  {
				  Doblepareja.addAll(aux);
				  Doblepareja.addAll(aux2);				  
			  }			  
				  if (parejas==2)
					  HayDobles=true;		  
				  
			  return HayDobles;
		  }
		  
 		  public static int HayTrio( ArrayList<String> valores,ArrayList<String> Trio ,ArrayList<String> palosArg)
		  {
			  int i=0, posicion=0,j=0, contador=0,solucion=0;
			  boolean HayTrio = false;
			  String aux1 = null;	
			  ArrayList<String> pareja = new ArrayList<String>();
			  ArrayList<String> copiaValores = new ArrayList<String>();
			  copiaValores=(ArrayList<String>) valores.clone();
			  ArrayList<String> palos = new ArrayList<String>();
			  palos=(ArrayList<String>) palosArg.clone();
			  ArrayList<String> aux = new ArrayList<String>();
			  			  
			 //buscamos si hay pareja. 
			 if (HayPareja(copiaValores, pareja,palos,aux))
			 {
				 aux1=pareja.get(0);//cogemos el valor de una de las cartas de la pareja para buscar el 3
				 Trio.add(pareja.get(0));
				 Trio.add(aux.get(1));
				 Trio.add(pareja.get(1));
				 Trio.add(aux.get(3));
				 copiaValores.remove(pareja.get(0));
				 palos.remove(aux.get(1));
				 palos.remove(aux.get(3));
				 copiaValores.remove(pareja.get(1));
			// } movemos a despues del while
			 	while(i<copiaValores.size())
			 	{
			 		if (aux1.equals(copiaValores.get(i))){ //si hemos encontrado un 3 igual
			 			copiaValores.indexOf(aux1);
			 		HayTrio=true;
			 		Trio.add(aux1);	
			 		Trio.add(palos.get(i));
			 		}
			 		i++;
			 	}
			 }
			if (HayTrio)
				solucion= 0;
			else if (contador==1) //si hay draw de trio
				solucion=1;
			else solucion=2;
			
			return solucion;	
		  }
		  
		  public static void Ordenar( ArrayList<String> valores,ArrayList<String> palos )
		  {
			  int i=0,j=0,aux1=0,aux2=0;
			  String Saux,Saux2,Paux1,Paux2;
				  
			        for(i=0;i< (valores.size()-1);i++){
			            for( j=i+1; j<valores.size();j++){
			            	aux1=ValorCarta(valores.get(i));
			            	aux2=ValorCarta(valores.get(j));
			            	
			            	if(aux1<aux2){
			            		Saux=valores.get(i);
			            		Saux2=valores.get(j);
			            		Paux1=palos.get(i);
			            		Paux2=palos.get(j);
			            		valores.remove(i);
			            		palos.remove(i);
			            		valores.add(i, Saux2);
			            		palos.add(i,Paux2);
			            		valores.remove(j);
			            		palos.remove(j);
			            		valores.add(j, Saux);
			            		palos.add(j,Paux1);
			            	}
			            }
			        }			     	  
		  }

		  public static int HayEscalera ( ArrayList<String> valoresArg,ArrayList<String> palosArg,ArrayList<String> jugada )
		  {
			  
			  int i=0, fallos=0,aux1=0,aux2=0,solucion=0;
			  String temporal;
			  boolean open=false, gutshot=false;
			  
			  ArrayList<String> aux = new ArrayList<String>();
			  aux=(ArrayList<String>) valoresArg.clone();
			  
			  ArrayList<String> palos = new ArrayList<String>();
			  palos=(ArrayList<String>) palosArg.clone();
			  			  
			  Ordenar(aux,palos); //ordena de mayor a menor
			  
			  while ( (i<aux.size()-1) && (fallos<2))
			  {
				  aux1=ValorCarta(aux.get(i));
				  aux2=ValorCarta(aux.get(i+1));
				 		  
				  if ( (aux1 != aux2+1 )  && ((i==0)||(i==3)))
				  {
					  fallos++;
					  open=true;
				  }
				  
				  else if ( (aux1 != aux2+1) &&  ((i==1)||(i==2)))
				  {					  
					  fallos++;
					  gutshot=true;
					  //en la mano 5|4|2|2|1 (por ejemplo) se detecta el fallo de las cartas con valor
					  // 4|2 Para ver si es gutshot y se arregla sustituyendo una carta con valor 3
					  // lo hacemos,si detecta m�s fallos no es gutshot
					  temporal=Integer.toString(aux2+1);
					  aux.remove(i+1);
					  aux.add(i+1, temporal);
				  }				  
				  i++;							  
			  }
			  if (solucion==0) //si todo va bien se copia la escalera en la jugada de salida
			  {
				  for (i=0;i<aux.size();i++)
				  {
					  jugada.add(aux.get(i));
					  jugada.add(palos.get(i));					  
				  }
			  }

			  if ((open) && (fallos==1)) //si el fallo est� en la primera carta o en la ultima se produce open-ended
				  solucion=1;
			  else if ((gutshot) && (fallos==1)) //si el fallo esta en el medio se produce gutshot
				  solucion=2;
			  else if (fallos==0)
				  solucion=0;  
			  else if (fallos>1)
				  solucion= 3;
			  return solucion;
		  }

		  public static int HayColor ( ArrayList<String> palosArg,ArrayList<String> jugada,ArrayList<String> valoresArg )
		  {
			  String aux,aux2;
			  boolean color=false;
			  int i=1,contador=1,solucion=0;  
			  ArrayList<String> palos = new ArrayList<String>();
			  palos=(ArrayList<String>) palosArg.clone();
			  
			  aux=palos.get(0);
			  for(i=1;i<palos.size();i++)
			  {
				  aux2=palos.get(i);
				  if (aux.equals(aux2))
				  	  contador++;	  
			  }

			  if (contador==5){ //si es color, copiamos en la jugada de salida
				  solucion= 0;
				  for (i=0;i<valoresArg.size();i++)
				  {
					  jugada.add(valoresArg.get(i));
					  jugada.add(palos.get(i));
					  
				  }
			  }
			  else if (contador==4) //si hay 4 del mismo palo se usara en el Draw
				  solucion= 1;
			  else
				  solucion= 2;

			  return solucion;
		  }

		  public static int HayPoker (ArrayList<String> valoresArg,ArrayList<String> palosArg,ArrayList<String> jugada)
		  {
			  int aux,aux2;
			  boolean color=false;
			  int i=1,j=0,solucion=0,contador=1;;
			  
			  ArrayList<String> valores = new ArrayList<String>();
			  valores=(ArrayList<String>) valoresArg.clone();
			  ArrayList<String> auxS = new ArrayList<String>();
			  		  
			  while((j<2) && (contador<4)){ //comprueba si hay poker para las 2 primeras cartas 1|2|x|x|x|
			  jugada.clear();
			  aux=ValorCarta(valores.get(j));
			  jugada.add(valores.get(j));
			  jugada.add(palosArg.get(j));
			  contador=1;
			  	for(i=j+1;i<valores.size();i++) //comprueba si hay 3 cartas iguales
			  	{
			  		aux2=ValorCarta(valores.get(i));			  		 
			  		if (aux==aux2)
			  		{
			  			jugada.add(valores.get(i));
						jugada.add(palosArg.get(i));
				  	  contador++;	
			  		}
			  	}	
			  	j++;
			  }
			  
			  if (contador==4)
				  solucion= 0;
			  else if (contador==3) //si hay 3 del mismo valor se usara en el Draw
				  solucion= 1;
			  else
				  solucion= 2;
			  return solucion;
		  }
		  
		  public static String ColorMayoritario(ArrayList<String> palosArg)
		  {
			  int i=0,contador=1;
			  String palo = null;
			  ArrayList<String> palos = new ArrayList<String>();
			  palos=(ArrayList<String>) palosArg.clone();
			  
			  //mira si el palo esta repetido mas de 1 veces, para luego usarlo en hayescaleracolor
			  //y ver que palo es el bueno, sabiendo previamente que hay color
			  while ((i<palos.size()-1) && (contador<2))
			  {
				  if ( palos.get(i).equals(palos.get(i+1))) {
					  contador++;
					  palo=palos.get(i);
				  }
				  else
					i++;  
			  }
			  return palo;
			  
		  }
		  
		  public static int HayEscaleraColor (ArrayList<String> valoresArg,ArrayList<String> palosArg,ArrayList<String> jugada)
		  {
			  int i=0,aux1=0,aux2=0,pos1,pos2, resultado=0;
			  String Paux1,Paux2,cMayoritario;
			  boolean fallo=false;
			  ArrayList<String> aux = new ArrayList<String>();
			  ArrayList<String> valores = new ArrayList<String>();
			  valores=(ArrayList<String>) valoresArg.clone();
			  ArrayList<String> palos = new ArrayList<String>();
			  palos=(ArrayList<String>) palosArg.clone();
			  
			  if ( (HayEscalera(valores,palos,aux)==0) && (HayColor(palos,aux,valores)==0) )			  
				  resultado=0;
			  // se comprueba si, habiendo escalera, se falla solo en 1 color
			  else if ((HayEscalera(valores,palos,aux)==0) && (HayColor(palos,aux,valores)==1)) 
				  resultado=1;
			  // se comprueba si, habiendo color, se falla en 1 sola carta para escalera que se open ended
			  else if ( ((HayEscalera(valores,palos,aux)==1) && (HayColor(palos,aux,valores)==0)))
			    resultado=1;
			  // se comprueba si, habiendo color, se falla en 1 sola carta para escalera que sea gutshot
			  else if ( ((HayEscalera(valores,palos,aux)==2) && (HayColor(palos,aux,valores)==0)))
			    resultado=1;			  
			  // se comprueba si no hay escalera por un elemento y no hay color por uno
			  // es la misma carta la que falla en valor y color
			  else if ( ((HayEscalera(valores,palos,aux)==1) && (HayColor(palos,aux,valores)==1)) ||
					  ((HayEscalera(valores,palos,aux)==2) && (HayColor(palos,aux,valores)==1)) ){

				  cMayoritario=ColorMayoritario(palos); //para saber que color es el bueno
				  
				  while ( (i<valores.size()) && (!fallo)) //se mira en que posicion esta fallo color
				  {
					  Paux1=palos.get(i);
					  if (Paux1.equals(cMayoritario))
					  		i++;
					  else
						  fallo=true;
				  }
				  pos1=i;

				  i=0;
				  fallo=false;
				  while ( (i<valores.size()-1) && (!fallo)) //posicion fallo escalera
				  {
					  aux1= ValorCarta(valores.get(i));
					  aux2= ValorCarta(valores.get(i+1));

					  if ( aux1 == (aux2+1))		{	
						  i++;}
					  else 
						  fallo=true;

				  }
				  pos2=i;

			      if ((pos1==pos2)&& (fallo) && ((pos1==0)|| (pos1==4))) //hay draw si las posiciones de fallo coninciden ya que solo
			    	  //fallaria una carta entonces DRAW OPEN ENDED
			    	  resultado= 1;
			      else if ((pos1==pos2)&& (fallo)) //Draw GUTSHOT;
			    	  resultado=2;
			      
			      else resultado=3;
			      
			  	}
			  else			  
				  resultado= 2;
		  
			  if (resultado==0)//si hay escalera la copiamos en la jugada de salida
			  {
				  for (i=0;i<valoresArg.size();i++)
				  {
					  jugada.add(valoresArg.get(i));
					  jugada.add(palosArg.get(i));					  
				  }
			  }
			  return resultado;
				  
		  }
		  
		  public static boolean EsReal (ArrayList<String> valoresArg,ArrayList<String> palosArg)
		  {
			  int i=0,aux1=0,aux2=0, contador=1;
			  boolean Esreal=false;
			  //ordenamos la mano de mas a menos
			  Ordenar(valoresArg, palosArg);
			  //comprobamos que la mas alta es el rey (con valor 14 que le hemos dado a esa carta)
			  if ((ValorCarta(valoresArg.get(0))) == 14)
			  {
				  for (i=0;i<valoresArg.size()-1;i++)
				  {
					  aux1=ValorCarta(valoresArg.get(i));
					  aux2=ValorCarta(valoresArg.get(i+1));
					  if (aux1==aux2+1)
						  contador++;	
				  }
				  
				}
			  

			  if (contador==5)
				  Esreal=true;

			  return Esreal;
		  }
		  
		  public static boolean HayEscaleraReal (ArrayList<String> valoresArg,ArrayList<String> palosArg,ArrayList<String> jugada)
		  {
			  boolean Real =false;
			  int i=0;
			  ArrayList<String> valores = new ArrayList<String>();
			  valores=(ArrayList<String>) valoresArg.clone();
			  ArrayList<String> palos = new ArrayList<String>();
			  palos=(ArrayList<String>) palosArg.clone();
			  ArrayList<String> aux = new ArrayList<String>();
			  
			  if ((HayEscaleraColor(valores, palos,aux)==0) && (EsReal(valores, palos))){
				  Real=true;
				  for (i=0;i<valoresArg.size();i++)
				  {
					  jugada.add(valoresArg.get(i));
					  jugada.add(palosArg.get(i));					  
				  }
			  }
			  return Real;
				  
		  }
		  
		  public static boolean HayFull (ArrayList<String> valores,ArrayList<String> palosArg,ArrayList<String> jugada)
		  {
			  int solucion=0;
			boolean full=false;
			  
			  ArrayList<String> pareja = new ArrayList<String>();
			  ArrayList<String> trio = new ArrayList<String>();
			  ArrayList<String> jugadapareja = new ArrayList<String>();
			  
			  ArrayList<String> CopiaValores = new ArrayList<String>();
			  CopiaValores=(ArrayList<String>) valores.clone();
			  
			  if (HayTrio(CopiaValores, trio,palosArg)==0)
			  {
				  CopiaValores.remove(trio.get(0));
				  CopiaValores.remove(trio.get(1));
				  CopiaValores.remove(trio.get(2));				  
				  if (HayPareja(CopiaValores, pareja,palosArg,jugadapareja)){
					  full=true;	
					  jugada.addAll(trio);
					  jugada.addAll(jugadapareja);
				  }
			  }			  
			  return full;
		  }
		  
		  public static void ProcesarFicheroEntrada (String fichero,ArrayList<String> valores,
				  ArrayList<String> palos)  
		  {
			  
			    String linea;
			    int x=0,y=0;
			      
			    try {
			      FileReader fr = new FileReader(fichero);
			      BufferedReader br = new BufferedReader(fr);
			 
			      linea = br.readLine();
			     // while((linea = br.readLine()) != null)
			 
			      fr.close();

			      System.out.println(linea);

			      char[] aux = linea.toCharArray();      
			      
			      
			      for (x=0,y=1;x<aux.length;x=x+2,y=y+2){
			    	valores.add(""+aux[x]);
			      	palos.add(""+aux[y]);}		      	
		      
			    }    
			    
			    catch(Exception e) {
			      System.out.println("Excepcion leyendo fichero "+ fichero + ": " + e);
			    }
		  }
		  
		  public static void MejorMano (ArrayList<String> valores,ArrayList<String> palos,ArrayList<String> jugada)
		  {
			  jugada.clear();
			  ArrayList<String> aux = new ArrayList<String>();
			  if (HayEscaleraReal(valores, palos,jugada))
				  System.out.println("Best hand: Escalera Real");
			  else if (HayEscaleraColor(valores, palos,jugada)==0)
				  System.out.println("Best hand: Escalera de Color");
			  else if (HayPoker(valores,palos,jugada)==0)
				  System.out.println("Best hand: Poker");
			  else if (HayFull(valores,palos,jugada))
				  System.out.println("Best hand: Full");
			  else if (HayColor(palos,jugada,valores)==0)
				  System.out.println("Best hand: Color");
			  else if (HayEscalera(valores, palos,jugada)==0)
				  System.out.println("Best hand: Escalera");
			  else if (HayTrio(valores,jugada,palos)==0)
				  System.out.println("Best hand: Trio");
			  else if (HayDoblesParejas(valores, jugada,palos))
				  System.out.println("Best hand: Dobles Parejas");
			  else if (HayPareja(valores,aux,palos,jugada))
				  System.out.println("Best hand: Pareja");
			  else
				  System.out.println("No hay jugada");
				  
		  }

		  public static void Draw (ArrayList<String> valores,ArrayList<String> palos)
		  {
			  ArrayList<String> jugada = new ArrayList<String>();
			  ArrayList<String> aux = new ArrayList<String>();
			  if (HayEscaleraColor(valores, palos,jugada)==1)
				  System.out.println("Draw: Escalera de Color Open-Ended");
			  if (HayEscaleraColor(valores, palos,jugada)==2)
				  System.out.println("Draw: Escalera de Color gutshot");
			  if (HayPoker(valores,palos,jugada)==1)
				  System.out.println("Draw: Poker");
			  if (HayDoblesParejas(valores, jugada,palos))
				  System.out.println("Draw: Full");
			  if (HayColor(palos,jugada,valores)==1)
				  System.out.println("Draw: Color");
			  if (HayEscalera(valores, palos,jugada)==1)
				  System.out.println("Draw: Escalera Open-Ended");
			  if (HayEscalera(valores, palos,jugada)==2)
				  System.out.println("Draw: Escalera gutshot");
			  if (HayPareja(valores,aux,palos,jugada) && (HayTrio(valores,jugada,palos)==2))
				  System.out.println("Draw: Trio ");
		  }
}
