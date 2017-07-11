import java.util.*;

public class Palindrome {
	public static void main(String [] args) {
		int [] input = {1,4,4,1,6,6,2,1,10,5,4,4,3,1,8};
		System.out.println(palindrome(input));
	}
	public static int palindrome(int [] input) {
		//try idea where they all map to the same memory location
		HashMap <Integer, HashSet<Integer>> map = new HashMap <Integer, HashSet<Integer>>();
		for(int i = 0; i < input.length; i++){//jk lol this whole loop is failfish
			HashSet <Integer> curr = new HashSet<Integer>();
			for(HashSet <Integer> currSet: map.values()){
				if(currSet.contains(input[i])){
					curr = currSet;
				}
			}
			curr.add(input[i]);
			map.put(input[i], curr);
		}
		int [][] cache = new int [input.length][input.length];
		for(int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		int value = palindrome(input, 0, input.length - 1, cache, map);
		for(int i = 0; i < cache.length; i++) {
			for(int j = 0; j < cache[i].length; j++){
				System.out.print(cache[i][j] != -1 ? ">" + cache[i][j] : -1);
			}
			System.out.println();
		}
		return value;
	}
	public static int palindrome(int [] input, int start, int end, int [][] cache, HashMap <Integer, HashSet<Integer>> map){
		if(cache[start][end] != -1) {
			return cache[start][end];
		}
		else if(areEqual(map, start, end)){
			cache[start][end] = 1;
			return 1;
		}
		else if (start == end - 1 && areEqual(map, start, end)) {
			cache[start][end] = 2;
			return 2;
		}
		else if (areEqual(map, start, end)){
			return palindrome(input, start + 1, end - 1, cache, map) + 2; 
		}
		else {
			return Math.max(palindrome(input, start + 1, end, cache, map),palindrome(input, start, end - 1, cache, map));
		}
	}
	private static boolean areEqual(HashMap <Integer, HashSet<Integer>> map, int a, int b){
		return map.get(a) == map.get(b);
	}
}
