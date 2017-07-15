import graph.*;

public class TopologicalSorting {
	@SuppressWarnings("unchecked")
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
}
