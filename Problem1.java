Missing Number

class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        
        Arrays.sort(nums);
        
        int l=0,h=nums.length-1;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            
            if(nums[mid]!=mid)
                h=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
}
