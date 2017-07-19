import java.util.Arrays;

import graph.*;

public class GetArticulationPoints {
    static int discIndex = 0;
    public static void main(String [] args) {
        Graph <Integer> graph = new Graph <Integer>(); 
        for(int i = 0; i < 5; i++) {
            graph.addVertice(i);
        }
        graph.addEdge(new Edge <Integer> (graph.getVertice(1), graph.getVertice(0)));
        graph.addEdge(new Edge <Integer> (graph.getVertice(0), graph.getVertice(2)));
        graph.addEdge(new Edge <Integer> (graph.getVertice(2), graph.getVertice(1)));
        graph.addEdge(new Edge <Integer> (graph.getVertice(0), graph.getVertice(3)));
        graph.addEdge(new Edge <Integer> (graph.getVertice(3), graph.getVertice(4)));
        getCutVertex(graph);
    }
    public static void getCutVertex(Graph <Integer> graph) {
        int [] parents = new int [graph.getVerticeCount()]; 
        boolean [] visited = new boolean [graph.getVerticeCount()]; 
        int [] low = new int [graph.getVerticeCount()];
        int [] disc = new int [graph.getVerticeCount()]; 
        boolean [] ap = new boolean [graph.getVerticeCount()]; 
        
        Arrays.fill(parents, -1); 
        Arrays.fill(visited, false); 
           
        for(Vertex <Integer> i: graph.getVertices().values()) {
            if(!visited[i.getValue()]) {
                cutVertexUtil(i, parents, visited, low, disc, ap);     
            }
        }
        for(int i = 0; i < ap.length; i++) {
        	if(ap[i]) {
        		System.out.println(i);
        	}
        }
    }
    public static void cutVertexUtil(Vertex <Integer> u, int [] parents, boolean [] visited, int [] low, int [] disc, boolean [] ap) {
        int uVal = u.getValue(); 
        visited[uVal] = true; 
        disc[uVal] = low[uVal] = ++discIndex; 
        
        for(Vertex <Integer> v: u.getNeighbors()) {
            int vVal = v.getValue(); 
            if(!visited[vVal]) {
                parents[vVal] = uVal; 
                cutVertexUtil(v, parents, visited, low, disc, ap); 
                low[uVal] = Math.min(low[uVal], low[vVal]); 
                
                if(parents[uVal] == -1 && u.getNeighbors().size() >= 2) {
                    ap[uVal] = true;
                }
                else if(parents[uVal] != -1 && disc[uVal] >= low[vVal]){
                    ap[uVal] = true;
                }
            }
            else if (parents[uVal] != vVal) {
                low[uVal] = Math.min(low[uVal], disc[vVal]); 
            }
        }
    }
}
