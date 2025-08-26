// Time Complexity- lon(n)
// Space complexity- O(1)
class Solution {
	missingNumber(arr) {
		let low = 0;
		let high = arr.length - 1;

		while (low <= high) {
			let mid = Math.floor((low + high) / 2);

			if (arr[mid] == mid + 1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low + 1;
	}
}
