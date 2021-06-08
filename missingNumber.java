// TC : O(logN)
// SC : O(1)
class Solution {
    public int missingNumber(int[] nums) {
       int low =0, high=nums.length-1, mid;
        while(low - high >2){
            mid = low + (high-low)/2;
            if(nums[mid] -mid != nums[low] - low){
                high = mid;
            }
            else{
                low = mid;
            }
        }
        return (nums[low]+nums[high])/2;
    }
}
