//Time complexity:O(logn)
//Space complexity:O(1)

class Problem1{
    public static void main(String[] args){
        int[] nums={1,2,4,5,6,7};
        int result=helper(nums);
        System.out.println(result);
    }

    private static int helper(int[] nums){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            if(low==high){
                return nums[low]+1;
            }
            int mid=low+(high-low)/2;
            if(nums[low]-low != nums[mid] - mid){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return 11111;
    }

}
