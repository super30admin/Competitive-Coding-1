# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Perform binary search. If value at index -minus value at mid is not consistent then that means some number has gone missing.

def search(arr):
    l = 0
    r= len(arr) - 1
    mid = 0
    while r>l+1:
        mid = (l + r) // 2
        if (arr[l] - l) != (arr[mid] - mid):
            r = mid
        elif (arr[r] - r) != (arr[mid] - mid):
            l = mid
    return arr[l] + 1

arr = [1,2,3,4,5,6,7,9]
print("Missing number:", search(arr))