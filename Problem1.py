
"""
Find Missing Number in a sorted array
https://youtu.be/LwmckBrlrRs


https://leetcode.com/problems/missing-number

Time complexity: O(n) 

Space complexity: O(1)
"""


class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        expected_sum = n * (n + 1) // 2
        actual_sum = sum(nums)
        return expected_sum - actual_sum
