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
	
	private static int knapsack(Item[] allItems, int K, int n) {
		// wir sortieren das Array absteigend nach den Verhältnissen zwischen werte und gegenstaende
		// siehe Item CompareTo Implementierung
		Arrays.sort(allItems, Collections.reverseOrder());
		
		LinkedList<Item> rootItems = new LinkedList<>();
		
		//für jedes Item wird berechnet, wie oft dieser maximal in den Rucksack überhaupt passen würde
		//Wichtig für die Anzahl der Verzweigungen der Knoten
		int[] numOfItems = new int[n];
		for(int i=0; i<n; i++) {
			numOfItems[i] = (int) (K/allItems[i].getWeight());
		}
			
				
		int totalWeight = 0;
		// gute Initiale untere Schranke
		while(totalWeight + allItems[0].getWeight() <= K) {
			rootItems.add(allItems[0]);
			totalWeight += allItems[0].getWeight();
		}
		// berechne den Wert wenn man das zweite Item noch fraktional mit einfügen würde
		double restValue = ((K-totalWeight) / allItems[1].getWeight()) * allItems[1].getValue();
		rootItems.add(new Item(restValue, K-totalWeight));
		
		// erstelle daraus ein State
		State root = new State(rootItems);
		root.setValidSolution(false);
		
		Stack<State> stack = new Stack<>();
		
		stack.push(root);
		
		int maxProfit = 0;
		
		//Solange es noch Knoten zu untersuchen gibt
		while (!stack.isEmpty()) {
			//Entferne den Knoten zur Untersuchung
			State current = stack.pop();
			
			for(int i=0; i<)
			
			// Überprüfen Sie, ob dieser Knoten eine Lösung darstellt
            // und ob er eine bessere Lösung als die bisher bekannte ist
			if(current.isValidSolution() && current.getUpperBound() > maxProfit) {
				maxProfit = (int) current.getUpperBound();
			} else if (current.getUpperBound() <= maxProfit) {
				continue;
			} else {
				
			}
		}
		
		return 1;
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
