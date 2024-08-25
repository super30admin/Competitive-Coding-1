# time complexity = O(logn)
# Space complexity - O(1)
def missing_number(arr):
    n = len(arr)
    if not n:
        return 0
    if arr[0] != 1:
        return 1
    if arr[-1] != n + 1:
        return n + 1
    low = 0
    high = n - 1
    while (low <= high):
        mid = low + (high -low) // 2
        if arr[mid] - mid > 1:
            high = mid - 1
        else:
            low = mid + 1
    return arr[low] - 1


print(missing_number([0,2,3,4]))
            
