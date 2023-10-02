//// Time Complexity : O(log(n))
//// Space Complexity : O(1)
//Given an array find the missing element in the array
class Problem1 {
    
    public static int checkMissingNumber(int[] nums){
        int low=0;
        int n=nums.length;
        int high=n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==0 || nums[mid]-1!=nums[mid-1]){
                return nums[mid]-1;
            }
            if(mid==n-1 || nums[mid]+1!=nums[mid+1]){
                return nums[mid]+1;
            }
            int lowIndex=mid-low;
            int highIndex=high-mid;
            int differenceLow=nums[mid]-nums[low];
            int differenceHigh=nums[high]-nums[mid];
            
            if(lowIndex==differenceLow){
                low=mid+1;
            }else{
                high=mid-1;
            }
            
        }
        return -1;
        
    }
    
    public static void main(String[] args) {
        int[] nums=new int[] {2,3,4,5,6,8,9};
       System.out.println(checkMissingNumber(nums));
    }
}