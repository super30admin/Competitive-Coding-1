// Time Complexity: O(logn)
// Space Complexity: O(1)
// Missing Element in Sorted Array

class Solution {

    // [1, 2, 3, 5, 6, 7, 8]
    //  0  1  2  3  4  5  6
    public int findMissing(int[] nums) {

        // nums[0] = offset
        int low = 0, high = nums.length - 1;
        while(low <= high) {

            int mid = low + (high - low)/2;
            if(nums[mid] - mid == nums[0]) {
                low = mid + 1;
            } else if (nums[mid] - mid == nums[0] + 1 && nums[mid - 1] - (mid - 1) == nums[0]) {
                return nums[mid] - 1;
            }
            // nums[mid] - mid == nums[0] + 1 && nums[mid - 1] - (mid - 1) == nums[0] + 1 
            else {
                high = mid - 1;
            } 
        }

        return 0;
    }
}
