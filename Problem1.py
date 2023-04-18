"""
Find missing number in array
Approach-1 : TC = O(logN), SC= O(1)
1. comapre the index and the value at the index, this will tell which side is the missing element
2. If missing element is LHS,  then arr[low] - low < arr[mid] - mid
3. else arr[high] - high > arr[mid] - mid is True. 
"""

def missingNum(arr):
    low = 0
    high = len(arr)-1
    while low <= high:
        mid = low + (high-low)//2
        if mid < len(arr)-1 and arr[mid]+1 < arr[mid+1]:
            return arr[mid]+1
        elif mid > 0 and arr[mid]-1 > arr[mid-1]:
            return arr[mid]-1
        if arr[low] - low < arr[mid] - mid:
            #missing element in LHS
            high = mid - 1
        elif arr[high] - high > arr[mid] - mid:
            #missing element in RHS
            low = mid + 1
    return -1

arr = [3,4,5,7,8]
print(missingNum(arr))

arr = [1,2,4,5,6,7,8]
print(missingNum(arr))




