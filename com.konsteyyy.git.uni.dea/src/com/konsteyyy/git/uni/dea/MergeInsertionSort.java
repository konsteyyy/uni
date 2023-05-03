package com.konsteyyy.git.uni.dea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeInsertionSort {

	public static void sort(int[] A, int p, int r, int k) {
		if(r-p+1>k ) {
			int q= (p+r)/2;
			sort(A,p,q,k);
			sort(A,q+1,r,k);
			MergeSort.merge(A, p, q, r);
		} else {
			InsertionSort.sort(A,p,r);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String file = args[0];
		int k = Integer.parseInt(args[1]);
		
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
		
		sort(array, 0, array.length-1, k);
		
		for(int i=0; i<array.length; i++)
			System.out.println(array[i]);
	}
}
