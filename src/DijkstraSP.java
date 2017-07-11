import java.util.*;
import graph.*;

public class DijkstraSP {
	public static void main (String [] args) {
		MinimalGraph graph = new MinimalGraph();
		for(int i = 0; i < 9; i++) {
			graph.addVertice(i);
		}
		graph.addEdge(new MinimalEdge(0, 1, 4));
		graph.addEdge(new MinimalEdge(0, 7, 8));
		graph.addEdge(new MinimalEdge(1, 2, 8));
		graph.addEdge(new MinimalEdge(1, 7, 11));
		graph.addEdge(new MinimalEdge(2, 8, 2));
		graph.addEdge(new MinimalEdge(2, 3, 7));
		graph.addEdge(new MinimalEdge(2, 5, 4));
		graph.addEdge(new MinimalEdge(3, 5, 14));
		graph.addEdge(new MinimalEdge(3, 4, 9));
		graph.addEdge(new MinimalEdge(4, 5, 10));
		graph.addEdge(new MinimalEdge(5, 6, 2));
		graph.addEdge(new MinimalEdge(6, 8, 6));
		graph.addEdge(new MinimalEdge(6, 7, 1));
		graph.addEdge(new MinimalEdge(7, 8, 7));
		
		
	}
	public static int findShortestPath(MinimalGraph graph, int from, int to) {
		HashSet <Integer> SPT = new HashSet <Integer>(); 
		HashMap <Integer, Integer> distances = new HashMap <Integer, Integer>();
		graph.getVertices().forEach( v -> distances.put(v, Integer.MAX_VALUE));
		distances.put(0, 0);
		while(SPT.size() < graph.getVerticeCount()) {
			
		}
		
		return 1;
	}
}
