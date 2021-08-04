# Given a sorted array find missing element
#Time Complexity :  O(logn)  
#Space Complexity : O(1)
def findelement(arr):

    low = 0
    high = len(arr)-1

    while(low <= high):
        mid = low + (high-low)//2
        if high-low == 1 and arr[high]-arr[low]==1:
            return -1
        if high-low == 1 and arr[high]-arr[low]>1:
            return arr[low]+1
        if arr[high]- arr[mid] > high - mid:
            low =mid
        else:
            high = mid
            
    return -1

print(findelement([1, 2, 3, 4, 5, 6, 8]))