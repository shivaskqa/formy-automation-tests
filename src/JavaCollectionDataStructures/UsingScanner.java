package JavaCollectionDataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class UsingScanner {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		System.out.println("Please enter the integers, when you want to stop please press any letter on the keyboard");
		
		while(sc.hasNextInt())
		{
			
		list.add(sc.nextInt());	
			
		}
		System.out.println(list.size());
		
		int max=findMax(list);
		
		System.out.println(max);
		
		}

	   static int findMax(ArrayList list)
	   {
	      ArrayList<Integer> l= list;
	      int max=0;
	      
	      for (int i=0;i<list.size();i++)
	      {
	    	  	  if(l.get(i)>max)
	    		max=l.get(i);
	    	  
	      }
	      
	      return max;
	   
	   
	   }
	 
	
	}
	
	


