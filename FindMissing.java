
public class FindMissing {

	static int findMissing(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > mid + 1) {
				high = mid;
			} else {
				low = mid + 1;
			}

		}
		return (low + 1);
	}
	
	public static void main(String[] args)
	{
		int[] nums = new int[] {1,2,4,5,6,7,8};
		int missed = findMissing(nums);
		System.out.println("The missing element in the arrays is " +  missed);
	}
}
