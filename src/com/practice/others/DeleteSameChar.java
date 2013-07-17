package com.practice.others;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class DeleteSameChar {
	private String longStr = "abcdefghijklmnopqrstuvwxyz";
	private String shortStr = "cd";
	
	public String deleteChartFromLongStrInShort(String longStr, String shortStr){
		Set longStrHash = new HashSet();
		for(char s : longStr.toCharArray()) {
			longStrHash.add(s);
		}
		String result = "";
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s = new HashSet<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("e");
		s.add("f");
		s.add("g");
		s.add("a");
		
		if(s.contains("b")){
			s.remove("b");
		}
		
		Iterator<String> k = s.iterator();
		while(k.hasNext()){
			System.out.println(k.next());
		}
		System.out.println("-------分割线--------");
		for(String str:s){
			System.out.println(str);
		}
		System.out.println("-------分割线---------");
		for(Object q: s.toArray()){
			System.out.println(q.toString());
		}

	}

}
