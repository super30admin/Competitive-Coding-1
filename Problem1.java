
// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

public class Problem1
{
    public class Solution
    {
        public int findMissingNumInSortedArray(int[] nums)
        {
            int low = 0, high = nums.length-1;
            while (low <= high)
            {
                int mid = low + (high-low)/2;

                if( mid != low && (nums[mid-1] != nums[mid]-1 ))
                    return nums[mid]-1;
                if (mid != high &&  nums[mid+1] != nums[mid]+1 )
                    return nums[mid]+1;

                if(nums[high] - nums[mid+1] > high - (mid+1))
                    low = mid+1;
                else
                    high = mid-1;
            }
            return 0;
        }

    }
}

