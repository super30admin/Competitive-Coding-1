
/*
 * Here we subtract arr[low] from arr[mid] and compre the resulting value with the size of the subarray with length=mid-low.
 * Using this we can understand if the subarray has a missing element and if not we can eliminate that half.
 
 * Time Complexity : O(logN)
 * Space complexity is O(1)
 
 
 */

public class Problem1 {
	public static void main(String args[]) {
		Problem1 p1 = new Problem1();

		int[] matrix = { 1, 2, 3, 4, 5,7 };

		System.out.println(p1.searchMatrix(matrix));

	}

	int searchMatrix(int[] arr) {
		if (arr.length > 1) {
			int low = 0;
			int high = arr.length - 1;

			if(arr[low]!=1)
				return -1;
			else if(arr[high]!=5)
				return -1;

			while (low <= high) {
				int mid = low + (high - low) / 2;

				if (mid != arr.length - 1 && arr[mid + 1] - arr[mid] != 1) {
					return arr[mid] + 1;
				} else if (arr[mid] - arr[low] == (high-low)/2) {
					low = mid + 1;
				} else
					high = mid - 1;
			}

		}
		return -1;
	}

}