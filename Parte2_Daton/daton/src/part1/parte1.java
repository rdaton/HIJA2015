package part1;


import java.util.*;


 class clasePrinc
{
	static ArrayList<tCartaPalo> listaCartas;
		
public static void main (String[] args)
{
	listaCartas=new ArrayList<tCartaPalo>();
	char[] unaCadena=args[0].toCharArray();
	tCartaPalo unaCarta;
	
	int i=0;
	while (i<unaCadena.length-1)
	{
		unaCarta=(new tCartaPalo(unaCadena[i],unaCadena[i+1]));
		listaCartas.add(unaCarta);
		i=i+2;
	}
	
Iterator<tCartaPalo> unIterador= listaCartas.iterator();
while (unIterador.hasNext())
{
	tCartaPalo otraCarta=unIterador.next();
	
	
}
	
}

}