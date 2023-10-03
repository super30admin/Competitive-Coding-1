// Time Complexity : O(log n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : -

public class Problem1 {
	public static int findMissingEle(int[] arr) {
		if (arr == null || arr.length == 0)
			return -1;
		int n = arr.length;
		int l = 0;
		int h = n - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;// (l+h)/2;
			// If value at mid is not greater than value at mid+1 by '1' ==> the value after
			// mid is missing
			if ((mid < n - 1 && arr[mid] + 1 != arr[mid + 1]) || (mid == n - 1)) {
				return arr[mid] + 1;
			}
			// If value at mid is equal to mid +1 ==> left array is sorted
			else if (mid + 1 == arr[mid]) {
				l = mid + 1;
			}
			// right array is sorted
			else {
				// If mid is at zeroth index
				if (mid == 0) {
					return arr[mid] - 1;
				} else {
					h = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int missingEle = findMissingEle(arr);
		System.out.println("Missing element is : " + missingEle);
		int[] arr2 = { 1, 2, 3, 5, 6, 7, 8 };
		int missingEle2 = findMissingEle(arr2);
		System.out.println("Missing element is : " + missingEle2);
		int[] arr3 = { 2, 3, 4, 5, 6, 7, 8 };
		int missingEle3 = findMissingEle(arr3);
		System.out.println("Missing element is : " + missingEle3);
		int[] arr4 = { 1, 3, 4, 5, 6, 7, 8 };
		int missingEle4 = findMissingEle(arr4);
		System.out.println("Missing element is : " + missingEle4);
	}
}