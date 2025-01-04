class Solution {
    public int findMissingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the index matches the value (assuming 1-based indexing)
            if (nums[mid] == mid + 1) {
                left = mid + 1; // Move right since the missing number is further ahead
            } else {
                right = mid - 1; // Move left since the missing number is here
            }
        }

        // The missing number is at the position where left points after the loop
        return left + 1; // +1 because of 1-based indexing
    }
