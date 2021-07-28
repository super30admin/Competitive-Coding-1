def searchMissing(arr):
    low = 0
    high = len(arr) - 1
    if(len(arr) == 1):
        if arr[0] == 1:
            return arr[0] + 1
        else:
            return arr[0] - 1
    while low <= high:
        mid = low + (high - low)//2
        if low == high:
            if arr[low] - high == 1:
                return arr[low] + 1
            else:
                return arr[low] - 1
        elif arr[mid] - mid == 1:
            low = mid + 1
        elif arr[mid] - mid > 1:
            high = mid - 1
        else:
            low = mid + 1
    return 0
print(searchMissing([1,2,3,4]))