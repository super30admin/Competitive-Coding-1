// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Approach
 * We are using Binary search because we have been give a sorted array, 
 * number that the array can have are from 1 to n and only one number will be missing
 * first we will handle the edge cases where first or the last element might be missing
 * when int the while loop we are elemenating the half that that every elemnt and selecting the other half to fid the missing number
 * 
 */
class Solution {
    public int findmissing(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[0] != 1) {
            return 1;
        }
        if (nums[high] != high + 2) {
            return high + 2;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((nums[low] - low) != nums[mid] - mid) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return nums[low] + 1;
    }
}