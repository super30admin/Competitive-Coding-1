// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :couldnt find the link
// Any problem you faced while coding this :No




class Problem1{
    public static int findV(int[] nums){
        if(nums == null || nums.length == 0)return -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2; // interger overflow
            if(high==0) return -1;
            if((nums[mid+1]-nums[mid])!=1){
               return nums[mid]+1;
            }else if((nums[mid]-nums[mid-1])!=1){
                return nums[mid]-1;
            }
            if((nums[mid]-nums[low])==(mid-low)){
               low = mid +1;
            }else{
                high = mid -1;
            }
        }return -1;
   
   }
    public static void main(String[] args){
        
    int[] nums={12,14};
    
    System.out.println(findV(nums));
}
}