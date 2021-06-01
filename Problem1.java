// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Problem not in Leetcode
// Any problem you faced while coding this : 

class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0;
        int high = k -1;

        while(high - low > 1){
            int mid = low + (high - low)/2;
            int lowVal = nums[low] - low;
            int midVal = nums[mid] - mid;
            int highVal = nums[high] - high;

            if( lowVal == midVal){
                low = mid;
            } else
                high = mid;
        }
        return  nums[low] + 1;
    }
}
