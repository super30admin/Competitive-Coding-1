Time Complexity:O(log2n)
Space Complexity:O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int start =0, end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            boolean midGtThanLeft = mid==0||nums[mid]>nums[mid-1];
            boolean midGtThanRight = mid==nums.length-1||nums[mid]>nums[mid+1];
            //mid is peak
            if(midGtThanLeft&&midGtThanRight){
                return mid;
            }
            if(midGtThanLeft) {  //go to right
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
        
    }
}
