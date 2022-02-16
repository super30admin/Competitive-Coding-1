// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

class find {
    public int findMissing(int[] nums) {

        // Optimized using Binary Search in O(log n)
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {

            int mid = start + (end - start) / 2;
            
            // checking if difference of mid value and mid index is 1
            if (nums[mid] - mid == 1) {
                start = mid + 1; // halve the search space
            }
            // checking if difference of mid value and mid index is not 1
            else if (nums[mid] - mid != 1) {

                // checking if difference of value before mid and its index not 1
                if (mid == 0 || nums[mid-1] - (mid-1) == 1) {
                    return mid + 1;  // simply returning index of mid + 1 which is our missing number
                }
                else {
                    end = mid - 1; // havle the search space and loop again
                }
            }
        }
        return -1;    
    }
}
