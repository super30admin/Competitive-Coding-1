"""
Time Complexity : O(LogN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
"""
class Solution:
    def missingElement(self, nums) -> int:
                
        def condition(value):
            return nums[value] != 1 + value
        
        low = 0
        high = len(nums)
        
        while low < high:
            
            mid = low + (high - low)//2
            if(condition(mid)):
                high = mid
            else:
                low = mid + 1
                
        return 1 + low