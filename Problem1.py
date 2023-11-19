# Time Complexity : O(logn)
# Space Complexity : O(1)
# Any problem you faced while coding this : No

'''
1. If the first element is not 1, then the missing element is 1
2. If the difference between the middle element and the left element is not equal to the difference between indices, then the missing element is in the left half. Similarly on right side
3. So move either the left or right pointer to middle accordingly
'''
from typing import List


def findMissingElement(arr: List[int]) -> int:
    l = 0
    r = len(arr)-1
    if len(arr) == 1:
        if arr[0] == 2:
            return arr[0]-1
    if arr[0] != 1:
        return 1
    while(l <= r):
        m = l + (r-l)//2
        if (r-l) == 1:
            return arr[l]+1
        if(arr[m]-arr[l] != m-l):
            r = m
        elif(arr[r]-arr[m] != r-m):
            l = m
    return None
