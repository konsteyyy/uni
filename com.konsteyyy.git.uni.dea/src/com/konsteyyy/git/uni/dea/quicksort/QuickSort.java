package com.konsteyyy.git.uni.dea.quicksort;

import java.util.Arrays;

public class QuickSort {
	public static void sort(int[] A, String strategy) {
		int p  = switch(strategy) {
			case "first" -> A[0];
			case "random" -> random(A);
			case "median3" -> median3(A);
			default -> -1;
		};
		
		
	}
	
	private static void QSORT(int[] A)
	
	private static int random(int[] A) {
		return (int) Math.random() * A.length;
	}

	private static int median3(int[] A) {
		int i = (int) Math.random() * A.length;
		int j;
		int k;
		do {
			j = (int) Math.random() * A.length;
			k = (int) Math.random() * A.length;
		} while(i!=j && i!=k && j!=k);
		
		int[] temp = {A[i], A[j], A[k]};
		Arrays.sort(temp);
		
		return temp[1];
	}
}
