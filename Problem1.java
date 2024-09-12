/* Time complexity: O(logn)
Space Complexity: O(1)  */

class Solution {
    public int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        Arrays.sort(nums);
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if((nums[mid] != mid) && (mid == 0 || nums[mid] - nums[mid-1] >1)){
                return nums[mid]-1;
            }
            else if(nums[mid]!= mid) {
                high = mid-1;
            }
            else{
                low = mid+1;
                
            }
        }
        return nums[nums.length-1]+1;
    }
}