# Time Complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach 1: Use sets. Since the search using sets is faster than the list, loop over all the numbers in that range and check if the
# number exists in the list/array

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        s = set(nums)
        for i in range(1, len(nums)+1):
            if i not in nums:
                return i


# Approach 2: Using binary search. The concept of this approach is that elements occuring before the missing element have a diffe
# of 1 nums[i]-i, otherwise it'll be a difference of 2 after that. 


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        size = len(nums)
        low = 0, high = size - 1, mid = 0
        
        while high > low + 1:
            mid = (low + high) // 2
            if (nums[low] - low) != (nums[mid] - mid):
                high = mid
            elif (nums[high] - high) != (nums[mid] - mid):
                low = mid
        return nums[low] + 1