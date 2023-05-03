package com.konsteyyy.git.uni.dea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSort {
	
	public static void sort(int[] A) {
		for(int j=0; j<A.length; j++) {
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
		int[] array;
		int lineNumber=0;

		Scanner sc = new Scanner(new File(file));
		
		//get the number of lines of the file
		while(sc.hasNextLine()) {
			sc.nextLine();
			lineNumber++;
		}
		
		array = new int[lineNumber];
		
		//get all integers from the file
		sc = new Scanner(new File(file));
		for(int i = 0; sc.hasNextInt(); i++)
			array[i] = sc.nextInt();
		
		//apply the sort method on the array and return it to the console
		sort(array);
		for(int i=0; i<array.length; i++)
			System.out.println(array[i]);
	}
}
