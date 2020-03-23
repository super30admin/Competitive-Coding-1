
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        
        while(end-start >= 2){
            mid = start + (end-start)/2;
                
            int startIndex = nums[start] - start;
            int midIndex = nums[mid] - mid;
            int endIndex = nums[end] - end;
            
            if(startIndex != midIndex){
                end = mid;
            }
            else if(endIndex != midIndex){
                start = mid;
            }            
        }
        return (nums[start]+nums[end])/2;
    }
}