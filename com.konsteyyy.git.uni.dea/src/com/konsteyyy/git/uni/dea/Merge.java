package com.konsteyyy.git.uni.dea;

public class Merge {
	public static void sort(int[] A, int p, int q, int r) {
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i=1; i<=n1; i++) {
			L[i] = A[p+i-1];
		}
		for(int j=1; j<=n2; j++) {
			R[j] = A[q+j];
		}
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i=1;
		int j=1;
		
		for(int k=p; k<=r; k++) {
			if(L[i]<=R[i]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}	
		}
	}
}
