# Time complexity: O(log n)
# Space complexity: O(1)

# Perform binary search as usual.
# Instead of returning -1 when index is not found, return the low index
# that was when we exited the while loop (coz that is closest we came to
# the target)

# arr = [1, 3, 5, 7, 9]
# target = 7

from typing import List
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if len(nums) == 0 or nums == None:
            return 0
        
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + ((high - low) // 2)

            if nums[mid] == target:
                return mid
            
            if nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return low