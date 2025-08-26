
"""
Space Complexity: O(1)
Time Complexity: O(log(n))
Explanation: The code uses binary search to find the point where the difference between element value and index changes, i
ndicating the missing number's position.
It returns the missing number by adding the starting value arr[0] to the final index low.
"""

def find_missing_number(arr):
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = (low + high) // 2
        if arr[mid] - mid == arr[low] - low:
            low = mid + 1
        else:
            high = mid - 1

    return low + arr[0]
    

