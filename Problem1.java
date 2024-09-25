// Complexity : O(logn)

// Space Complexity: O(1)

// Executed successfully 

// The basic idea is to check whether the mid is at the correct position, if it is then  check in the right subarray else there is a missing element in the left subarray

class Solution{

    public int missingNum(int[] nums){

	    int start = 0;

	    int end = nums.length-1; 

	    while(start <= end){

	        int mid =  start + (end-start)/2;

	        if(nums[mid] == mid+1){
	            start = mid + 1;
	        }
	        else{
	            end = mid - 1;
	        }

	    }

	    return start + 1;

	}

}
