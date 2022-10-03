#Time Complexity- O(n)
#Space Complexity-O(1)
class Solution {
    public int missingNumber(int[] nums) {
        
        if(nums.length==0||nums==null)
        {
            return 0;
        }
        
        
        int low=0;
        int high=nums.length-1;
        
        if(nums.length==2)
        {
            nums[low]+
        }
        
        while(high-low>=2)
        {
            int mid= low+ (high-low)/2;
            if(nums[mid]-mid!=nums[low]-low)
            {
                high=mid;
            }
            else if(nums[mid]-mid!=nums[high]-high)
            {
                low=mid;
            }
        }
        
       
        
        return (nums[low]+nums[high])/2;
        
    }
}