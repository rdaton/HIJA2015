package part1;
import java.util.*;
import java.math.*;

import part1.tCartaPalo.tPalo;


enum tMano{ROYAL_FLUSH,STRAIGHT_FLUSH,FOUR_KIND,FULL_HOUSE,FLUSH,STRAIGHT,THREE_KIND,TWO_PAIR,PAIR}

class unEvaluador
{
	List<tCartaPalo> listaRoyalFlush;
	
	
	public unEvaluador()
	{
		listaRoyalFlush=new ArrayList<tCartaPalo>();
		
		listaRoyalFlush.add(new tCartaPalo('A','n'));
		listaRoyalFlush.add(new tCartaPalo('K','n'));
		listaRoyalFlush.add(new tCartaPalo('Q','n'));
		listaRoyalFlush.add(new tCartaPalo('J','n'));
		listaRoyalFlush.add(new tCartaPalo('T','n'));
		
		int[listaStraight=new ArrayList<Integer>();
		
	}
	int esRoyalFlush(Set<tCartaPalo>  conjuntoCartas)
	{
		int acum=5;
		for (int i=0;i<5;i++)
		{
			if (conjuntoCartas.contains(listaRoyalFlush.get(i))) 
				acum--;
		}
		return acum;
	}
	 
	/*
	int esStraightFlush(Set<tCartaPalo>  conjuntoCartas)
	{
		return 1;
	}
	
	Set<tCartaPalo> esFourKind(Set<tCartaPalo>  conjuntoCartas)
	{
		return 1;
	}
	
	Set<tCartaPalo> esFullHouse(Set<tCartaPalo>  conjuntoCartas)
	{
		return 1;
	}
	*/
	int esFlush(Set<tCartaPalo>  conjuntoCartas)
	{
		int acum=5;
		int count_h=0;
		int count_d=0;
		int count_s=0;
		int count_c=0;
		
		Iterator <tCartaPalo> unIterador= conjuntoCartas.iterator();
		
		while (unIterador.hasNext())
		{
			switch (unIterador.next()._palo)
			{
			case CLUB:   count_c++; break;
			case SPADE:  count_s++; break;
			case HEART:  count_h++; break;
			case DIAMOND:  count_d++; break;
			}
		}
		
		acum=5-(Math.max(count_h,Math.max(count_d,Math.max(count_s,count_c))));
		
		return acum;
	}
	
	/*
	int sumatorioN(int a)
	{
		return (a*(a+1))/2;
	}
	
	int sumatorioAb(int a, int b)
	{
		int sum=sumatorioN(b)-sumatorioN(a-1);
		return sum;
	}
	*/
	
	int esStraight(Set<tCartaPalo>  conjuntoCartas)
	{
		int acum=5;
		
		
		return acum;
	}
	
	/*
	Set<tCartaPalo> esThreeKind(Set<tCartaPalo>  conjuntoCartas)
	{
		return 1;
	}
	Set<tCartaPalo> esTwoPair(Set<tCartaPalo>  conjuntoCartas)
	{
		return 1;
	}
	Set<tCartaPalo> esPair(Set<tCartaPalo>  conjuntoCartas)
	{
		return 1;
	}
	
	*/
	
	public ArrayList<tMano> dameManos(ArrayList<tCartaPalo> unaListaCartas)
	{
		ArrayList<tMano> unaListaManos=new ArrayList<tMano>();
		Set<tCartaPalo> unSet=new HashSet<tCartaPalo>(unaListaCartas);
		
		
		
		
		
		
		
		
		
		return unaListaManos;
		
		
	}
	
}