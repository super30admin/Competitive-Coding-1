
//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :
// simple logic found to be difficult earlier.

public class MissingNumb {
	public static void main(String[] args) {
		int arr[] = { 10, 11, 12 , 14, 15, 16, 17, 18 };
		int left = 0;
		int right = arr.length - 1;
		int res = -1;

		/*
		 * while (start <= end) { int mid = start + (end - start)/2;
		 * System.out.println("start => " + arr[start] + " mid => " + arr[mid] +
		 * " end => " + arr[end]);
		 * 
		 * //System.out.println("");
		 * 
		 * 
		 * //if (mid+1 < end) { //res = (arr[mid+ 1] - arr[mid])/2; //}
		 * //System.out.println(" result => " + (arr[mid+ 1] - arr[mid])/2); if (mid !=
		 * 0 && mid != arr.length - 1 && (arr[mid + 1 ] - arr[mid ] )/2 == 1 ) {
		 * System.out.println(" mid res => " + (arr[mid + 1 ] + arr[mid ] )/2); }
		 * 
		 * if (arr[mid + 1 ] - arr[mid ] > 1) { end = mid - 1;
		 * 
		 * 
		 * //System.out.println("start=> " + arr[start] + " element " + (arr[mid+ 1] +
		 * arr[mid])/2); } else {
		 * 
		 * start = mid + 1; //System.out.println("end=> " + arr[end] );
		 * 
		 * }
		 * 
		 * }
		 */

		System.out.println(" missing number is => " + missingNumber(arr, left, right));
	}

	/**
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static int missingNumber(int[] arr, int left, int right) {
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			System.out.println(" arr[left] => " + arr[left] + " left => " + left + " mid => " + mid + " arr[mid] => "
					+ arr[mid] + " right => " + right + " arr[right] => " + arr[right]);
			int leftDifference = arr[left] - left;

			int midDifference = arr[mid] - mid; 
			System.out.println(" left diff => " + leftDifference + " mid DIff => " + midDifference);
			if (leftDifference != midDifference) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return (arr[left] + arr[right]) / 2;

	}
}

