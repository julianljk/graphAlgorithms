package graph;

import java.util.HashMap;

public class DirectedGraph<T> extends Graph <T>{
	public DirectedGraph() {
		vertices = new HashMap <T, Vertex <T> >();
		edges = new HashMap <Integer, Edge <T> >();
		V = 0;
		E = 0; 
	}
	public void thing() {
		DirectedGraph <Integer> my = new DirectedGraph <Integer>(); 
		my.vertices.put(1, new DirectedVertex <Integer>(null,null,null));
	}
	
}
