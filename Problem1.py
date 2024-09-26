def missingNumber(n, arr):
    # code here
    arr = sorted(arr)
    print(arr)
    low = 0
    high = len(arr) - 1
    if arr[low] != 1:
        return 1
    if arr[-1] != n:
        return n
    
    while low <= high:
        mid = low + (high - low) // 2
        if mid > 0 and arr[mid] -1 != arr[mid - 1]:
            return arr[mid] - 1
        if mid < len(arr) - 1 and arr[mid] != arr[mid + 1] - 1:
            return arr[mid] + 1
        
        # if mid > 0 and arr[mid] - arr[mid - 1] != 1:
        #     return arr[mid] - 1
        # if mid < len(arr) - 1 and arr[mid + 1] - arr[mid] != 1:
        #     return arr[mid] + 1
        
        if mid == arr[mid] - 1:
            low = mid + 1
        else:
            high = mid - 1        
    return -1