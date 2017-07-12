import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
		
		
		BFS(graph, 0, 8);
	}
	public static void BFS(Graph <Integer> graph, int from, int to) {
		//BFS is a queue
		//DFS is a stack
		LinkedList <Vertex <Integer>> queue = new LinkedList <Vertex <Integer>>();
		HashMap <Integer, Integer> parents = new HashMap <Integer, Integer>(); 
		HashSet <Vertex <Integer>> visited = new HashSet <Vertex <Integer>>();
		Iterator <Integer> itr = graph.getVertices().keySet().iterator();
		while(itr.hasNext()) {
			parents.put(itr.next(), null);
		}
		Vertex <Integer> initialNode = graph.getVertice(from);
		queue.add(initialNode);
		visited.add(initialNode);
		
		Vertex <Integer> curr = null; 
		ArrayList<Vertex<Integer>> currNeighbors;
		while(queue.size() != 0) {
			curr = queue.poll(); 
			currNeighbors = curr.getNeighbors();
			//look for all other neighbours of that node
			for(int i = 0; i < currNeighbors.size(); i++) {
				if(!visited.contains(currNeighbors.get(i))){
					visited.add(currNeighbors.get(i));
					queue.add(currNeighbors.get(i));
					parents.put(currNeighbors.get(i).getValue(), curr.getValue());
				}
			}
		}
		Integer vIndex = to;
		currNeighbors = new ArrayList <Vertex <Integer>>();
		while(vIndex != null) {
			System.out.print(graph.getVertice(vIndex).getValue() + " -> ");
			vIndex = parents.get(vIndex);
		}
	}
}
