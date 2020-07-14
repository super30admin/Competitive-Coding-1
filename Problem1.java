// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* comparing the first value and middle value with index, if its equal to 1, then return next to middle value */


class Solution{
	public static int MissingNumber(int[] nums) {
		int low = 0, high = nums.length -1, mid =0;
		
		while(low <= high) {
			mid = low + (high-low)/2;
			if((nums[low]-low) == (nums[mid]-mid))		//comparing the first value and middle value with index, if its equal to 1, then return next to middle value
				return nums[mid]+1;
			else if((nums[low]-low) != (nums[mid]-mid))	// comparing the first value and middle value with index, if its not equal then, change the range to search in first half
				high = mid -1;
			else
				low = mid +1;							// comparing the last value and middle value with index, if its not equal then, change the range to search in second half
		}
		return nums[mid];
		
	}
	public static void main(String[] args) {
		int nums[] = {3,5,6,7};
		int mis = MissingNumber(nums);
		System.out.println("Missing No is " +mis);
		
		int nums1[] = {0,1,2,3,4,5,7,8,9,10,11,12};
		int mis1 = MissingNumber(nums1);
		System.out.println("Missing No is " +mis1);
	}
}