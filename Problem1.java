// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.io.*;

public class Solution
{
    static int search(int ar[],
                      int size)
    {
        int low = 0;
        int high = size - 1;
        int mid = 0;

        while(high - low >= 2) {
            mid = low + (high - low) / 2;
            int midDiff = ar[mid] - mid;
            int lowDiff = ar[low] - low;
            int highDiff = ar[high] - high;

            if(lowDiff != midDiff) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (ar[low] + ar[high]) / 2;
    }

    // Driver Code
    public static void main (String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number - " +
                search(ar, size));
    }
}
