// Time Complexity: performing binary search - O(log(n))
// Space Complexity: only few constants used - O(1)
// Did you complete it at leetcode: couldn't find exact question
// Any problems faced with this question: initially got stuck with what to return.

// Explain your code here
public class Solution{
	// Idea here is to first check if difference between array item and its index
	// is equal to 1 for first and last element no element is missing return -1
	// otherwise, keep taking mid and check if difference of element at mid and mid index is 1
	// if more than 1 then left half including mid have missing element
	// else right part have missing element.
	public static int missingElement(int[] arr) {
		int l = 0; int h = arr.length-1;
		if(arr[l]==l+1 && arr[h]==h+1) {
		    return -1;
		}
		while(l<h) {
			int mid = l + (h-l)/2;
			if(arr[mid]-mid>1) {
				h = mid;
			} else {
				l = mid+1;
			}
		}
		return l+1;
	}

     public static void main(String []args){
        int[] arr1 = {1,2,3,4,5,7,8,9};
		int[] arr2 = {1,3,4,5,6,7,8,9};
		int[] arr3 = {2,3,4,5,6,7,8,9};
		int[] arr4 = {1,2,3,4,5,6,7,8};
		System.out.println(missingElement(arr1));
		System.out.println(missingElement(arr2));
		System.out.println(missingElement(arr3));
		System.out.println(missingElement(arr4));
     }
}
