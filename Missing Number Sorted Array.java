// Time Complexity : O(log2(n)) ; where n is length of the array
// Space Complexity : O(1) 

import java.io.*;

class Solution
{
    static int binarySearch(int ar[], int size)
    {
        int low = 0;
        int high = size - 1;

        while (high - low >= 2)
        {
            int mid = low + (high - low)/2;
        
            //if difference of element and index for low and mid comes equal, then move to right side
            if ((ar[low] - low) == (ar[mid] - mid)){
                low = mid;                   
            }
            
            //else difference of element and index for high and mid comes equal, then move to left side
            else{ 
                high = mid;
            }
        }
        
        // return the missing element
        return ((ar[low] + ar[high])/2);
    }

    public static void main (String[] args)
    {
        int ar[] = { 2, 3, 4, 5, 6, 8};
        int size = ar.length;
        System.out.println("Missing number: " + binarySearch(ar, size));
    }
}
