//find missing number in sorted array
//time complexity O(logn n)
//space complexity  O(1)

import java.io.*;

public class Problem1 {
    public static int Search(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            
            if (arr[mid] != mid) {
                //left part
                high = mid - 1;
            } else {
                //right part
                low = mid + 1;
            }
        }
        
        return low; 
    }

    public static void main(String[] args) {
        int[] arr = {0,1, 2, 3, 4, 5, 6, 8, 9};
        int missingNumber = Search(arr);
        System.out.println("Missing number: " + missingNumber);
    }
}




