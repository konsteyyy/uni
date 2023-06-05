package com.konsteyyy.git.uni.dea.list;

import java.util.Scanner;

public class ListTest {

	public static void main(String[] args) {
		
		IList<Integer> liste;
		String listType = args[0];
		
		if(listType.equals("slist")) {
			liste = new SList<Integer>();
			doActions(liste);
		}
		else if(listType.equals("dlist")) {
			liste = new DList<Integer>();
			doActions(liste);
		}
		
		
	}

	public static void doActions(IList<Integer> liste) {
		Scanner sc = new Scanner(System.in);
		char action;
		do {
			System.out.println("Welche aktion soll ausgeführt werden? (a/i/d/g/r/p/c/s/e):");
			//action only collects first letter. so every word is possible, only the first letter matters
			action = sc.next().charAt(0);
			switch(action) {
			case 'a':
				System.out.println("Was soll der Liste hinzugefügt werden?");
				int aelement = sc.nextInt();
				liste.append(aelement);
				break;
			case 'i':
				System.out.println("Was soll der Liste hinzugefügt werden?");
				int ielement = sc.nextInt();
				System.out.println("An welcher Position soll das hinzugefügt werden?");
				int iposition= sc.nextInt();
				liste.insert(ielement, iposition);
				break;
			case 'd':
				System.out.println("An welcher Stelle soll etwas gelöscht werden?");
				int dposition = sc.nextInt();
				liste.delete(dposition);
				break;
			case 'g':
				System.out.println("Welche Position wollen Sie ausgeben?");
				int gposition = sc.nextInt();
				System.out.println(liste.get(gposition));
				break;
			case 'r':
				liste.reverse();
				break;
			case 'p':
				System.out.println(liste.toString());
				break;
			case 'c':
				liste.clear();
				break;
			case 's':
				System.out.println(liste.size());
				break;
			case 'o':
				System.out.println(liste.empty());
				break;
			default:
				break;
			}
		} while(action != 'e');
	}
	
}
