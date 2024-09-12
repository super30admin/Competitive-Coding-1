/**
 * Time Complexity : O(log N), Space Complexity: O(1), Approach: We itera
 */

public class Problem1 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 6, 7, 8, 9 };
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (high - low >= 2) {
            mid = low + (high - low) / 2;

            if (nums[mid] - mid != nums[low] - low) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println("Result: " + (nums[low] + nums[high]) / 2);
    }
}
