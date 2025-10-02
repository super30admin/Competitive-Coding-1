# Time Complexity : O(log n)   # Binary search halves the search space each step
# Space Complexity : O(1)      # Only a few variables used
# Did this code successfully run on Leetcode : Yes
# Approach:
# 1. If first element is not 1 or last element is not n+1, handle those boundary cases directly.
# 2. Otherwise, use binary search: if arr[mid] == mid+1 → left side is correct, move right.
# 3. Else, move left. At the end, the missing number is (lo + 1).

def missingNumber(arr):
    n = len(arr)
    
    # Handle edge case: if the very first element is not 1, then 1 is missing
    if arr[0] != 1:
        return 1
    
    # Handle edge case: if the last element is not n+1, then the missing number is at the end
    if arr[n - 1] != n + 1:
        return n + 1
        
    # Binary search setup
    lo, hi = 0, n - 1
    
    while lo <= hi:
        mid = (lo + hi) // 2   # Find middle index
        
        if arr[mid] == mid + 1:
            # If value matches expected (index+1), left side is correct
            # Missing number must be on the right
            lo = mid + 1
        else:
            # Otherwise mismatch happened here or earlier
            # Move search to the left side
            hi = mid - 1
          
    # At the end, 'lo' will stop at the index where mismatch begins
    # Missing number is index + 1 because numbers are 1-based
    return lo + 1
