#Time Complexity : O(log n) ... n is number of elements 
#Space Complexity : O(1)
#Any problem you faced while coding this : faced some issue with the terminating condition

#The approach is to find the pattern between the low and high position based array elements. As one of the numbers would be missing, the difference between the low and high elements and the middle element would be changed by 1. So it is required to find that using the indices.

def checkMissing(arr):
    low = 0
    high = len(arr)-1

    while high - low >= 2:
        mid = (low + high)//2
        diffLow = arr[low] - low
        diffHigh = arr[high] - high
        diffMid = arr[mid] - mid
        
        if diffMid < diffHigh:
            low = mid
        elif diffMid > diffLow:
            high = mid
            
    return (arr[low] + arr[high])//2

arr = [2,3,4,5,7,8,9,10]
print(checkMissing(arr))
        