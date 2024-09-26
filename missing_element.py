
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes
'''
for given numbers in the range 0 to n, we know in advance the summation of the n natural numbers is n(n+1)/2,
so here, subtarct the sum of given elements and and subtract it from the actual sum, and that is the missing value.
'''

class Solution:
    def missingNumber(self, nums):
        
        if nums is None or len(nums) < 1:
            return
        
        n = len(nums)
        sum_ = (n * (n+1))//2
        
        
            
        return sum_ - sum([i for i in nums])