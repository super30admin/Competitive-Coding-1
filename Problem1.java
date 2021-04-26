
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I have added few base cases



class MissingElement {
    public int missingElement(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        int low=0; int high=nums.length-1;
        
        if(high==nums[high]-1)
            return nums[high]+1;

        if(low!=nums[low]-1)
            return nums[low]-1;

        while(high-low>=2){
            int mid=low+(high-low)/2;  
            int diff_mid=nums[mid]-mid;
            int diff_low=nums[low]-low;
            int diff_high=nums[high]-high;

            if(diff_mid!=diff_low){
                high=mid;
            }else{
                if(diff_mid!=diff_high){
                    low=mid;
                }
            }
            
        }
        return ((nums[high]+nums[low])/2);       
    }

    
    public static void main(String[] args){
        MissingElement obj=new MissingElement();
        int[] array={1,2,3,5,6};
        int element=obj.missingElement(array);
        System.out.println("Element is missing :"+element);

    }
    
}
