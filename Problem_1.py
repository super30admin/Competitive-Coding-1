# https://www.geeksforgeeks.org/dsa/find-the-missing-number-in-a-sorted-array/
# https://leetcode.com/problems/missing-element-in-sorted-array/description/

# Time complexity: O(log n) 
# Space complexity: O(1)
# Explanation: Use binary search to find where the difference between two indices changes from 1 to greater than 1 - that's where the number is missing

class Solution:
    def missingElement(self, nums: List[int], k: int) -> int:
        n = len(nums)
        left, right = 0, n - 1
        
        while left < right:
            mid = right - (right - left) // 2
            if (nums[mid] - nums[0]) - mid < k:
                left = mid
            else:
                right = mid - 1

        return nums[0] + k + left 
