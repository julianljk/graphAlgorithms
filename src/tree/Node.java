package tree;

public class Node <T> {
	public Node <T> left, right; 
	public T value;
	public Node(Node <T> l, Node <T> r, T v) {
		left = l; 
		right = r; 
		value = v;
	}
}
