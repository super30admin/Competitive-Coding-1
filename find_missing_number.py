def find_missing_number(arr:list):
    if arr[0] != 1:
        return 1
    if arr[-1] != len(arr):
        return len(arr)


    # binary search
    low, high = 0, len(arr)-1

    while low <= high:
        mid = (low+high)//2
        if arr[mid] == mid + 1:
            if arr[mid + 1] > mid + 2:
                return mid + 2
            else:
                low = mid+1
        elif arr[mid] > mid + 1:
            if arr[mid - 1] == mid:
                return mid
            else:
                high = mid - 1


input = [ 2, 3, 4, 5, 6, 7, 8, 9]

print(find_missing_number(input))