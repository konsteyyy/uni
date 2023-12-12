package com.konsteyyy.git.uni.dea.mst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Kruskal {

	public static List<Edge> doKruskal(Graph G) {
		List<Edge> es = G.getEdges();

		// moeglich, weil wir in class Edge comparable implementiert haben
		Collections.sort(es);

		List<Edge> T = new ArrayList<>();

		UnionFindForest uff = new UnionFindForest(G.size(), G.getVertex());

		for (Edge e : es) {
			// union überprüft find(x) != find(y)
			// union verhindert, dass es zum Zyklus kommen kann, wenn naemlich find(x) ==
			// find(y),
			// dann waere es ein Zyklus
			boolean united = uff.union(e.getVertex1(), e.getVertex2());

			if (united)
				T.add(e);
		}
		return T;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String filepath = args[0];

		Scanner sc = new Scanner(new File(filepath));
		Graph G = new Graph();

		String s = sc.next();
		while (s != "a") {
			s = sc.next();
		}

		while (sc.hasNextInt()) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int cost = sc.nextInt();

			G.addEdge(u, v, cost);
		}

	}

}
