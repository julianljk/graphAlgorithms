package graph;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MinimalGraph {
	int V,E; //number of vertices and edges
	HashSet <Integer> vertices;
	HashMap <Integer, MinimalEdge> edges; 
	
	public MinimalGraph() {
		V = 0;
		E = 0;
		vertices = new HashSet <Integer>();
		edges = new HashMap <Integer, MinimalEdge>();
	}
	public void addEdge(MinimalEdge e) {
		if(!vertices.contains(e.getTo())){
			System.out.println("graph does not contain vertex " + e.getTo());
		}
		else if (!vertices.contains(e.getFrom())) {
			System.out.println("graph does not contain verter" + e.getFrom());
		}
		else if(edges.containsKey(e.hashCode())) {
			System.out.println("graph already contains this edge");
		}
		else {
			edges.put(e.hashCode(), e);
			E++;
		}
	}
	public MinimalEdge removeEdge(int to, int from, int weight) {
		return edges.remove(this.getEdgeWhere(to, from, weight).hashCode());
	}
	public MinimalEdge removeEdge(MinimalEdge e) {
		return edges.remove(e.hashCode());
	}
	public int getEdgeCount() {
		return E; 
	}
	public int getVerticeCount() {
		return V; 
	}
	public MinimalEdge getEdgeWhere(int to, int from, int weight) {
		for(MinimalEdge e: edges.values()) {
			if(e.getFrom() == from && e.getTo() == to && e.getWeight() == weight) {
				return e;
			}
		}
		return null;
	}
	public HashMap<Integer, MinimalEdge> getEdges() { 
		return edges;
	}
	public ArrayList <MinimalEdge> getEdgesByWeight() {
		ArrayList <MinimalEdge> list = new ArrayList<MinimalEdge> (edges.values());
		list.sort((a, b) -> a.getWeight() - b.getWeight());
		return list;
	}
	public void addVertice(int v) {
		if(vertices.contains(v)) {
			System.out.println(v + " already exists");
		}
		else {
			vertices.add(v);
			V++;
		}
	}
	public void setVertices(HashSet <Integer> v) {
		vertices = v;
	}
	public HashSet <Integer> getVertices() {
		return vertices;
	}
	public boolean isCycle() {
		HashMap <Integer, Integer> parents = new HashMap <Integer, Integer>(); //vertex value, parent
		HashMap <Integer, Integer> depths = new HashMap <Integer, Integer>();
		
		Iterator <Integer> itr = vertices.iterator();
		int currV; 
		while(itr.hasNext()) {
			currV = itr.next();
			parents.put(currV, currV);
			depths.put(currV, 0);
		}
		for(MinimalEdge curr: edges.values()) {
			int to = find(parents, curr.getTo());
			int from = find(parents, curr.getFrom());
			if (to == from) {
				return true;
			}
			union(parents, to, from, depths);	
		}
		return false;
	}
	public void union(HashMap <Integer, Integer> parents, int to, int from, HashMap <Integer, Integer> depths) {
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
	public int find(HashMap<Integer, Integer> parents, int v) {
		if(parents.get(v) != v) {
			parents.put(v, find(parents, parents.get(v)));
		}
		return parents.get(v);
	}
}
