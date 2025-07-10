package com.auto;

import java.util.Hashtable;

public class HashTable {

	public static void main(String[] args) {

		Hashtable<Integer, String> ht=new Hashtable<Integer, String>();
	    ht.put(1, "Jan");
	    ht.put(2, "Fab");
	    ht.put(3, "Mar");
	    System.out.println(ht.get(1));
	    System.out.println(ht.get(2));
	    System.out.println(ht.get(3));
	    System.out.println(ht);
	}

}
