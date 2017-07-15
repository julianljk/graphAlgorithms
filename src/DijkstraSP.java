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
		
		HashMap <Integer, Integer> spt = findShortestPath(graph, 0);
		for(Map.Entry <Integer, Integer> e: spt.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
	}
	public static HashMap <Integer, Integer> findShortestPath(MinimalGraph graph, int from) {
		HashSet <Integer> SPT = new HashSet <Integer>(); 
		HashMap <Integer, Integer> distances = new HashMap <Integer, Integer>();
		graph.getVertices().forEach( v -> distances.put(v, Integer.MAX_VALUE));
		distances.put(0, 0);
		int curr; 
		ArrayList<MinimalEdge> neighbors; 
		while(SPT.size() < graph.getVerticeCount()) {
			curr = getMinVertex(SPT, distances);
			SPT.add(curr);
			neighbors = getNeighbors(graph, curr); 
			int other; 
			for(MinimalEdge e: neighbors) {
				other = e.getFrom() == curr ? e.getTo() : e.getFrom(); 
				if(distances.get(other) > distances.get(curr) + e.getWeight()){
					distances.put(other, distances.get(curr) + e.getWeight());
				}
			}
		}
		
		return distances;
	}
	private static int getMinVertex(HashSet <Integer> spt, HashMap <Integer,Integer> distances) {
		int max = Integer.MAX_VALUE;
		int node = -1;
		for (Map.Entry<Integer, Integer> e: distances.entrySet()) {
			if (e.getValue() < max && !spt.contains(e.getKey())) {
				max = e.getValue();
				node = e.getKey();
			}
		}
		return node;
	}
	private static ArrayList <MinimalEdge> getNeighbors(MinimalGraph graph, int v) {
		ArrayList <MinimalEdge> list = new ArrayList <MinimalEdge>();
		for(MinimalEdge e: graph.getEdges().values()) {
			if(e.getFrom() == v || e.getTo() == v) {
				list.add(e);
			}
		}
		return list; 
	}
}
