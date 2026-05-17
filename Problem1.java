// Time Complexity : O(log n) because we use Binary Search on the sorted array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use Binary Search to find the first index where the expected value and actual value do not match.
// Before the missing number, nums[i] == i + 1 holds true, and after the missing number this relationship breaks.
// The first mismatching position helps us determine the missing number directly.

class Solution {

    public int missingNumber(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // left side is correct
            if (nums[mid] == mid + 1) {
                low = mid + 1;
            }

            // missing number lies on left side
            else {
                high = mid - 1;
            }
        }

        // missing number
        return low + 1;
    }
}