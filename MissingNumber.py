# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Use binary search to find the index where low and high indices cross each other. 

class Solution:
    def missingNumber(self, arr):
        
        low, high = 0, len(arr) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if arr[mid] <= (mid + 1):
                low = mid + 1
            else:
                high = mid - 1
        
        return low + 1