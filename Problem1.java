// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Similar to binary search just that check if the mid index
// has the respective value. if not, then move the h to left else
// move l to right index of mix. store the missing number everytime mid is not matching with its
// respective number.return that answer.
class CP1 {
	public static int findMissing(int[] arr) {
		if (arr == null || arr.length == 0)
			return -1;
		int l = 0, h = arr.length - 1;
		int ans = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] != mid + 1) {
				ans = mid + 1;
				h = mid - 1;
			} else if (arr[mid] == mid + 1) {
				l = mid + 1;
			}
		}
		return ans;
	}
}