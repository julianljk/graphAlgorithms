import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import graph.*;
public class KruskalMST {
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
		ArrayList <MinimalEdge> edges = graph.getEdgesByWeight();
		
		for(MinimalEdge e: edges) {
			System.out.println(e.getWeight());
		}
		MinimalGraph arr= getMST(graph);
		for(MinimalEdge e: arr.getEdgesByWeight()) {
			System.out.println(e.getFrom() + " -- " + e.getTo() + " : W = " + e.getWeight());
		}
		//sort edges by weight; 
	}
	public static MinimalGraph getMST(MinimalGraph graph) {
		int count = 0;
		MinimalGraph mst = new MinimalGraph(); 
		mst.setVertices(graph.getVertices());
		
		HashMap <Integer, Integer> parents = new HashMap <Integer, Integer>(); 
		HashMap <Integer, Integer> depth = new HashMap <Integer, Integer>(); 
		Iterator<Integer> itr = graph.getVertices().iterator();
		while(itr.hasNext()) {
			int next = itr.next();
			parents.put(next, next);
			depth.put(next, 0);
		}
		for(MinimalEdge e: graph.getEdgesByWeight()) { //E LOG E
			int toParent = graph.find(parents, e.getTo()); 
			int fromParent = graph.find(parents, e.getFrom());
			
			if (toParent == fromParent) {
				continue;
			}
			else {
				mst.addEdge(e);
				graph.union(parents, toParent, fromParent, depth);
				if(++count == graph.getVerticeCount() - 1) {
					break;
				}
			}
		}
		return mst; 
	}
}
