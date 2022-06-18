// Time Complexity : O(log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: None

public class missingElement {

    private static int getMissingElement(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n;

        // Null case
        if (arr == null || n == 0)
            return -1;

        while (start < end) {
            int mid = (start + end) / 2;

            // Moving right side
            if (arr[mid] == mid + 1) {
                start = mid + 1;
            } else if (arr[mid] != mid + 1 && arr[mid - 1] != mid) {
                // Moving Left side
                end = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 7, 8 };
        System.out.println(getMissingElement(nums));
    }
}
