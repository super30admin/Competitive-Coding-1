// Time complexity: O(log N)
// Space complexity: O(1) 
// Successful on geeksforgeeks

/*
Algorithm:
==========
1. Basic intuition is if no element is missing so far, index+1 should be equal to element stored
2. If arr[mid] == mid+1 => missing element on right side, else on left side
*/

//================================ Approach-1 =================================

class Solution {

	public static findMissingElement(int[] ar, int size){ 
	  	if(ar == null || ar.length == 0) return -1;
		int low = 0, high = size - 1; 
	    
	    // low < high-1 to prevent failing edge case where missing element is between mid and mid+1
	  	while( low < high-1) {
	    	int mid = (low+ (high-low)/2);
	      	if(ar[mid] == mid+1) low = mid; //Missing element on right side
	        else high = mid; // Missing element on left side 
	    }
		return ar[low] + 1; 

	}
} 

//================================ Approach-2 =================================

/*
Similar approach but instead takes difference between arr[mid]-mid and arr[low]-low
*/

class Solution {

	public static findMissingElement(int[] ar, int size){ 
	  	if(ar == null || ar.length == 0) return -1;
		int low = 0, high = size - 1; 
	    
	    while( low < high - 1) {
	    	int mid = low + (high-low)/2;
	    	if(ar[low] - low == ar[mid] - mid) low = mid;
	    	else high = mid;
	    }
	    return ar[low] + 1;
	}
} 