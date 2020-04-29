// Time Complexity : O(log n)
// Space Complexity : O(1) since we are not initializing data structure
// Did this code successfully run on Leetcode : Runs on my terminal
// Any problem you faced while coding this : None
#include <bits/stdc++.h>

int missingBinarySearch(int low, int high, std::vector<int>& nums, int delta){
	if(low > high){
		return -1;
	}
	int mid = low + (high - low)/2;
	//If the mid is not what we expect, the missing element is either the mid or on it's left.
	if(nums[mid]!= (mid + delta)){
		if(mid > 0 && (nums[mid - 1] == (mid - 1 + delta)))
			return mid + delta;
		else
			return missingBinarySearch(low, mid - 1, nums, delta);
	}
	//The missing element is on the right.
	else{
		return missingBinarySearch(mid + 1, high, nums, delta);
	}
}

int main(){
	std::vector<int> nums = {1,3,4,5,6,7,8,9};
	if(nums.size() == 0 || nums.size() == 1)
		return -1;
	int delta = 1; // The constant expected difference between elements. Assumed to be given as calculating from array is risky.
	int low = 0;
	int high = nums.size() - 1;
	std::cout << "Missing element is " << missingBinarySearch(low, high, nums, delta) << "\n";
	return 0;
}
