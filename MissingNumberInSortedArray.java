//Time Complexity: O(logn)
//Space Complexity: O(1)
class Solution {
    public int missingElement(int[] nums, int k)
    {
        int left = 0;
        int right = nums.length - 1;
        int numberOfMissing = 0;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            numberOfMissing = nums[mid] - nums[0] - mid;

            if(k > numberOfMissing)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        if (numberOfMissing >= k)
        {
            return nums[left] - 1 - (numberOfMissing - k);
        }
        return nums[right] + (k - numberOfMissing);
    }
}