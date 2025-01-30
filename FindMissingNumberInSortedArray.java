// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Problem Statement: Find the Missing Number in a sorted array

/**
 * 
 * Used Binary Search here. If the mid index-left index ==mid element-left element that means there is nothing missing on left side so we prune left side.
 * else we prune right side. When my mid element is greater than mid-1 element by 2 that means there is a number missing between them so we
 * return arr[mid]-1. This will be the number missing between them.
 *
 */
class FindMissingNumberInSortedArray{
    
    public static int missingNumber(int[] arr) {
	int left=0;
	int right=arr.length-1;
	while(left<=right) {
	    int mid=left+(right-left)/2;
	    if(mid-1>=0 && arr[mid]-arr[mid-1]==2) {
		System.out.println(arr[mid]-1);
		return arr[mid]-1;
	    }else if(mid-left==arr[mid]-arr[left]){
		left=mid+1;
	    }else {
		right=mid-1;
	    }
	}
	return -1;
    }
    
 // Driver Code
    public static void main(String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        System.out.println("Missing number: "+ missingNumber(ar));
    }
}
