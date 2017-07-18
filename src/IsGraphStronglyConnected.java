import java.util.Arrays;

import graph.*;

public class IsGraphStronglyConnected {
    public static void main (String [] args) { 
        DirectedGraph <Integer> graph = new DirectedGraph <Integer>(); 
        for (int i = 0; i < 5; i++) {
            graph.addVertice(i);   
        }
        graph.addEdge(new Edge <Integer> (graph.getVertice(0), graph.getVertice(1)));
        graph.addEdge(new Edge <Integer> (graph.getVertice(1), graph.getVertice(2)));
        //graph.addEdge(new Edge <Integer> (graph.getVertice(2), graph.getVertice(4)));
        graph.addEdge(new Edge <Integer> (graph.getVertice(4), graph.getVertice(2)));
        graph.addEdge(new Edge <Integer> (graph.getVertice(2), graph.getVertice(3)));
        graph.addEdge(new Edge <Integer> (graph.getVertice(3), graph.getVertice(0)));
        
        System.out.println(isSC(graph));
    }
    public static boolean isSC(DirectedGraph <Integer> graph) { //O(V + E) = 2 DFS O(V + E) searches + 2 O(V) loops over visited array
       
        boolean [] visited = new boolean [graph.getVerticeCount()]; 
        Arrays.fill(visited, false);
        DFSUtil(visited, (DirectedVertex <Integer>) graph.getVertice(0));
        
        for(boolean i: visited) {
            if(!i) {
                return false; 
            }
        }
        Arrays.fill(visited, false);
        DFSUtil(visited, (DirectedVertex <Integer>) graph.getVertice(0));
        for(boolean i: visited) {
            if(!i) {
                return false; 
            }
        }
        return true;
    }
    public static void DFSUtil(boolean [] visited, DirectedVertex <Integer> curr) {
        visited[curr.getValue()] = true;
        for(DirectedVertex <Integer> i: curr.getOutgoing()) {
            if(!visited[i.getValue()]) {
                DFSUtil(visited, i); 
            }
        }
    }
    public static void getGraphTranspose(DirectedGraph <Integer> graph) {
        for(Edge <Integer> e: graph.getEdges().values()) {
        	graph.addEdge(new Edge<Integer> (e.getSecond(), e.getFirst()));
        	graph.removeEdge(e);
        }
    }
}