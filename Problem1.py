"""
    Problem Statement: Find the Missing Number in a sorted array.

    Approach: Since the input array is sorted and distinct we could apply binary search to find the
              element. Compare the low index and its low index array value with mid index and its mid
              index array value. If they are not the same, which is 1, then the missing number is in
              first half else second half of the array.

    Time complexity: O(log N)

    Space complexity: O(1)

    Date: 15 November 2022
"""
from typing import List

class Solution:
    def solve(self, nums: List) -> int:
        low, high = 0, len(nums) - 1

        while low + 1 < high:
            mid = (low + high) // 2
            
            if nums[low] - low != nums[mid] - mid:
                high = mid
            else:
                low = mid
        return nums[low] + 1 

if __name__ == "__main__":
    sol = Solution()
    nums = [1,2,3,4,5,7,8,9]

    ret = sol.solve(nums)
    assert ret == 6

    # nums = [1,2,4,5]
    # ret = sol.solve(nums)
    # assert ret == 3