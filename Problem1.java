//Time = O(log n)
//Space = O(1)

public class Solution {
    public int findMissingNumber(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the missing number is in the left half
            if (arr[mid] != mid + arr[0]) {
                // Missing number is in the left half
                high = mid - 1;
            } else {
                // Missing number is in the right half
                low = mid + 1;
            }
        }

        // 'low' will be at the position where the missing number should be
        return low + arr[0];
    }
}

