/**
 * Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
 * One of the integers is missing in the list. Write a code to find the missing integer.
 */


// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class GFG {
    
    public static int missingNumber(int[] nums){
        
        if(nums == null || nums.length == 0)
            return -1;
        
        int low=0, high = nums.length-1;
        
        while(high-low >= 2){
            int mid = low + (high-low)/2;
            
            if(nums[mid] - nums[low] != mid -low){
                high = mid;
            } else {
                low=mid;
            }
        }
        return (nums[low]+nums[high])/2;
    }
	public static void main (String[] args) {
		System.out.println("GfG!");
		int[] nums = {1,3,4,5};
		int missingVal = missingNumber(nums);
		System.out.println("The missing value is: "+missingVal);
		
	}
}