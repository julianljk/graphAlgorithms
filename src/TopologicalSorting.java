import java.util.HashMap;
import java.util.Stack;

import graph.*;

public class TopologicalSorting {
	public static void main (String [] args) {
		DirectedGraph <Integer> dag = new DirectedGraph <Integer>();
		for(int i = 0; i < 6; i++) {
			dag.addVertice(i);
		}
		dag.addEdge(new Edge <Integer>(dag.getVertice(4),dag.getVertice(0)));
		dag.addEdge(new Edge <Integer>(dag.getVertice(5),dag.getVertice(0)));
		dag.addEdge(new Edge <Integer>(dag.getVertice(5),dag.getVertice(2)));
		dag.addEdge(new Edge <Integer>(dag.getVertice(4),dag.getVertice(1)));
		dag.addEdge(new Edge <Integer>(dag.getVertice(2),dag.getVertice(3)));
		dag.addEdge(new Edge <Integer>(dag.getVertice(3),dag.getVertice(1)));
		printGraph(dag);
		System.out.println("Topological Sort Result: ");
		topologicalSort(dag);
	}
	public static void printGraph(DirectedGraph <Integer> dag) {
		for(Vertex<Integer> v: dag.getVertices().values()) {
			DirectedVertex <Integer> curr = (DirectedVertex <Integer>) v;
			System.out.println("Processing Node: " + v.getValue());
			for(DirectedVertex <Integer> neighbor: curr.getOutgoing()) {
				System.out.println("    -> " + neighbor.getValue());
			}
			for(DirectedVertex <Integer> neighbor: curr.getIncoming()) {
				System.out.println("    <- " + neighbor.getValue());
			}
		}
	}
	public static void topologicalSort(DirectedGraph <Integer> dag) { //O(V + E)
		Stack <Integer> stack = new Stack <Integer>(); 
		HashMap <Integer, Boolean> visited = new HashMap <Integer, Boolean> (); 
		
		for(Integer i: dag.getVertices().keySet()) { //O(V)
			visited.put(i, false); 
		}
		for(Vertex <Integer> v: dag.getVertices().values()) { //O(V)
			if(!visited.get(v.getValue())) {
				topologicalSortHelper(visited, stack, (DirectedVertex <Integer>) v);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " -> "); 
		}
		
	}
	private static void topologicalSortHelper(HashMap <Integer, Boolean> visited, Stack <Integer> stack, DirectedVertex <Integer> curr) {
		visited.put(curr.getValue(), true);
		for(DirectedVertex <Integer> v: curr.getOutgoing()) { //O(E)
			if(!visited.get(v.getValue())) {
				topologicalSortHelper(visited, stack, v);
			}
		}
		stack.push(curr.getValue());
	}
}
