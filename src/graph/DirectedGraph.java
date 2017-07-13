package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class DirectedGraph<T> extends Graph <T>{
	public DirectedGraph() {
		vertices = new HashMap <T, Vertex <T> >();
		edges = new HashMap <Integer, Edge <T> >();
		V = 0;
		E = 0; 
	}
	@SuppressWarnings("unchecked")
	public void addEdge(Edge <T> e) { 
		super.addEdge(e);
		DirectedVertex <Integer> first = (DirectedVertex <Integer>) e.getFirst();
		DirectedVertex <Integer> second = (DirectedVertex <Integer>) e.getSecond();
		first.addNeighbor(second, 1);
		second.addNeighbor(first, 0);
	}
	public void addVertice(T v) {
		if(vertices.containsKey(v)) {
			System.out.println(v + " already exists");
		}
		else {
			vertices.put(v, new DirectedVertex <T>(v, new ArrayList<Vertex <T>>(), new ArrayList <Integer>()));
			V++;
		}
	}
}
