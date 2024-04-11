// Missing Number Problem
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
import java.util.Arrays;
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] != 0) return 0;
        if(nums[nums.length - 1] != nums.length) return nums.length;
        int low =0;
        int high=nums.length-1;
        if (nums.length == 2){
            if ((nums[high] - nums[low]) !=1 ){
                return nums[high]-1;
            }
        }
        while (low <=high){
            int mid = low + (high-low) / 2;
            if (mid == 0){
                return mid;
            }
            if (nums[mid] - nums[mid-1] != 1){
                return nums[mid] - 1;
            }
            if (nums[mid] > mid){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
    return -1;
    }
}
