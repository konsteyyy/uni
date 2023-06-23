package com.konsteyyy.git.uni.dea.radixsort;


public class Bucket<T> extends Queue<T>{
	
	public Bucket() {
		super();
	}
	
	public T last() {
		return back.getData();
	}

}
