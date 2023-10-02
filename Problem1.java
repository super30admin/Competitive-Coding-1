// # Competivive Coding 1
// ## Problem 1:  https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
// Time Complexity : 0(log n)
// Space Complexity : 0(1)
// Did this code successfully run on geeksforgeeks : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
import java.io.*;
 
class MissingElement {
    static int search(int array[], int n)
    {
        if (array[0] != 1)
            return 1;
        if (array[n - 1] != (n + 1))
            return n + 1;
 
        int low = 0, high = n - 1;
        int mid = 0;
        while ((high - low) > 1) {
            mid = (high + low) / 2;
            if ((array[low] - low) != (array[mid] - mid))
                high = mid;
            else if ((array[high] - high) != (array[mid] - mid))
                low = mid;
        }
        return (array[low] + 1);
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int array[] = { 1, 2, 3, 4, 5, 7, 8 };
        int n = array.length;
        System.out.println("Missing number: "
                           + search(array, n));
    }
}