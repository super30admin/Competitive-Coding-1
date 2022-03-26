
// "static void main" must be defined in a public class.
// Time Complexity
// With bruteforce solution: O(m*n)
// With Binary search Optimization: O(Log m + Log n)
// Where n = number of elements in array.
// Space Complexity
// With bruteforce solution: O(1)
// With Binary search Optimization: O(1)

import java.util.*;

public class ClassMain {
    public static int missingNumber(int nums[], int size) {
        int low = 0;
        int high = size - 1;
        while (high - low >= 2) {
            int mid = low + (high - low) / 2;
            if ((nums[mid] - mid) != (nums[low] - low)) {
                high = mid;
            } else if ((nums[mid] - mid) != (nums[high] - high)) {
                low = mid;
            }
        }
        return (nums[high] + nums[low]) / 2;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9 };
        int size = arr.length;
        System.out.println("Missing number: " + missingNumber(arr, size));
    }
}