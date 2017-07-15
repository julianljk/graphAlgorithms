package graph;

import java.util.ArrayList;

public class DirectedVertex <T> extends Vertex <T> {
	private ArrayList <DirectedVertex <T>> incoming, outgoing; //a way to remember it, to me (incoming), and from me (outgoing)
	public DirectedVertex(T value, ArrayList<Vertex <T>> neighbors, ArrayList <Integer> directions) { //directions, 0 means node coming in is from, 1 means node coming in is to
		super(value, neighbors);
		incoming = new ArrayList <DirectedVertex <T>>();
		outgoing = new ArrayList <DirectedVertex <T>>();
		for(int i = 0; i < neighbors.size(); i++) {
			if(directions.get(i) == 1) {
				outgoing.add((DirectedVertex<T>) neighbors.get(i));
			}
			else {
				incoming.add((DirectedVertex<T>) neighbors.get(i)); 
			}
		}
	}
	public ArrayList <DirectedVertex <T>> getIncoming(){
		return incoming;
	}
	public ArrayList <DirectedVertex <T>> getOutgoing() {
		return outgoing;
	}

	public void addNeighbor(DirectedVertex <T> v, int direction) {
		super.addNeighbor(v);
		if(direction == 1) {
			outgoing.add(v);
		}
		else {
			incoming.add(v);
		}
	}
	public void addNeighbor(DirectedVertex <T> d) {
		 throw new UnsupportedOperationException();
	}
}
