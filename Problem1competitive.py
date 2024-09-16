
import math

def findmissing(arr,n):
    low = 0
    high = n-1
    while(low<=high):
        mid = math.floor(low+(high-low)/2)
        if arr[mid]!=mid+1:
            if arr[mid]-arr[mid-1]==2:
                return arr[mid]-1
            else:
                high = mid - 1
        else:
            low = mid+1
    return -1



arr = [1, 2, 3, 4, 5, 6, 8, 9]
val = findmissing(arr,7)
print(val)
