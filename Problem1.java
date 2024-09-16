//TC : O(logn)
//SC : O(1)
public class Solution {
    public int missingNumber(int[] nums) {        
        int low = 0;
        int high = nums.length - 1;
        int mid;
        
        while(low<high - 1) {
            mid = low + (high - low)/2;
            if(nums[mid]-mid == nums[low]-low)
                low = mid;
            else
                high = mid;
        }

        return nums[low]+1);
    }
}
