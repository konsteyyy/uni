package com.konsteyyy.git.uni.dea.mst;

public class Edge implements Comparable<Edge> {
	
	private int vertex1;
	private int vertex2;
	private int cost;
	
	public Edge(int vertex1, int vertex2, int cost) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getVertex1() {
		return vertex1;
	}

	public void setVertex1(int vertex1) {
		this.vertex1 = vertex1;
	}

	public int getVertex2() {
		return vertex2;
	}

	public void setVertex2(int vertex2) {
		this.vertex2 = vertex2;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.cost, o.getCost());
	}
	
}
