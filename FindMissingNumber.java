
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.io.*;

class FindMissingNumber {
	public static void main (String[] args) {
	    int[] arr = {1,2,3,4,6,7,8};
		System.out.println(missingNumber(arr));
		
	}
	
	// use Binary Search to find the middle and then compare the number at middle with its index
	// if the diff is more than 1 between the arr[middle] and middle the missing number is on left, so we reduce the search space from low to middle-1
	// otherwise we reduce the search space from middle+1 to high
	private static int missingNumber(int[] arr){
	    if(arr == null || arr.length == 0)
	        return -1;
	        
	    int low = 0;
	    int high = arr.length -1;
	    
	    while(low<=high) {
	        int mid = low + (high-low)/2;
	        
	        if(arr[mid] == mid+1) {
	            low = mid +1;
	        } else {
	            high = mid -1;
	        }
	    }
	    
	    return low +1;
	}
}

