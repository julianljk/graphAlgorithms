package graph;

import java.util.ArrayList;
import java.util.Objects;

public class Vertex <T> {
	private T value;
	private ArrayList <Vertex <T>> neighbors;
	public Vertex(T value, ArrayList<Vertex <T>> neighbors) {
		this.value = value; 
		this.neighbors = neighbors;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public void addNeighbor(Vertex <T> v) {
		neighbors.add(v);
	}
	public Vertex <T> getNeighborAt(int i) {
		if(i < neighbors.size()) {
			return neighbors.get(i);
		}
		return null;
	}
	public ArrayList <Vertex <T>> getNeighbors() {
		return neighbors;
	}
	public boolean equals(Vertex<T> v) {
		return value == v.getValue();
	}
	public int hashCode() {
		return Objects.hash(value);
	}
	public String toString(){
		return value.toString();
	}
	//need to get
}
