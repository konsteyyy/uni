package com.konsteyyy.git.uni.dea.rucksack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Rucksack {

	private static int lowerBound;

	private static double knapsack(Item[] allItems, int K, int n) {
		// wir sortieren das Array absteigend nach den Verhältnissen zwischen werte und
		// gegenstaende (siehe Item CompareTo Implementierung)
		Arrays.sort(allItems, Collections.reverseOrder());

		// wähle Item mit bestem Verhältnis aus Gewicht und Wert
		Item optimalItem = allItems[0];
		double maxCountItem = K / (double) optimalItem.getWeight(); // B/a_s wie Prof vorgeschlagen

		// initialisiere Wurzelknoten des Zustandsbaums
		State root = new State();

		// initialisiere Array mit x Werten
		root.setX(new double[allItems.length]);
		double[] x = root.getX();

		// x1 = 2,3 sozusagen
		x[0] = maxCountItem;
		for (int i = 1; i < x.length; i++)
			x[i] = 0;

		root.setX(x);
		root.setUpperBound(calculate_bound(x, allItems, K, 0));

		// gute initiale untere Schranke
		lowerBound = (int) Math.floor(root.getUpperBound());

		// LIFO Queue für eine Tiefensuche
		Stack<State> stack = new Stack<>();

		stack.push(root);
		
		int indexOfFractionalItem = 0;
		
		while (!stack.isEmpty()) {
			// hol den vordersten Knoten vom Stack runter
			State current = stack.pop();

			// überprüfe ob dieser Knoten eine gültige Lösung ist
			boolean validSolution = true;
			x = current.getX();

			// es ist eine gültige Lösung wenn alle x_i ganzzahlig sind
			for (int j = 0; j < x.length; j++) {
				if (Double.compare(x[j], Math.floor(x[j])) != 0) {
					validSolution = false;
					indexOfFractionalItem = j;
				}
			}

			//ist es keine gültige Lösung müssen wir verzweigen
			if (!validSolution) {
				for (int i = (int) Math.floor(x[indexOfFractionalItem]); i > 0; i--) {

					State newState = new State();
					
					x[indexOfFractionalItem] = Math.floor(x[indexOfFractionalItem]);

					// nächstes Item wird mit Restgewicht durch Item gewicht fraktional aufgenommen
					double remainingCapacity = K - x[indexOfFractionalItem] * allItems[indexOfFractionalItem].getWeight();
					x[indexOfFractionalItem + 1] = (remainingCapacity) / allItems[indexOfFractionalItem + 1].getWeight();
					
					//berechne die obere Schranke neu
					newState.setUpperBound(calculate_bound(x, allItems, K, indexOfFractionalItem));
					
					//wenn die obere Schranke schlechter als das aktuelle Minimum ist, schneide ab und überspringe den Teilbaum
					if (newState.getUpperBound() < lowerBound) {
						continue;
					} else {
						stack.push(newState);
					}
				}
			}
			current.setX(x);
		}

		return lowerBound;
	}

	private static double calculate_bound(double[] x, Item[] items, int K, int index) {

		double upperBound = 0;
		
		//berechne die obere Schranke für alle Iteems
		for (int i = 0; i <= index; i++) {
			double weightForEachItem = x[i] * items[i].getWeight();
			upperBound += weightForEachItem * items[i].getRatio(); // U = B * c/a sozusagen
		}

		return upperBound;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String filepath = args[0];

		// scan file
		Scanner sc = new Scanner(new File(filepath));

		// erste Zahl ist die Anzahl der Gegenstände
		int n = sc.nextInt();

		// zweite Zahl ist die maximale Kapazität
		int K = sc.nextInt();
		Item[] items = new Item[n];

		for (int i = 0; i < n; i++) {
			// ab der zweiten Zeile ist die erste Zahl immer das Gewicht und die zweite Zahl
			// der Wert
			int weight = sc.nextInt();
			int value = sc.nextInt();
			items[i] = new Item(value, weight);
			System.out.println(items[i].getValue() +" "+ items[i].getWeight());
		}

		System.out.println(knapsack(items, K, n));
	}

}
