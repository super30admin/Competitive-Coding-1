def findMissingNumber(arr):
    low, high, mid = 0, len(arr) - 1, 0
    while high > low + 1:
        mid = low + (low + high) // 2
        if (arr[low] - low) != (arr[mid] - mid):
            high = mid
        elif (arr[high] - high) != (arr[mid] - mid):
            low = mid
    return arr[mid] + 1