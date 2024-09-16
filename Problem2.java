//Find missing number in a sorted array

//Time complexity: O(log n) using binary search
import java.io.*;

class FindMissing {
    static int search(int ar[], int size)
    {
        // Extreme cases
        if (ar[0] != 1)
            return 1;
        if (ar[size - 1] != (size + 1))
            return size + 1;

        int left = 0, right = size - 1;
        int mid = 0;
        while ((right - left) > 1) {
            mid = (left + right) / 2;
            if ((ar[left] - left) != (ar[mid] - mid))
                right = mid;
            else if ((ar[right] - right) != (ar[mid] - mid))
                left = mid;
        }
        return (ar[left] + 1);
    }

    public static void main(String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: "
                + search(ar, size));
    }
}