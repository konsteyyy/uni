package com.konsteyyy.git.uni.dea.mst;

import java.util.LinkedList;
import java.util.List;

public class UnionFindArray {
	
	private List<Integer>[] component;
	
	public UnionFindArray(int size) {
		component = new List[size];
	}
	
	public void MAKE_SET(int x) {
		this.component[x] = new LinkedList<Integer>();
		this.component[x].add(x);
	}
	
	public int FIND(int x) {
		return this.component[x].get(0);
	}
	
	public void UNION(int x, int y) {
		if(component[x].size() > component[y].size()) {
			component[x].addAll(component[y]);
		} else {
			component[y].addAll(component[x]);
		}
	}
}
