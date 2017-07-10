import java.util.Arrays;

public class minJump {
	public static void main (String [] args) {
		int [] arr = {1,3,5,8,9,2,6,7,6,8,9};
		System.out.println(minJump(arr, arr.length));
	}
	private static int minJump(int [] arr, int length) {
		int [] cache = new int [length];
		int min;
		cache[length - 1] = 0;
		for(int i = length - 2; i >= 0; i--) {
			if (arr[i] == 0) {
				cache[i] = Integer.MAX_VALUE;
			}
			else if (arr[i] >= length - i - 1){
				cache[i] = 1; 
			}
			else {
				min = Integer.MAX_VALUE;
				for(int j = i + 1; j < arr.length && j <= arr[j] + i; j++){
					if (min > cache[j]) {
						min = cache[j];
					}
				}
				if (min == Integer.MAX_VALUE) {
					cache[i] = Integer.MAX_VALUE; 
				}
				else {
					cache[i] = min + 1;
				}
			}
		}
		return cache[0];
	}
}
