// Time Complexity :O(nlogn)->for sorting +O(logN)-> for binary search
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Yes - Difficult to understand the overflows.
class Solution {
    public int missingNumber(int[] nums) {
        if(nums ==null ||nums.length==0) return 0;
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length-1;

        while(high - low >= 2){
            int mid = low+(high -low)/2;
            int midDiff = nums[mid]-mid;
            int lowDiff = nums[low]-low;
            int highDiff = nums[high] -high;
            if(midDiff != lowDiff){
                high = mid;
            }
            else{
                low = mid;
            }
        }
        //Edge cases when the number exists outside the given ranges
        if(nums[nums.length-1] < nums.length && nums[0]==0){
            return nums.length;
        }else if (nums[nums.length-1] == nums.length && nums[0]!=0){
            return 0;
        }
        return (nums[low]+nums[high])/2;

    }
}