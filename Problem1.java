
/*
 * Time complexity : O(log n)
 * space complexity : O(1) 
 */

import java.io.*;
class GFG {
public  static int missingElement(int[] arr)
{
   if (arr[0] != 1)  //if first element is missing
            return 1;
        int low = 0, high = arr.length - 1;
        int mid = 0;
        while (low <= high ) {
             mid = low + (high-low)/2;
             //if mid is missing
             if(arr[mid] != mid + 1 && arr[mid-1] == mid) return mid + 1;
             if ((arr[low] - low) != (arr[mid] - mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
}
public static void main (String[] args) {
//System.out.println("GfG!");
//int [] arr = {1,2,3,5,6};
  int [] arr = {2,4,5,6};
 // int [] arr = {1,2,3,5};
System.out.println("Missing number: "
                           + missingElement(arr));
}
}
