package com.konsteyyy.git.uni.dea.rucksack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Rucksack {	
	
	private static double lowerBound;
	
	private static double knapsack(Item[] allItems, int K, int n) {
		// wir sortieren das Array absteigend nach den Verhältnissen zwischen werte und gegenstaende
		// siehe Item CompareTo Implementierung
		Arrays.sort(allItems, Collections.reverseOrder());
		
		//das günstigste Item ist gerade an der Stelle 0 in dem sortierten Array
		Item optimalItem = allItems[0];
		
		//Wurzelknoten des Zustandsbaums
		State root = new State();
		
		//x gibt die Anzahl jedes Items im Zustand an
		root.x = new double[allItems.length];
		//B/a_s ist x_i
		root.x[0] = K/optimalItem.getWeight();
		
		// Hinweis von Prof: K * c_s/a_s ist gerade die obere Schranke
		root.setUpperBound(K* optimalItem.getRatio());
		
		// wir runden x_i vom optimalen Item ab und multiplizieren mit dem Wert vom optimalen Item
		// wir erhalten eine gültige Lösung -> gültige untere Schranke
		lowerBound = (int) root.x[0] * optimalItem.getValue();

		//LIFO Queue für eine Tiefensuche
		Stack<State> stack = new Stack<>();
		
		stack.push(root);
		
		
		//Solange es noch Knoten zu untersuchen gibt
		while (!stack.isEmpty()) {
			//Entferne den Knoten zur Untersuchung
			State current = stack.pop();
			
			//überprüfe ob dieser Knoten eine gültige Lösung ist und ob der Profit dieses Knotens besser als
			//der bisher Beste ist.
			if(current.isValidSolution() && current.getUpperBound() > lowerBound) {
				//darf zu int gecastet werden, weil wenn gültige Lösung, dann sowieso ganzzahlig
				lowerBound = (int) current.getUpperBound(); 
				
			} else if (current.getUpperBound() <= lowerBound) {
				//wenn Upperbound sowieso kleiner ist als das bisherige Optimum, dann können wir den Teilbaum überspringen
				//Pruned by optimality
				continue;
			} else {
				//Lösung ist nicht gültig, wir müssen den Knoten neu verzweigen
				int currentFIIndex = current.fractionalItemIndex;
				
				State newState = new State();
				
				newState.x = current.x;
				
				newState.x[currentFIIndex] = Math.floor(current.x[currentFIIndex]);
				
			}
			
			
		}
		return lowerBound;
	}
	
	public static int upperBound(State state, Item nextItem, int K) {
		state.setUpperBound(state.getUpperBound() + (K-state.getWeight())/nextItem.getWeight());
		return 1;
	}
	
	public static int stateCheck(Item[] allItems, int[] numOfItems, int K) {
		 
		LinkedList<Item> optimalItems = new LinkedList<>();
		
		for (int i=0; i<numOfItems.length; i++) {
			if(numOfItems[i]>=0) {
				for(int j=0; j<numOfItems[i];j++)
					optimalItems.add(allItems[i]);
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String filepath = args[0];
		
		//scan file 
		Scanner sc = new Scanner(new File(filepath));
		
		//erste Zahl ist die Anzahl der Gegenstände
		int n = sc.nextInt();
		
		//zweite Zahl ist die maximale Kapazität
		int K = sc.nextInt();
		Item[] items = new Item[n];
		
		for(int i=0; i<n; i++) {
			//ab der zweiten Zeile ist die erste Zahl immer das Gewicht und die zweite Zahl der Wert
			int weight = sc.nextInt();
			int value = sc.nextInt();
			items[i] = new Item(value, weight);
			
			System.out.println(""+weight+ " " + value);
		}
		
		System.out.println(knapsack(items, K, n));
	}
	
}
