/**
 * @author Vishal Puri
 * // Time Complexity : O(logn)    As we are dividing the array into half in every iteration.
 * // Space Complexity : O(1)   As algorithm no extra auziliary space.
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this : No
 */

class MissingNumber {
    public int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < nums[mid])
                high = mid;
            else
                low = mid + 1;
        }
        return low + 1;
    }

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        int nums[] = {1, 2, 4, 5, 6, 7, 8};
        System.out.println("Missing number: " +
                obj.missingNumber(nums));
    }
}
