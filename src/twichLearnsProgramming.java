import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

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
        //System.out.println(isSubstr("sprmn", "superman"));


        //print pairs

        int [] A = {-1, -2, 4, -6, 5, 7};
        int [] B = {6, 3, 4, 0};
        System.out.println("printing pairs");
        printPairs2(A, B, 8);
        System.out.println("chunk palindrome");
        System.out.println(chunkPalindrome("geeksforgeeks"));
        String str = "geeks";
        System.out.print("minimum rotation for " + str + " is : " + minimumRotations(str) );

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
    public static void printPairs(int [] a, int [] b, int x) {
        if(a.length == 0 || b.length == 0) {
            return;
        }
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Integer i: a) {
            //store all values into map
            map.put(i, i);
        }
        for(Integer j: b) {
            if(map.get(x - j) != null) {
                System.out.println(j + ", " + map.get(x - j));
            }
        }
    }
    public static int chunkPalindrome(String str) {
        if (str.length() == 0) {
            return -1;
        }
        else if (str.length() == 1) {
            return 1;
        }
        return chunkPalindrome(0, str.length() - 1, str, "","", 0);
    }
    public static int chunkPalindrome(int left, int right, String str, String leftBuffer, String rightBuffer, int count) {
        if(left == right) {
            return count + 1;
        }
        else if (left + 1 == right) {
            return count + (leftBuffer + str.charAt(left) == str.charAt(right) + rightBuffer ? 2 : 1);
        }
        else {
            leftBuffer = leftBuffer + str.charAt(left);
            rightBuffer = str.charAt(right) + rightBuffer;
            if(leftBuffer.equals(rightBuffer)) {
                count+= 2;
                leftBuffer = "";
                rightBuffer = "";
            }
            return chunkPalindrome(left + 1, right - 1, str, leftBuffer, rightBuffer, count);
        }
    }
    public static int minimumRotations(String str) {
        String temp = str + str;
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            if(temp.substring(i, str.length() + i).equals(str)) {
                return count;
            }
            count++;
        }
        return str.length();
    }
    public static void printPairs2(int [] a, int [] b, int x) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = b.length - 1;

        while ( i < a.length - 1) {
            while(j >= 0) {
                if(a[i] + b[j] == x) {
                    System.out.println(a[i] + ", " + b[j]);
                    i++;
                    j--;
                }
                else if(i == a.length - 1) {
                    j--;
                }
                else if(j == 0) {
                    i++;
                }
                else {
                    if(Math.abs(x - (a[i] + b[j - 1])) <=
                            Math.abs(x - (b[j] + a[i + 1]))) {
                        j--;
                    }
                    else {
                        i++;
                    }
                }
            }
        }
    }


}
