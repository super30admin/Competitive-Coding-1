'''
Time Complexity: O(log n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: 8+6/2 = 7 so find low and high and check if the element - index , do this for low - nums[low] and
high - nums[high] and move the array based on nums[mid] - mid != nums[low] - low -> high = mid
and nums[mid] - mid != nums[high] - high -> low = mid

return nums[low] +nums[high]/2
'''
class Solution:
    def missingNumber(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) - 1

        while high - low >= 2:
            mid = int(low + (high - low) / 2)
            if nums[mid] - mid != nums[low] - low:
                high = mid

            if nums[mid] - mid != nums[high] - high:
                low = mid

        return int((nums[low] + nums[high]) / 2)