
// find the missing integer

class Solution{
    public int search(int[] nums){
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(mid>0 && nums[mid]-nums[mid-1]!=1)
                return nums[mid]-1;
            else if(nums[mid]-mid==2)
                high=mid-1;
            else
                low=mid+1;
        }

        return -1;
    }
}

