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
	
	public static int result(int[] arr) {
		int l = 0, h = arr.length - 1;
		while(h - l > 2) {
			int mid = (l+h)/2;
			int midDiff = arr[mid] - mid;
			int lowDiff = arr[l] - l;
			int highDiff = arr[h] - h;
			if(midDiff != lowDiff)
				h = mid - 1;
			else
				l = mid + 1;		
		}
		return (arr[l] +arr[h])/2;
	}

	public static void main(String[] args) {
		System.out.println("GfG!");
		int[] arr = { 2, 4, 5, 6, 7, 8, 9 };
		System.out.println(result(arr));
	}
}