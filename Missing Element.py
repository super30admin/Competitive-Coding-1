# TC-O()
# SC-O()
def missing(arr):
    if (arr[0] != 1):
        return 1

    low = 0
    high = len(arr) - 1
    if ((high - low) == (arr[high] - arr[low])):
        return arr[high] + 1
    while (low <= high):
        mid = int(low + (high - low) // 2)
        if (high - low == 1 and arr[high] - arr[low] == 2):
            return (arr[low] + 1)
        elif ((high - mid) != (arr[high] - arr[mid])):
            low = mid
        else:
            high = mid