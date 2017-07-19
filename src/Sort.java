public class Sort {
    public static void main (String [] args) {
        int [] arr = new int [200]; 
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);     
        }
        for(int i: arr){
        	System.out.print(i + ", ");
        }
        arr = countingSort(arr);
        System.out.println();
        for(int i: arr){
        	System.out.print(i + ", ");
        }
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
}