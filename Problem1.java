class Problem1 {
	// Time Complexity : O(n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int missingNumber(int[] arr) {
		int n = arr.length + 1;
		int sum = n * (n + 1) / 2;
		int arrSum = 0;
		
		for(int i: arr)
			arrSum += i;
		
		return sum - arrSum;
	}
}
