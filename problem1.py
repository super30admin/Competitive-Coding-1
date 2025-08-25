"""
Space Complexity: O(1)
Time Complexity: O(log(n))

Explanation: We want to find the first index, where the array is shifted i.e 
the first index where the element is misplaced according to index.

"""

class Solution:
    def missingNumber(self, arr):
        
        low = 0
        high = len(arr) - 1
        
        while low <= high: 
            mid = low + (high - low) // 2
            
            if arr[mid] == mid+1: 
                low = mid + 1
            else: 
                high = mid - 1
                
        return low+1
        
    
        
