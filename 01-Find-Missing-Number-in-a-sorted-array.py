def missingNumber(arr):
    n = len(arr)
    
    # Extreme cases
    if arr[0] != 1:
        return 1
    if arr[n - 1] != n + 1:
        return n + 1
        
    # Implementing binary search
    lo, hi = 0, n - 1
    while hi - lo > 1:
        mid = (lo + hi) // 2
        if arr[lo] - lo != arr[mid] - mid:
            hi = mid
        elif arr[hi] - hi != arr[mid] - mid:
            lo = mid
    return arr[lo] + 1

arr = [1, 2, 3, 4, 6, 7, 8]
print(missingNumber(arr))