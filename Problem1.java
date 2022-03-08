class Problem1 {
    public int findMissingElement(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int mid = -1;
        
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]-nums[left]>mid-left){
                right = mid;
            }else if(nums[right]-nums[mid]>right-mid){
                left = mid;
            }
            
            if(right-left==1){
                return nums[left]+1;
            }
        }
        
        return -1;
        
    }
}
