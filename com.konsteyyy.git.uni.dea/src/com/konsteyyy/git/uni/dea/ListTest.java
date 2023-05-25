package com.konsteyyy.git.uni.dea;

import java.util.Scanner;

public class ListTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		IList<Integer> liste;
		
		System.out.println("slist/dlist ?: ");
		String listType = sc.next();
		if(listType == "slist")
			liste = new SList<Integer>();
		else if(listType == "dlist")
			liste = new DList<Integer>();
		
		char action;
		do {
			System.out.println("Welche aktion soll ausgeführt werden? (a/i/d/g/r/p/c/s/e):");
			action = sc.next().charAt(0);
			//append here
		} while(action != 'c');
	}

}
