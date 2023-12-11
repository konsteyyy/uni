package com.konsteyyy.git.uni.dea.mst;

import java.util.TreeSet;

public class UnionFindForest {

	private int[] p;
	private int[] rank;
	
	public UnionFindForest(int size) {
		p= new int[size];
		rank = new int[size];
	}
	
	public void makeset(int x) {
		p[x] = x;
		rank[x] = 0;
	}
	
	public int find(int x) {
		if(p[x] != x) {
			p[x] = find(p[x]);
		}
		
		return p[x];
	}
	
	public void union(int x, int y) {
		if(find(x) != find(y)) {
			link(find(x),find(y));
		}
	}
	
	public void link(int x, int y) {
		if(rank[x]>rank[y]) {
			p[y] = x;
		} else {
			if(rank[x] == rank[y]) {
				rank[y] = rank[y] +1;
			}
		}
	}
}
