// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We apply binary search to find the missing number. We use the observation that for [1...n], nums[i] = i + 1, until we find a
   missing number. If we see the first occurence of this rule violation, we return mid + 1 as the missing element. Else if we have
   not encountered this rule violation yet, that means missing number lies to the right so we use start = mid + 1 else end = mid - 1
*/

// [1,2,3,4,6,7,8]
class findMissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] != mid + 1 && nums[mid - 1] == mid)
                return (mid + 1);
            else if(nums[mid] == mid + 1)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return Integer.MIN_VALUE;
    }
}
