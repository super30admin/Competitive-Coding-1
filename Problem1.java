// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode Playground : Yes
// Any problem you faced while coding this : No

public class GfG {
    static int missingNumber(int[] arr) {
        int n = arr.length;

        // Edge cases
        if (arr[0] != 1) {
            return 1;
        }
        if (arr[n - 1] != (n + 1)) {
            return n + 1;
        }

        // binary search
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] - mid != 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(missingNumber(arr));
    }
}