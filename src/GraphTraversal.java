import java.util.ArrayList;

import graph.*;

public class GraphTraversal {
	public static void main (String [] args) {
		Graph <Integer> graph = new Graph <Integer>();
		for(int i = 0; i < 9; i++) {
			graph.addVertice(i);
		}
		graph.addEdge(new Edge <Integer> (graph.getVertice(0), graph.getVertice(1), 4));
		graph.addEdge(new Edge <Integer> (graph.getVertice(0), graph.getVertice(7), 8));
		graph.addEdge(new Edge <Integer> (graph.getVertice(1), graph.getVertice(2), 8));
		graph.addEdge(new Edge <Integer> (graph.getVertice(1), graph.getVertice(7), 11));
		graph.addEdge(new Edge <Integer> (graph.getVertice(2), graph.getVertice(8), 2));
		graph.addEdge(new Edge <Integer> (graph.getVertice(2), graph.getVertice(3), 7));
		graph.addEdge(new Edge <Integer> (graph.getVertice(2), graph.getVertice(5), 4));
		graph.addEdge(new Edge <Integer> (graph.getVertice(3), graph.getVertice(5), 14));
		graph.addEdge(new Edge <Integer> (graph.getVertice(3), graph.getVertice(4), 9));
		graph.addEdge(new Edge <Integer> (graph.getVertice(4), graph.getVertice(5), 10));
		graph.addEdge(new Edge <Integer> (graph.getVertice(5), graph.getVertice(6), 2));
		graph.addEdge(new Edge <Integer> (graph.getVertice(6), graph.getVertice(8), 6));
		graph.addEdge(new Edge <Integer> (graph.getVertice(6), graph.getVertice(7), 1));
		graph.addEdge(new Edge <Integer> (graph.getVertice(7), graph.getVertice(8), 7));
		ArrayList <Edge<Integer>> edges = graph.getEdgesByWeight();
		
		//SANITY CHECKS
		for(Edge<Integer> e: edges) {
			System.out.println(e.getWeight());
		}
		for(Edge <Integer> e: graph.getEdgesByWeight()) {
			System.out.println(e.getSecond().getValue() + " -- " + e.getFirst().getValue() + " : W = " + e.getWeight());
		}
		System.out.println(graph.isCycle());
		//SANITY CHECKS
		
		
	}
}
