//Source: http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/

import java.util.ArrayList;
import java.util.HashMap;

import tree.Node;

public class PrintVerticalTree {
	public static void main (String [] args) {
		Node <Integer> root = new Node <Integer> (null, null, 1);
		root.left = new Node <Integer> (null, null, 2); 
		root.right = new Node <Integer> (null, null, 3);
		root.left.left = new Node <Integer> (null, null, 4);
		root.left.right = new Node <Integer> (null, null, 5);
		root.right.left = new Node <Integer> (null, null, 6);
		root.right.right = new Node <Integer> (null, null, 7);
		root.right.left.right = new Node <Integer> (null, null, 8);
		root.right.right.right = new Node <Integer> (null, null, 9);	
		printVerticalTree(root);
	}
	public static void printVerticalTree(Node <Integer> root) { //O(N) adding nodes into hashMap + O(N)
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>(); 
		printVerticalTree(root, map, 0);
		ArrayList <Integer> list = new ArrayList <Integer> (map.keySet());
		list.sort( (a, b) -> a - b );
		for(Integer i: list) {
			System.out.print("Level " + i + ": ");
			for(Integer j: map.get(i)) {
				System.out.print( j + " ");
			}
			System.out.println();
		}
	}
	public static void printVerticalTree(Node <Integer> root, HashMap <Integer, ArrayList<Integer>> map, int value) {
		if(!map.containsKey(value)) {
			map.put(value, new ArrayList<Integer>());
		}
		map.get(value).add(root.value);
		if (root.left != null) {
			printVerticalTree(root.left, map, value - 1);
		}
		if(root.right != null) {
			printVerticalTree(root.right, map, value + 1);
		}
	}
}
