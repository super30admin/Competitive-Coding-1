/**
 * https://leetcode.com/problems/missing-number/
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int low =0, high = nums.length - 1;
        /**
            idea is, take difference of the value and index and use binary search
            if difference is same for one side of mid, means number is missing in other
            side of mid, once we reach limits where only 2 numbers are left 
            i.e. high - low == 1, missing number is between those 2 numbes.
            either return nums[low] + 1 or (nums[low]+nums[high])/2
        **/
        while(high - low >=2) {
            int mid = low + (high - low) /2;
            
            int lDiff = nums[low] - low;
            int mDiff = nums[mid] - mid;
            int hDiff = nums[high] - high;
            
            if(lDiff != mDiff){
                high = mid;
            }else {
                low = mid;
            }
        }
        
        return (nums[low] + nums[high]) /2;
    }
    
    
}


