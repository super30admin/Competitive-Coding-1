// Missing Element
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution
{
  class Solution {
	public int missingNumber(int[] nums) {
		int n = nums.length;   
		int total = (n)*(n+1)/2;
		for(int i=0; i< nums.length; i++)
		{
			total = total - nums[i];
		}
		return total;
	}
}



