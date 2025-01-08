# Time complexity: O(log n)
# Space complexity: O(1)

# Approach: Perform binary search, if diff of num and its idx does not match for mid and low
# go towards low, else go towards high, till you end up with two nums between which our
# missing num lies

# arr = [1, 2, 3, 4, 5, 6, 8, 9]
# expected output = 7

from typing import List
class Solution:
    def findMissing(self, nums: List[int]) -> int:
        if nums == None or len(nums) <= 1:
            return -1
        
        if len(nums) == 2:
            return (nums[0] + nums[1]) // 2
        
        low = 0
        high = len(nums) - 1
        
        while (high - low >= 2):
            mid = low + ((high - low) // 2)
            
            if (nums[mid] - mid) != (nums[low] - low):
                high = mid
            elif (nums[mid] - mid) != (nums[high] - high):
                low = mid

        return ((nums[low] + nums[high]) // 2)

# sol = Solution()           
# print(sol.findMissing(nums = arr))