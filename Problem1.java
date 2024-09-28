// Time Complexity : O(logN) , N is length of array
// Space Complexity : O(1) 

class Solution {
    public int missingNumber(int[] nums) {
               
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        
        while (high - low >= 2) {
            mid = low + (high - low)/2;
            int midIdxDiff = nums[mid] - mid;
            int lowIdxDiff = nums[low] - low;
            int highIdxDiff = nums[high] - high;
            
            if (midIdxDiff != lowIdxDiff) {
                high = mid;
            } else if (midIdxDiff != highIdxDiff) {
                low = mid;
            }
        }
        return (nums[low] + nums[high])/2;
    }
}