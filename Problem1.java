// Time Complexity : O(log(n)) 
// Space Complexity : O(1)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : No

// Approach: In a sorted array, every element if starting from one should be at index n-1.
// For example, 1 lies at 0, 2 lies at 1... i lies at i-1.
// I do a binary search, go to mid, if the element satisfies this ^ that it nums[i] = i + 1
// This means that all elements till now are sorted and nothing is missing, otherwise the gap will be more.
// If this is not the case ^ then I check if the current index's element is the one missing
// I do this by comparing it with it's previous, if the gap is one, the missing element would be on the left
// Else, mid is the missing element's index, so I return mid + 1.

class Solution {
    int missingNumber(int nums[]) {
        if(nums.length == 0) return 1; 
        if(nums[nums.length-1] == nums.length) return nums.length+1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high-low)/2; // to prevent integer overflow
            if(nums[mid] == mid+1){ // in the position where it is supossed to be 
                low = mid + 1;
            }
            else{
                if(mid!=0 && nums[mid] == nums[mid-1] + 1){
                    high = mid -1;
                }
                else{
                    return mid+1;
                }
            }
        }   
        return -1;
    }
}