# We use binary search to efficiently find the missing number in a sorted array of numbers from 1 to n.
# At each step, we compare the value at the middle index to its expected value (index + 1) to determine which half contains the missing number.
# The first index where the value does not match the expected value indicates the position of the missing number.

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def find_missing_number(self, nums):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            # The expected value at index mid is mid + 1
            if nums[mid] == mid + 1:
                left = mid + 1
            else:
                right = mid - 1
        # The missing number is left + 1
        return left + 1