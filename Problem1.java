
//Time Complexity: O(logn)
//Space Complexity: constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// we can make use of binary search to search for the target as the elements are in sorted order in the matix


class solution {
    public int missingNumber(int[] nums){
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            int midDiff = nums[mid] - mid;
            int loDiff = nums[lo] - lo;
            int hiDiff = nums[high] -  high;
            if(midDiff != loDiff ){
                hi = mid;
            }
            else if(midDiff != hiDiff){
                lo = mid;
            }
        }
        return (nums[lo] + nums[hi] )/2;
    }
}
