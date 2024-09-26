"""
Approach:
The goal is to find 2 numbers usng binary search between which the missing number should have been present
1) using binary search, get the partition of the array where a number might be missing
    a) compare the difference between elements and respective indices of high pointer and mid pointer, then low pointer
    and mid pointer
    b) move to left partition if the difference is more between low and mid pointer, else move right
2) we break out of the loop when arrive at two elements with difference more than 1. now, the missing number between
them can be found

"""
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while high - low >= 2:
            mid = low + (high - low) // 2

            if nums[low] - low > nums[mid] - mid:
                high = mid
            else:
                low = mid
        return (high + low) // 2
"""
Time Complexity:O(log n)
Space Complexity: O(1)
"""


nums = [1,2,3,4,5,6,8]
print(solution(nums))