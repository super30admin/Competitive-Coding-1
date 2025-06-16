// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
public class Solution {
    public int missingElement(int[] nums, int k) {
        // write your code here
        int low = 0;
        int high = nums.length;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] != nums[mid + 1] - 1) return nums[mid + 1] - 1;
            else if (nums[mid] != nums[mid = 1] + 1) return nums[mid = 1] + 1;

            if((mid - low) != (nums[mid] - nums[low])) high = mid - 1;
            else if((high - mid) != (nums[high] - nums[mid])) low = mid + 1;
        }

        return 0;
    }
}
