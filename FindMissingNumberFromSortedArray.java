//time - O(log n)
//space - O(1)
class Solution{
    public int findMissingNumber(int[] nums){
        if(nums==null || nums.length==0) return -1;
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid]!=mid+1 && (mid==0 || nums[mid-1] != nums[mid]-1)) return nums[mid]-1;
            else if(nums[mid]==mid+1) low = mid+1;
            else high = mid-1;
        }

        return -1;
    }
}
