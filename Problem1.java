/*
Time Complexity : O(log(n))
Space Complexity : O(1)

Find the Missing Number in a sorted array
Difference between element and its index is 1
 */
import java.io.*;

class Problem1 {
    static int search(int ar[], int size)
    {
        // Extreme cases
        if (ar[0] != 1)
            return 1;
        if (ar[size - 1] != (size + 1))
            return size + 1;

        int low = 0, high = size - 1;
        int mid = 0;
        while (low<high) {
            mid = (low + high) / 2;
            if (ar[mid]-1 != mid)
                high = mid;
            else
                low = mid+1;
        }
        return (low + 1);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: "
                + search(ar, size));
    }
}
