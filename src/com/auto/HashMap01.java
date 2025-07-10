package com.auto;

import java.util.HashMap;

public class HashMap01 {

	public static void main(String[] args) {

		HashMap<Integer,String> hs=new HashMap<>();
		hs.put(1, "Jan");
		hs.put(2, "Fab");
		hs.put(3, "Mar");
		System.out.println(hs.get(1));
		System.out.println(hs.keySet());
		hs.forEach((k,v)-> System.out.print("Key: "+k+" "+" Value: "+v));
	
	
	
	}

}
