#Time Complexity: O(logn)
#Space Complexity: O(1)

def missing(arr):
    low = 0
    high = len(arr)-1
    mid = low + (high - low) // 2
    while(low<high):
        mid = low + (high - low) // 2
        lowdiff = arr[low] - low
        middiff = arr[mid] - mid
        highdiff = arr[high]- high
        if lowdiff==middiff:
            low = mid+1
        elif middiff == highdiff:
            high = mid-1

    return (arr[mid]-1)

      #0,1,2,3,4,5,6
arr = [1,3,4,5,6,7,8]
print('Missing element is', missing(arr))
