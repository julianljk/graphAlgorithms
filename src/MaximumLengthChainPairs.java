import java.util.Arrays;

public class MaximumLengthChainPairs {
    public static void main (String [] args) {
        int [][] arr = { 
            {5, 24},
            {15, 25}, 
            {27, 40},
            {50,60}
        };
        System.out.println(maxChain(arr));
    }
    public static int maxChain(int list[][]) {
        if(list.length == 0) {
            return 0;    
        }
        else if(list.length == 1) {
            return 1;   
        }
        
        int [] longest = new int[list.length];
        int max = 1; 
        Arrays.fill(longest, 1);
        
        for(int i = 1; i < list.length; i++) {
            for(int j = 0; j < i; j++) {
                if(list[j][1] < list[i][0] && longest[i] < longest[j] + 1) {
                    longest[i] = longest[j] + 1;
                }
            }
        }
        for(int i = 0; i < longest.length; i++) {
            if(max < longest[i]) {
                max = longest[i];
            }
        }
        return max;
    }
}
  