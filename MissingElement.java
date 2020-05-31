// Time Complexity : O(n) n is length of array
// Space Complexity :O(1). 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int missingNumber(int[] nums) {

		if(nums.length>0) {
			int size=nums.length;
			int sum = size*(size+1)/2;
			
			for(int number:nums) {
				sum-=number;
			}
			return sum;
		}
		return -1;
			
	}
}
