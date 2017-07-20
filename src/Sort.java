import java.util.Arrays;

public class Sort {
    public static void main (String [] args) {
        int [] arr = new int [200]; 
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);     
        }
        printArray(arr);
        radixSort(arr);
        printArray(arr);
    }
    public static int [] countingSort(int [] arr) { //array holds values from range 0 - 100
        int [] count = new int [100]; 
        int [] temp = new int [arr.length];
        //assume array holds
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;         
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];     
        }
        for (int i = 0; i < arr.length; i++) {
            temp[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--; 
        }
        return temp;
    }
    
    public static void countingSort(int [] arr, int n, int exp, int base) { //array holds values from range 0 - 100
        int [] count = new int [base];
        int [] temp = new int [n]; 
        Arrays.fill(count,0);
        for(int i = 0; i < n; i++) {
            count[(arr[i]/exp)%base]++;     
        }
        for(int i = 1; i < base; i++) {
            count[i] += count[i - 1];    
        }
        for(int i = n -1; i >= 0; i--) {
            temp[count[(arr[i]/exp)%base] - 1] = arr[i]; 
            count[(arr[i]/exp)%base]--; 
        }
        for(int i = 0; i < n; i++) {
            arr[i] = temp[i];    
        }
    }
    public static int getMax(int arr[])
    {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    public static void radixSort(int [] arr) {
        int max = getMax(arr); 
        for(int i = 1; max/i > 0 ; i *=10) {
            countingSort(arr, arr.length, i, 10);
        }
    }
    public static void printArray(int [] arr) {
        for(int i: arr) {
            System.out.print(i + ", ");     
        }
        System.out.println(); 
    }
}