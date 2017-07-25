import java.util.ArrayList;
import java.util.Arrays;

public class twichLearnsProgramming {
    public static void main (String [] args) {
        //LONGEST SEQUENCE
        int [] arr = {1,2,3,5,6};
        System.out.println(longestSequence(arr));
        arr = new int[] {6, 5, 4, 3, 2, 1};
        System.out.println(longestSequence(arr));
        //LONGEST SEQUENCE END

        //GET BUCKETS START
        ArrayList <Integer> list = new ArrayList <Integer> (Arrays.asList(1,7,2,4,4,7,3,8));
        for (ArrayList <Integer> bucket: getBuckets(list)) {
            System.out.print("Bucket: ");
            for(Integer i: bucket) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
        //END GET BUCKETS
        System.out.println(isSubstr("sprmn", "superman"));

    }
    public static int longestSequence(int [] arr) {
        int curr = 1;
        int max = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - 1 == arr[i - 1]) {
                curr++;
                if (curr > max) {
                    max = curr;
                }
            } else {
                curr = 0;
            }
        }
        return max;
    }
    public static ArrayList < ArrayList<Integer> > getBuckets(ArrayList <Integer> list) {
        list.sort((x, y) -> x - y);
        ArrayList < ArrayList <Integer>> buckets = new ArrayList < ArrayList <Integer> >();

        ArrayList <Integer> currBucket = new ArrayList <Integer>();
        int curr = list.get(0);
        currBucket.add(curr);
        buckets.add(currBucket);

        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) != curr) {
                currBucket = new ArrayList <Integer>();
                curr = list.get(i);
                currBucket.add(curr);
                buckets.add(currBucket);
            }
            else {
                currBucket.add(list.get(i));
            }
        }
        return buckets;
    }
    public static boolean isSubstr(String a, String b) {
        boolean isSubstr = false;
        int i = 0;
        int j = 0;

        while(i < a.length()) {
            while(j < b.length()) {
                if(a.charAt(i) == b.charAt(j)) {
                    i++;
                    j++;
                    if(i > a.length()) {
                        return true;
                    }
                }
                j++;
                if(j > b.length()) {
                    return false;
                }
            }
        }
        return false;
    }
}
