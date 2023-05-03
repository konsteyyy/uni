package com.konsteyyy.git.uni.dea;
import InsertionSort;

public class MergeInsertionSort {

	public static void sort(int[] A, int p, int r, int k) {
		if(r-p+1>k ) {
			int q= Math.round((p+r)/2);
			sort(A,p,q,k);
			sort(A,q+1,r,k);
			Merge.sort(A, p, q, r);
		} else {
			InsertionSort.sort(A,p,r);
		}
	}
	
}
