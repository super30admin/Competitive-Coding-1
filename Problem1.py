"""
Time Complexity:    O(log(n))
Space Complexity:   O(1)
YES, The code successfully ran on Leetcode

Approach - My approach is pretty straight forward, I am using binary search to search the missing value
the catch here is to always go in the direction where the index doesnt match the calculated index.
"""
def missing(arr):
    lo, hi = 0, len(arr) - 1
    while lo<=hi:
        mid = lo + (hi-lo) // 2
        if mid == arr[mid] - 1:
            lo = mid + 1
        else:
            hi = mid - 1
    return lo + 1

