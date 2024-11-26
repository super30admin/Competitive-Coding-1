// Time Complexity - O(log n)
// Space Complexity - O(1)

package binarySearch;

public class MissingNumber {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 6, 7, 8};
		int missNum = missingNum(arr);
		System.out.println("Missing Number is: "+missNum);
	}
	
	// method to find missing num in arr
	private static int missingNum(int[] arr) {
		int l=0, r = arr.length-1;
		
		// We are calculating below variables for the edge cases, if the first number or last number is missing in the arr
		int leftIndexDiff = arr[l] - l;
		int rightIndexDiff = arr[r] - r;
		if(arr[l] != 1 && leftIndexDiff == rightIndexDiff) {
			return 1;
		}else if(leftIndexDiff == rightIndexDiff){
			return arr[r] + 1;
		}
		
		while(r-l != 1) {
			// calculate mid 
			// calculate difference between the index of mid and mid. Similarly calculate for left index and right index. 
			// If midIndexDiff is not equal to leftIndexDiff, then there is a missing element in the left part of mid else
			// missing element is in right part of mid;
			int mid = l + (r - l)/2;
			int midIndexDiff = arr[mid] - mid;
			leftIndexDiff = arr[l] - l;
			rightIndexDiff = arr[r] - r;
			if(midIndexDiff != leftIndexDiff) {
				r = mid;
			}else {
				l = mid;
			}
		}
		return (arr[l] + arr[r])/2;
	}
}
