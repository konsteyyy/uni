package com.konsteyyy.git.uni.dea.rucksack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Rucksack {	
	
	private static double knapsack(Item[] allItems, int K, int n) {
		// wir sortieren das Array absteigend nach den Verhältnissen zwischen werte und gegenstaende
		// siehe Item CompareTo Implementierung
		Arrays.sort(allItems, Collections.reverseOrder());
		
		//wähle Item mit bestem Verhältnis aus Gewicht und Wert
		Item optimalItem = allItems[0];
		int numOfOptimalItem = K/optimalItem.getWeight();
		
		//Wurzelknoten des Zustandsbaums
		State root = new State(numOfOptimalItem * optimalItem.getValue(),
								numOfOptimalItem * optimalItem.getWeight(), 
								calculate_bound(new State(), allItems, K), 0);
		
		int maxProfit = root.getProfit();
		
		//LIFO Queue für eine Tiefensuche
		Stack<State> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			//hol den nächsten Knoten aus dem Stack zur Untersuchung
			State current = stack.pop();
			
			
			if(current.getBound() >= maxProfit) {
				System.out.println("test");
				for(int i=current.getLevel(); i<allItems.length; i++) {
					State nextState = new State(current);
					
					Item item = allItems[i];
					
					do {
						if(nextState.getWeight() + item.getWeight() <= K) {
							nextState.setProfit(nextState.getProfit() + item.getValue());
							nextState.setWeight(nextState.getWeight() + item.getWeight());
							
							nextState.setBound(calculate_bound(nextState, allItems, K));
							
							if(nextState.getProfit() > maxProfit) {
								maxProfit = nextState.getProfit();
							}
							
							if(nextState.getBound() > maxProfit) {
								stack.push(nextState);
							}
							
						} else break; //Beende die Schleife wenn Kapazität überschritten wird
						
					} while (nextState.getWeight() <= K);
					
					nextState.setLevel(nextState.getLevel()+1);
				}
			}
		}
		
		return maxProfit;
	}
	
	private static int calculate_bound(State state, Item[] items, int K) {
		if(state.getWeight() >= K) {
			return 0;
		}
		
		
		int bound = state.getProfit();
		int restCapacity = K - state.getWeight();
		int level = state.getLevel();
		
		while(level < items.length && items[level].getWeight() <= restCapacity) {
			if(items[level].getWeight() <= restCapacity) {
				int maxCount = (int) (restCapacity / items[level].getWeight());
				
				bound += items[level].getValue() * maxCount	;
				
				restCapacity -= items[level].getWeight() * maxCount;
			}
			level += 1;
		}
		
		return bound;
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
		}
		
		System.out.println(knapsack(items, K, n));
	}
	
}
