"""
Approach:
By using binary search, we want to narrow down the search range based on the midpoint. When the search ends, start points to the index where the missing number should be.
So returning start + 1.

Time Complexity: O(logn)
Space Complexity: O(1)
"""
class Solution:
    def findMissingNumber(self, arr):
        start = 0
        end = len(arr) - 1
        while(start <= end):
            mid = start + (end - start)//2
            if arr[mid] == mid + 1: # If the value at mid is equal to index + 1, then the missing number is in right half
                start = mid + 1
            else: #missing value is in the left side
                end = mid -1
        return start + 1 #since start points to the first incorrect index, returning start + 1
    
        
sol = Solution()
arr = [1, 2, 3, 4, 6, 7, 8]
arr1 = [1, 2, 3, 4, 5, 6, 8, 9]

print(sol.findMissingNumber(arr))
print(sol.findMissingNumber(arr1))

    
