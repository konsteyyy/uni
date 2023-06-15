package com.konsteyyy.git.uni.dea.quicksort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
	public static void sort(int[] A, String strategy) {
		QSORT(A, 0, A.length-1, strategy);
	}
	
	private static void QSORT(int[] A, int l, int r, String strategy)  {
		if(l>=r) return;
		//Abbruch bei leerem oder einelementigem Feld
		
		int q = PARTITION(A, l, r, strategy);
		QSORT(A, l, q-1, strategy);
		QSORT(A, q+1, r, strategy);
	}
	
	private static int PARTITION(int[] A, int l, int r, String strategy) {
		int p  = switch(strategy) {
			case "first" -> l; //das erste Element des aktuellen Teilfeldes wird das Pivotelement sein
			case "random" -> random(l, r); //ein zufälliges Element des Teilfeldes wird das Pivotelement sein
			case "median3" -> median3(A, l, r); //ein median aus drei zufällig gewählten Elementen des teilfeldes wird ausgewählt
			default -> -1;
		};
		
		int x = A[p]; //x ist Pivotelement
		
		//vertausche A[p] und A[r]
		swapItems(A, p, r);
		
		int i = l-1;
		for(int j=l; j<=r-1; j++) {
			if(A[j] <= x) {
				i++;
				swapItems(A,i,j);
			}
		}
		swapItems(A, i+1, r);
		return i+1;
	}

	private static int random(int l, int r) {
		return l + (int) (Math.random() * (r - l + 1));
	}

	private static int median3(int[] A, int l, int r) {
	    int i = l + (int) (Math.random() * (r - l + 1));
	    int j;
	    int k;
	    do {
	        j = l + (int) (Math.random() * (r - l + 1));
	        k = l + (int) (Math.random() * (r - l + 1));
	    } while (i != j && i != k && j != k);

	    if ((i > j && i < k) || (i < j && i > k)) {
	        return i;
	    } else if ((j > i && j < k) || (j < i && j > k)) {
	        return j;
	    } else {
	        return k;
	    }
	}
	
	private static void swapItems(int[] A, int item1, int item2) {
		int temp = A[item1];
		A[item1] = A[item2];
		A[item2] = temp;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String file = args[0];
		String strategy = args[1];
		ArrayList<Integer> list = new ArrayList<Integer>();		

		//scan file and add all int to list
		Scanner sc = new Scanner(new File(file));
		while(sc.hasNextInt()) {
			list.add(sc.nextInt());
		}
		
		//convert the list into an array
		int[] array = new int[list.size()];
		for(int i=0; i<array.length; i++) {
			array[i] = list.get(i);
		}
		
		long start = System.currentTimeMillis();
		sort(array, strategy);
		long ende  = System.currentTimeMillis();
		
		for(int i=0; i<array.length; i++)
			System.out.println(array[i]);
		
		System.out.println("Benötigte Zeit:" + (ende-start));
	}
}
