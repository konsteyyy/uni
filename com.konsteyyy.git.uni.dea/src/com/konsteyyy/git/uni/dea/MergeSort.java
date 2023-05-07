package com.konsteyyy.git.uni.dea;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class MergeSort {
	
	public static void sort(int[] A, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			sort(A, p, q);
			sort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void merge(int[] A, int p, int q, int r) {
	    int n1 = q - p + 1;
	    int n2 = r - q;
	    int[] L = new int[n1 + 1];
	    int[] R = new int[n2 + 1];

	    for (int i = 0; i < n1; i++) {
	        L[i] = A[p + i];
	    }

	    for (int j = 0; j < n2; j++) {
	        R[j] = A[q + j + 1];
	    }

	    L[n1] = Integer.MAX_VALUE;
	    R[n2] = Integer.MAX_VALUE;

	    int i = 0;
	    int j = 0;

	    for (int k = p; k <= r; k++) {
	        if (L[i] <= R[j]) {
	            A[k] = L[i];
	            i++;
	        } else {
	            A[k] = R[j];
	            j++;
	        }
	    }
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		String file = args[0];
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
		sort(array, 0, array.length-1);
		long ende  = System.currentTimeMillis();
		
		for(int i=0; i<array.length; i++)
			System.out.println(array[i]);
		
		System.out.println("Benötigte Zeit:" + (ende-start));
	}
}
