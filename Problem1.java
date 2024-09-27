// Time Complexity : O(log n)
// Space Complexity : O(1)
// Any problem you faced while coding this : No

import java.io.*;

class GFG
{
    static int search(int ar[],
                    int size)
    {
        int low = 0, high = size - 1;
        int mid = 0;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            // check if missing element is between mid and mid - 1
            if (mid != 0 && (ar[mid] - ar[mid - 1]) != 1)
                return ar[mid] - 1;
            // check if missing element is between mid and mid + 1
            if (mid != size - 1 && (ar[mid + 1] - ar[mid]) != 1)
                return ar[mid] + 1;
            // check for missing elements on left side, if not continue search on right
            if(ar[mid] == mid + ar[0])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
 
    // Driver Code
    public static void main (String[] args)
    {
        int ar[] = { 3, 5, 6, 7, 8, 9};
        int size = ar.length;
        System.out.println("Missing number: " +
                            search(ar, size));
    }
}
