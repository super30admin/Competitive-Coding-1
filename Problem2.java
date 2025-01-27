// Time Complexity : O(log n)
// Space Complexity : O(1)
// Given an integer array nums which is sorted in ascending order and all of its elements are unique and given also an integer k,
// return the kth missing number starting from the leftmost number of the array.

class Solution {
    public int missingElement(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) {
            return -1;
        }

        int low = 0, high = nums.length-1;
        int start = nums[low]-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            int missingCount = nums[mid]-mid-nums[0];

            if(missingCount < k) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        // loop is exited when low > high. so either take high or low-1
        return nums[0] + k + high;
    }
}