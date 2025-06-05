// Time Complexity : O(log n), where n is the length of the input array
// Space Complexity : O(1), as no additional space is used apart from variables
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// The array contains sorted elements from 1 to n+1 with one number missing.
// Since elements should match the pattern arr[i] = i + 1, any mismatch indicates a missing number before or at that index.
// We perform binary search: if arr[mid] == mid + 1, search right; else search left.
// At the end of the loop, the missing number is just before arr[low], so we return arr[low] - 1.
public class Main {
    public static int missingNumber(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the value matches the expected index + 1, move right
            if (arr[mid] == mid + 1) {
                low = mid + 1;
            } else {
                // Otherwise, move left
                high = mid - 1;
            }
        }

        // Missing number is just before arr[low]
        return arr[low] - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(missingNumber(arr));  // Output: 5
    }
}
