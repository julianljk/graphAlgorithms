import graph.*;

public class UnionFind {
	public static void main (String [] args)  {
		MinimalGraph graph = new MinimalGraph();
		for(int i = 0; i < 3; i++) {
			graph.addVertice(i);
		}
		for(int i = 0; i < 3; i++) {
			if (i == 2) {
				graph.addEdge(new MinimalEdge(i, 0));
			}
			else {
				graph.addEdge(new MinimalEdge(i, i + 1));
			}
		}
		if(graph.isCycle()) {
			System.out.println("graph has cycle");
		}
		else {
			System.out.println("graph does not have cycle");
		}
		
	}
}
