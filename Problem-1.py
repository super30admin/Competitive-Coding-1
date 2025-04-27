'''
    Time Complexity: O(logn)
    Space Complexity: O(1)
    Approach: Use Binary search. 
    If arr[mid] == mid+1 the missing element is on the right side of the array, else on the left side. 
    The low index at the end will be pointing to the index where the missing number should be, return low + 1. 
'''

class Solution:
    # Note that the size of the array is n-1
    def missingNumber(self, n, arr):
        # code here
        low, high = 0, n - 2
        if arr[low] != 1:
             return 1
        if arr[high] != high + 2:
            return n
        while low <= high:
            mid = low + (high - low)//2
            if arr[mid] == mid + 1:
                low = mid + 1
            else:
                high = mid - 1
        return low+1