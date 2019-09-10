package JavaCollectionDataStructures;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <String> list=new ArrayList<String>();
		
		list.add("Shiva");
		list.add("Shankar");
		list.add(2, "Konduru");
		list.add(3,"Skandha");
		
		boolean isValueExists=list.contains("Shiva");
		
		System.out.println("Using Iterator");
		
		System.out.println(isValueExists);

		Iterator<String> itr=list.iterator();
		
	while(itr.hasNext())
					
		System.out.println(itr.next());
	
	    list.remove(0);
	
	 System.out.println("Using For loop");
	 
	 for(int i=0; i<list.size();i++)
	 {
		 System.out.println(list.get(i));
		 
	 }
		 
		 
	
	
	}

}
