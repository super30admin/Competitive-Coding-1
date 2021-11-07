// Time complexity is O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: NA
// Any problem you faced while coding this:

//Find the Missing Number in a sorted array
import java.util.*;

class missingnumberinsortedarray 
{
    static int search(int ar[], int size)
    {
        int a = 0, b = size - 1;
        int mid = 0;
        while ((b - a) > 1)
        {
            mid = (a + b) / 2; 
            if ((ar[a] - a) != (ar[mid] - mid))
                b = mid;
            else if ((ar[b] - b) != (ar[mid] - mid))
                a = mid;
        }
        return (ar[a] + 1);
    }
} 