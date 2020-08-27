// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : not on leetcode 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
	
	

public static int findMissingNum(int[] nums){
	//we find left and right values to implement binary search
	int left = 0;
	int right = nums.length - 1;

	//break out of while loop if this condition does not satisfy and return average of two numbers where left and right point.
	while(right - left > 1){

		//Find mid and maintain the difference between the index and the value at that index for left pointer and mid pointer
		int mid = left + (right-left)/2;
		int leftDiff = nums[left] - left;
		int midDiff = nums[mid] - mid;

		//when the difference is not equal, that means we should have our missing number on the left side of mid, so bring the mid to right ignoring the right side of the array
		if(leftDiff != midDiff){
			right = mid;
		}
		//if difference is equal, because the array is sorted that means, the missing number has to be on the right side of the mid 
		else{
			left = mid;
		}

	}

	//this will return the missing number when loop exits.
	return (nums[left] + nums[right])/2;
}

