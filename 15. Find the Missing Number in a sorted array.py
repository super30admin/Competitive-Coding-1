arr = [1, 2, 3, 5, 6, 7, 8, 9]


# mid = arr[3]

# if arr[mid] - mid > 1
# return mid + 1
# elif
# high  = mid -1
# low = mid + 1

def missing_element(arr):
    low = 0
    high = len(arr) - 1
    mid = 0
    while high > low + 1:
        mid = low + (high - low) // 2
        if (arr[low] - low) != (arr[mid] - mid):
            high = mid
        elif arr[high] - high != (arr[mid] - mid):
            low = mid
    return arr[low] + 1

print(missing_element(arr))