package com.konsteyyy.git.uni.dea.mergeinsertionsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
	
	public static void sort(int[] A, int p, int r) {
		for(int j=p; j<=r; j++) {
			int key = A[j];
			int i=j-1;
			while(i>=0 && A[i]>key) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		String file = args[0];
		ArrayList<Integer> list = new ArrayList<Integer>();		

		//scan file and add all int to list
		Scanner sc = new Scanner(new File(file));
		for(int i = 0; sc.hasNextInt(); i++) {
			list.add(sc.nextInt());
		}
		
		//convert the list into an array
		int[] array = new int[list.size()];
		for(int i=0; i<array.length; i++) {
			array[i] = list.get(i);
		}
		
		sort(array, 0,array.length);
		
		for(int i=0; i<array.length; i++)
			System.out.println(array[i]);
	}
}
