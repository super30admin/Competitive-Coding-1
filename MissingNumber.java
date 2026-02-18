// Time Complexity : O(log n)
// Space Complexity : O(1)
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
Use binary search approach but the core logic to check would be if the difference of an array element
with its respective index is constant across low, mid and high indexes. If not, we update the low, high
positions depending upon where we notice the discrepancy and thereby updating the mid value as well.
 */
import java.io.*;

class MissingNumber {

    static int search(int[] ar, int size) {
        int low = 0;
        int high = size - 1;

        while((high - low) > 1) {
            int mid = low + (high - low) / 2;
            if(ar[low] - low != ar[mid] - mid)
                high = mid;
            else if(ar[high] - high != ar[mid] - mid)
                low = mid;
        }
        return ar[low] + 1;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] ar = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;

        System.out.println("Missing number: " + search(ar, size));
    }
}

