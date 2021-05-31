# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# using sum of n numbers and substracting the sum of the given numbers to get the missing one
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        a = sum(nums)
        b = max(nums)
        if b < len(nums):
            return len(nums)
        s = (b*(b+1))//2
        return s - a