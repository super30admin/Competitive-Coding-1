
import java.io.*;

class MissingNumberSortedArray
{
    public int search(int ar[],
                      int size)
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

    public static void main (String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        MissingNumberSortedArray m = new MissingNumberSortedArray();
        int size = ar.length;
        System.out.println("Missing number: " +
                m.search(ar, size));
    }
}

// Time complexity : O(log N) using Binary search and eliminating half of the array (N: array.length)
//Space complexity :  O(1) not using any auxiliary space.
