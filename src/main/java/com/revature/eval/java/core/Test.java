package com.revature.eval.java.core;

import java.util.HashMap;

public class Test {

public static String encode(String string) {
	HashMap<Character, Character> hm = new HashMap<Character, Character>();
	
	string=string.toLowerCase();
	string=string.replaceAll("[-+.^:,]","");
	string=string.replace(" ","");
	
	
	hm.put('a','z');
	hm.put('b', 'y');
	hm.put('c', 'x');
	hm.put('d', 'w');
	hm.put('e', 'v');
	hm.put('f', 'u');
	hm.put('g', 't');
	hm.put('h', 's');
	hm.put('i', 'r');
	hm.put('j', 'q');
	hm.put('k', 'p');
	hm.put('l', 'o');
	hm.put('m', 'n');
	hm.put('n', 'm');
	hm.put('o', 'l');
	hm.put('p', 'k');
	hm.put('q', 'j');
	hm.put('r', 'i');
	hm.put('s', 'h');
	hm.put('t', 'g');
	hm.put('u', 'f');
	hm.put('v', 'e');
	hm.put('w', 'd');
	hm.put('x', 'c');
	hm.put('y', 'b');
	hm.put('z', 'a');
	hm.put('1', '1');
	hm.put('2', '2');
	hm.put('3', '3');
	
	
	
	int i =0;
	StringBuilder sb=new StringBuilder("");

	for(i=0;i<string.length();i++) {
		char letter=string.charAt(i);
		sb.append(hm.get(letter));
	}
	
	for(i=5;i<sb.length();i=i+6) {
		sb.insert(i," ");
	}
	String resultString=sb.toString();
	return resultString;
	
	}


public static void main(String[] args) {
	String ans=encode("Testing,1 2 3, testing.");
	System.out.println(ans);
}
}
