package graph;

import java.util.Objects;

public class MinimalEdge implements Comparable <MinimalEdge>{
	private int to, from;
	private int weight;
	public MinimalEdge(int a, int b) {
		this(a, b, 1);
	}
	public MinimalEdge(int to, int from, int weight) {
		this.to = to; 
		this.from = from; 
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getTo() {
		return to;
	}
	public int getFrom() {
		return from;
	}
	public void setTo(int v) {
		if(from != v) {
			to = v;
		}
		System.out.println("Cannot set first vertex to equal second");
	}
	
	public void setFrom(int v) {
		if(to !=v) {
			from = v;
		}
		System.out.println("Cannot set second vertex to equal first");
	}
	@Override
	public int compareTo(MinimalEdge e) {
		return weight - e.getWeight();
	}
	public boolean equals(MinimalEdge e) {
		return to == e.getTo() && from == e.getFrom();
	}
	public int hashCode() {
		return Objects.hash(to, from);
	}
}
