import java.util.Scanner;
import java.util.stream.Stream;
import java.util.PriorityQueue;

import java.util.*;

public class Prep {
	public static void main (String[] args) throws Exception{
		Integer [] myInts = {1,2,3};
		Stream <Integer> xs = Arrays.stream(myInts);
		
		xs.filter(x -> x > 2)
			.forEach(x -> System.out.println(x));
			
		
		int opCount;
		int opValue;
		PriorityQueue <Integer> pq = null;
		
		Scanner sc = new Scanner(System.in);
		try {
			opCount = Integer.parseInt(sc.nextLine());
			if(1 <= opCount && opCount <= Math.pow(10, 5)){
				pq = new PriorityQueue<Integer> (opCount);
			}
		}
		catch (Exception e){
			throw new Exception("exception");
		}
		while(sc.hasNextLine()){
			int currOp = Integer.parseInt(sc.next());
			switch(currOp){
				case 1: 
					opValue = Integer.parseInt(sc.next());
					if( Math.pow(-10, 9) <= opValue && opValue <= Math.pow(10, 9)){
						pq.add(opValue);
					}
				break;
				case 2:
					opValue = Integer.parseInt(sc.next());
					if( Math.pow(-10, 9) <= opValue && opValue <= Math.pow(10, 9)){
						pq.remove(opValue);
					}
				break;
				case 3:
					System.out.println(pq.peek());
			}
		}
		
		System.out.println("hello there, the angel of my nightmare");
	}
}
