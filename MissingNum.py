# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No
# Approach: Use binary search on the sorted array of numbers starting from 1. 
# Binary search by comparing index and value, the first mismatch indicates the missing number.

class Solution:
    def missingNumber(self, arr):
        l = 0
        h = len(arr) - 1
        
        while l <= h:
            m = (l + h) // 2
            if arr[m] == m + 1:
                l = m + 1
            else:
                h = m - 1
        return l + 1
