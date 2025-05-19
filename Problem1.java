// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

public class Problem1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid == arr[mid] - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("print missing value: " + (left + 1));
    }
}
