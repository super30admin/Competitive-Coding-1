import java.util.Arrays;

// Time Complexity : O(n log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, but the question on leetcode is different (268).
// Modified it as per this question. 


// Provide an array of n-1 integers in the range of 1 to n with 
// no duplicates in list, One of the integers is missing in the list. 
// Write a code to find the missing integer.

public class MissingNumber {
	
	public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        
        while(low<=high){
            mid = low + (high - low)/2;
            if (nums[mid] == mid + 1){
                low = mid + 1; 
            }else{
                high = mid -1;
            }
        }
        return low+1;
    }
}
