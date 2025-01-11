
def insertposofk(arr, k):
    low, high = 0, len(arr) - 1
    while (low <= high):
        mid = low + (high - low)//2
        if arr[mid] == k:
            return mid
        if arr[mid] < k:
            low = mid + 1
        else:
            high = mid - 1
    return low

ans = insertposofk([1,3,5,6], 7)
print(ans)