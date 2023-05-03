package com.konsteyyy.git.uni.dea;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class MergeSort {
	
	public static void sort(int[] A, int p, int r) {
		if(p>r) {
			int q = Math.round((p+r)/2);
			sort(A, p, q);
			sort(A, q+1, r);
			Merge.sort(A, p, q, r);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String file = args[0];
		ArrayList<Integer> array = new ArrayList<Integer>();		

		Scanner sc = new Scanner(new File(file));
		
		for(int i = 0; sc.hasNextInt(); i++) {
			array.add(sc.nextInt());
		}
	}
}
