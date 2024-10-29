# Approach:
# We use a modified binary search since the array is sorted. If the missing number lies between two indices, 
# the difference between the value at the middle index and its expected value will help narrow down the search.
# We continue adjusting the search boundaries until we locate the missing number in logarithmic time.

# Time Complexity: O(log n) because we are using binary search.
# Space Complexity: O(1) since no extra space is used apart from variables.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def missingNumber(self, arr: list[int]) -> int:
        left, right = 0, len(arr) - 1
        
        # Binary search to find the missing number
        while left <= right:
            mid = left + (right - left) // 2  # Calculate mid index
            
            # Check if the middle element is at its expected position
            if arr[mid] == mid + 1:
                # If it matches, search in the right half
                left = mid + 1
            else:
                # If it doesn't match, search in the left half
                right = mid - 1
        
        # When left exceeds right, the missing number is at position 'left'
        return left + 1
