// Time Complexity: O(log(n))
// Space Complexity: O(1)
// Did you complete it at leetcode: N/A
// Any problems faced with this question: No Problems faced

// Explain your code here
public class Problem1{
	
	public static int missingElement(int[] arr) {
		int lo = 0; int hi = arr.length-1;
		if(arr[lo]==lo+1 && arr[hi]==hi+1) {
		    return -1;
		}
		while(lo<hi) {
			int mid = lo + (hi-lo)/2;
			if(arr[mid]-mid>1) {
				hi = mid;
			} else {
				lo = mid+1;
			}
		}
		return lo+1;
	}
}
