//Find Missing Number in sorted array - Passed test cases
/*
TC: O(logn)
SC: O(1)
Method: Perform binary search. Compare the mid element with the neighbors. If the 
Midelement-1 and left neigbhor element are not same, return midelement-1 as missing 
element. If the Midelement+1 and right neigbhor element are not same, return midelement + 1
as missing element. Else, find arr[mid] - mid > 1, then the missing element exists in left
part and update high pointer. else, missing element exists in right part. update low 
pointer and perform binary search.

*/


/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int[] arr = new int[]{1, 2, 4, 5, 6, 7, 8, 9};
        int low =0;
        int high = arr.length-1;        
        int missingElement = findMissingElement(arr, low, high);
        System.out.println("MissingElement is :" + missingElement);
	}
	 public static int findMissingElement(int[] arr, int low, int high)
    	{
        	while(low<=high)
        	{
            	int mid = low + (high-low)/2;
            	if(mid==0 || arr[mid]-1 != arr[mid-1])
                	return arr[mid]-1;
            	else if(arr[mid]+1 != arr[mid+1])
                	return arr[mid]+1;
            	if(arr[mid]-mid > 1)
                	high=mid-1;
            	else
                	low=mid+1;
        	}
        	return -1;
    	}
}