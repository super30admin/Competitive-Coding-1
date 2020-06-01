import java.util.Arrays;

class Find_element {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
		int missing = findelement(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Missing Number : " + missing);
	}

	public static int findelement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		/*
		 * Binary Search is performed until we get 2 numbers where the difference
		 * between high and low would be greater than 1
		 */
		while (high - low >= 2) {
			int middle = low + (high - low) / 2;
			/*
			 * Difference between middle element and middle index is calculated and
			 * difference between low element and low index is calculated, if both aren't
			 * equal low becomes mid, else high becomes mid
			 */
			int mid_diff = nums[middle] - middle;
			int low_diff = nums[low] - low;
			if (mid_diff != low_diff) {
				high = middle;
			} else {
				low = middle;
			}
		}
		// When only 2 elements remain, their average is returned which is the missing
		// element
		return (nums[low] + nums[high]) / 2;
	}
}
