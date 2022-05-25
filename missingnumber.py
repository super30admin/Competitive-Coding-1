#Time Complexity: O(logn)
#Space Complexity: O(1)
def findMissingNumber(arr):
    low = 0
    high = len(arr)-1
    if arr[-1] != len(arr)+1:
        return len(arr)+1
    while low!=high:
        mid = low + (high-low)//2
        if arr[mid] - mid>1:
            high = mid-1
        else:
            low = mid +1
    return low+1

