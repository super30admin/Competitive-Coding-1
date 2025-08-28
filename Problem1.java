// Time Complexity : O(logn)
// Space Complexity : O(1)

// Perform binary search to check if a number is in the correct index
// A number is in the correct index if the number = index + 1
// If correct move to right side of array else move to left side of array

class Solution {
	public int findMissingNumber(int[] arr) {
		int n = arr.length;
		int low = 0;
		int high = n-1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(arr[mid] == mid+1) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return arr[low]-1;
	}

	public static void main(String args[]) {
		Solution obj = new Solution();
		int[] arr = new int[]{1, 2, 3, 5, 6};
		int missingNumber = obj.findMissingNumber(arr);
		System.out.println("The missing number is: " + missingNumber);
	}
}
