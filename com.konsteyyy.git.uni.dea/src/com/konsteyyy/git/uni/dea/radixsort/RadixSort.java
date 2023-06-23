package com.konsteyyy.git.uni.dea.radixsort;

import java.util.Arrays;
import java.util.OptionalInt;

public class RadixSort {

	
	
	public static void sort(int[] A) {
		int N = Arrays.stream(A).map(a -> a).max().getAsInt();
		Bucket<Integer>[] buckets = new Bucket[N];
		
		for(int a: A) {
			buckets.
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
