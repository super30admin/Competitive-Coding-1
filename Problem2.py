"""
Given an array nums containing n distinct numbers in the range [0, n], 
return the only number in the range that is missing from the array.

"""

# Time Complexity : O(n log n)
# Space Complexity : O(n)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

def missingNumber(self, nums: List[int]) -> int:
  
        low = mid = 0
        high = len(nums) - 1
        
        new = sorted(nums)
        
        while high - low >= 2:
            mid = low + (high - low) // 2
            if new[mid] - mid != new[low] - low:
                high = mid
            elif new[mid] - mid != new[high] - high:
                low = mid
        
        return (new[low] + new[high])// 2