//Time Complexity - O(log(n))
//Space Complexity - O(1)

public class MissingNumber {
	static int[] nums; //refernce to input array

	public static int binarySearch(int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid - 1] != nums[mid] - 1) // if previous number isn't one less than mid
				return nums[mid] - 1; // found the missing number
			else if (nums[mid] != mid + 1) // if index of element is not 1 less
				high = mid - 1; // then missing number is on left side
			else
				low = mid + 1; // else on right side
		}
		return -1;
	}

	public static void main(String[] args) {
		nums = new int[] { 1, 2, 4, 5, 6, 7, 8 }; // input
		System.out.println(binarySearch(0, nums.length - 1)); // prints missing number
	}
}