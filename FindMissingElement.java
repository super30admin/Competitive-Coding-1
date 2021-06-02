package CompetitiveCoding1;
//Time Complexity : O(logn) for searching using binary search
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

// https://leetcode.com/problems/missing-element-in-sorted-array/ 
//Your code here along with comments explaining your approach
//Since the given array is sorted and has only one missing element, find mid element diff and low element diff
//if both diff are same, then no element is present between low and mid
//if both diff are different, then there is an element diff between them


public class FindMissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,7,9,10};
		
		int elem = findMissingElement(arr);
		
		System.out.println(elem);
	}

	private static int findMissingElement(int[] arr) {
		// TODO Auto-generated method stub
		
		int low = 0;
		int high = arr.length-1;
		int mid= 0 ;
		
		while(high-low >= 2) {
		    mid = low + (high-low)/2;
			
			int midIndex = arr[mid] - mid;
			int lowIndex = arr[low] - low;
			
			if(midIndex == lowIndex) {
				low = mid;
			}else {
				high = mid;
			}
		}
		
		return (arr[mid] + arr[low] ) / 2;
	}

}
