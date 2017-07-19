public class Search {
    public static void main (String [] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.print(binarySearch(arr, 6)); 
    }
    public static int binarySearch(int [] arr, int val) {
        int start  = 0; //5
        int end = arr.length - 1; //7
        int mid;
        while (start <= end) {
            mid = start + (end - start)/2; //6
            if(arr[mid] == val) { 
                return mid; 
            }
            else if (arr[mid] > val) {
                end = mid - 1; 
            }
            else {
                start = mid + 1; 
            }
        }
        return -1;
    }
}