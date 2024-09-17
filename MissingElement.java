// Time Complexity : O(logn) 
// Space Complexity : O(1)


public class MissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3,4,6 };
		System.out.println(missingEle(nums));
	}

	private static int missingEle(int[] nums) {
		// TODO Auto-generated method stub

		int low = 0, high = nums.length - 1;
		int mid = 0;
		while (high - low >= 2) {
			mid = low + (high - low) / 2;
			if (nums[low] - low != nums[mid] - mid)
				high = mid;
			else if (nums[high] - high != nums[mid] - mid)
				low = mid + 1;
		}
		return (nums[low] + nums[high]) / 2;
	}

}
