//Find missing element in sorted array from starting from 1 to n-1. 
//Time Complexity : O(logn), where n is size of array
//Space Complexity : O(1)





class Solution {
	public static void main (String[] args) {
		int[] nums = {1,2,4,5,6,7,8};
		missing(nums);
	}
	
	public static void missing(int[] nums){
        if(nums[0]!=1) { System.out.println("Missing number : "+1); 
	    }
	    else if(nums.length == nums[nums.length-1]) {
	        System.out.println("Missing number : "+(nums.length+1));
	    }
	    else {
            int low = 0;
            int high = nums.length-1;
            while(low<=high){
                int mid = low + (high-low)/2; 
                if((nums[mid+1]-nums[mid])!=1){
                    System.out.println("Missing number :" +(nums[mid]+1));
                    break;
                }
                if((nums[mid]-nums[mid-1])!=1){
                    System.out.println("Missing number :" +(nums[mid]-1));
                    break;
                }
                if((nums[mid]-nums[low])==(mid-low)){
                    low = mid +1;
                    }
                else{
                    high = mid -1;
                }
            }
	    }
    }
   
}