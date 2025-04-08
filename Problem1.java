// Time complexity:- O(log n) 
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * This approach uses binary search to efficiently find the k-th missing element in a sorted array.
 * The algorithm calculates how many numbers are missing between the current low and mid index, adjusting the search space based on whether k is smaller or larger than the number of missing elements.
 * Once the loop finishes, the low pointer points to the correct position in the array, and adding k to it gives the k-th missing element.
 */
class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Calculate how many numbers are missing from nums[low] to nums[mid]
            int leftMissingNumbers = nums[mid] - nums[low] - (mid - low);

            if (k <= leftMissingNumbers) {
                high = mid;  // If k is within the missing range, move left
            } else {
                k -= leftMissingNumbers;  // Decrease k by the number of missing numbers
                low = mid + 1;  // If k is larger, search the right side, excluding mid
            }
        }

        // After the loop, low should be at the position where the k-th missing element should be
        return nums[low] + k;
    }
}
