package graph;

public class Edge <T> implements Comparable <Edge>{
	private Vertex <T> first, second;
	private int weight;
	public Edge(Vertex <T> a, Vertex <T> b) {
		this(a, b, 1);
	}
	public Edge(Vertex <T> a, Vertex <T> b, int weight) {
		first = a; 
		second = b; 
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Vertex <T> getFirst() {
		return first;
	}
	public Vertex <T> getSecond() {
		return second;
	}
	public void setFirst(Vertex <T> v) {
		if(!v.equals(second)) {
			first = v;
		}
		System.out.println("Cannot set first vertex to equal second");
	}
	
	public void setSecond(Vertex <T> v) {
		if(!first.equals(v)) {
			second = v;
		}
		System.out.println("Cannot set second vertex to equal first");
	}
	@Override
	public int compareTo(Edge e) {
		return weight - e.getWeight();
	}
}
