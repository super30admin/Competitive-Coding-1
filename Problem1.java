// Time Complexity : O(log n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach in three sentences only
// Calculate difference of element and the index at low,high, mid position
// If difference is not equal then element is missing at that side, ignore other side

import java.io.*;

class MissingNumber {
    public static int findMissingNumber(int arr[], int size)
    {
        int low = 0;
        int high = size - 1;
        
        while(high-low > 1){
            int mid = low + (high - low)/2;
            int midDiff = arr[mid] - mid;
            int lowDiff = arr[low] - low;
            int highDiff = arr[high] - high;
            if (lowDiff != midDiff){
                high = mid;
            }
            else if (highDiff != midDiff){
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = arr.length;
        System.out.println("Missing number: "
                           + findMissingNumber(arr, size));
    }
}
