// Time Complexity : O(log n) : n -> size of array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
	/*
	 * Use binary search. If difference between element and indes is 1, then the
	 * missing element is in the tright half. Else, the missing element is in thew
	 * left half.
	 */
	
	public int findMissingElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}

		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] - mid == 1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low + 1;
	}

	public static void main(String[] args) {
		Problem1 obj = new Problem1();
		System.out.println("Missing element: " + obj.findMissingElement(new int[] { 1, 2, 3, 4, 6, 7, 8 }));
	}
}
