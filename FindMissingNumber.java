//Time Complexity - O(log n)
//Space Complexity - O(1)
//Ran in Leetcode - Yes

public class FindMissingNumber {

	private static int missingNumber(int[] num) {
		int middle = 0;
		int low = 0;
		int high = num.length - 1;
		while (low <= high) {
			middle = low + (high - low) / 2;
			if (middle == num[middle] - 1) // 2
				low = middle + 1; // no missing numbers in left
			else
				high = middle - 1;
		}
		return (low >= num.length) ? -1 : num[low] - 1; //when no missing number in array, it reaches out of the array
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 ,5};
		System.out.println(missingNumber(num));
	}

}

