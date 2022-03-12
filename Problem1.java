Time complexity:O(logn)
Space complexity:O(1)
class Solution {
    public int findMin(int[] nums) {
        int start =0, end=nums.length-1;
        while(start<=end){
            if(nums[start]<=nums[end]){
                return nums[start];
            }
            int mid=start+(end-start)/2;
            if(mid!=0&&nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if(nums[mid]<nums[end])    //right sorted when pivot is left of mid 
            {
                end = mid-1;
            }
            else{                    //left sorted when pivot is right of mid
                start = mid+1;         
            }
        }
        return 5001;
    }
}
