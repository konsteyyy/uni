package com.konsteyyy.git.uni.dea.mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	
	private Map<Integer, List<Edge>> adjacencyList;
	private List<Edge> Edges;
	
	public Graph() {
		adjacencyList = new HashMap<>();
		Edges = new ArrayList<>();
	}
	
	public void addVertex(int vertex) {
		adjacencyList.put(vertex, new ArrayList<>());
	}
	
	public void addEdge(int vertex1, int vertex2, int cost) {
		//da der Graph ungerichtet ist, müssen wir bei beiden Knoten die Adjazenz hinzufügen
		Edge e1 = new Edge(vertex1, vertex2, cost);
		Edge e2 = new Edge(vertex2, vertex1, cost);
		adjacencyList.get(vertex1).add(new Edge(vertex1, vertex2, cost));
		adjacencyList.get(vertex2).add(new Edge(vertex2, vertex1, cost));
		
		//in der Liste Edges speichern wir aber jede Kante nur einmal, um Duplikate zu vermeiden
		Edges.add(e1);
	}
	
	public List<Edge> getEdges() {
		return Edges;
	}
	
}
