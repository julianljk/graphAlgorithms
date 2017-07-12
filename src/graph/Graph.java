package graph;

import java.util.*;

public class Graph <T> {
	HashMap <T, Vertex <T>> vertices;
	HashMap <Integer, Edge <T>> edges;
	int V, E;
	public Graph() {
		vertices = new HashMap <T, Vertex <T> >();
		edges = new HashMap <Integer, Edge <T> >();
		V = 0;
		E = 0; 
	}
	public void addEdge(Edge <T> e) { 
		if(!vertices.containsKey(e.getFirst().getValue())){
			System.out.println("graph does not contain vertex " + e.getFirst().getValue());
		}
		else if (!vertices.containsKey(e.getSecond().getValue())) {
			System.out.println("graph does not contain vertex" + e.getFirst().getValue());
		}
		else if(edges.containsKey(e.hashCode())) {
			System.out.println("graph already contains this edge");
		}
		else {
			e.getFirst().addNeighbor(e.getSecond());
			e.getSecond().addNeighbor(e.getFirst());
			edges.put(e.hashCode(), e);
			E++;
		}
	}
	public Edge <T> removeEdge(T to, T from, int weight) {
		return edges.remove(this.getEdgeWhere(to, from, weight).hashCode());
	}
	public Edge <T> removeEdge(MinimalEdge e) {
		return edges.remove(e.hashCode());
	}
	public int getEdgeCount() {
		return E; 
	}
	public int getVerticeCount() {
		return V; 
	}
	public Edge <T> getEdgeWhere(T to, T from, int weight) { 
		for(Edge <T> e: edges.values()) {
			if(e.getSecond().getValue() == from && e.getFirst().getValue() == to && e.getWeight() == weight) {
				return e;
			}
		}
		return null;
	}
	public HashMap<Integer, Edge<T>> getEdges() { 
		return edges;
	}
	public ArrayList <Edge <T>> getEdgesByWeight() {
		ArrayList <Edge <T>> list = new ArrayList<Edge <T>> (edges.values());
		list.sort((a, b) -> a.getWeight() - b.getWeight());
		return list;
	}
	public void addVertice(T v) {
		if(vertices.containsKey(v)) {
			System.out.println(v + " already exists");
		}
		else {
			vertices.put(v, new Vertex <T>(v, new ArrayList<Vertex <T>>()));
			V++;
		}
	}
	public void setVertices(HashMap <T, Vertex <T>> v) {
		vertices = v;
	}
	public HashMap <T, Vertex <T>> getVertices() {
		return vertices;
	}
	public Vertex <T> getVertice(T val) {
		if(vertices.containsKey(val)) {
			return vertices.get(val);
		}
		return null;
	}
	public boolean isCycle() {
		HashMap <T, T> parents = new HashMap <T, T>(); //vertex value, parent
		HashMap <T, Integer> depths = new HashMap <T, Integer>();
		
		Iterator <Vertex<T>> itr = vertices.values().iterator();
		Vertex <T> currV; 
		while(itr.hasNext()) {
			currV = itr.next();
			parents.put(currV.getValue(), currV.getValue());
			depths.put(currV.getValue(), 0);
		}
		for(Edge <T> curr: edges.values()) {
			T to = find(parents, curr.getFirst().getValue());
			T from = find(parents, curr.getSecond().getValue());
			if (to == from) {
				return true;
			}
			union(parents, to, from, depths);	
		}
		return false;
	}
	public void union(HashMap <T, T> parents, T to, T from, HashMap <T, Integer> depths) {
		int d1 = depths.get(to);
		int d2 = depths.get(from);
		
		if (d2 > d1) {
			parents.put(to, from);
		}
		else if (d1 > d2) {
			parents.put(from, to);
		}
		else {
			parents.put(from, to);
			depths.put(to, depths.get(to) + 1);
		}
	}
	public T find(HashMap<T, T> parents, T v) {
		if(parents.get(v) != v) {
			parents.put(v, find(parents, parents.get(v)));
		}
		return parents.get(v);
	}
}
