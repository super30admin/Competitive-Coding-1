# Find missing number in an array

# Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
# Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]


def searchMissingElement(li):
    low = 0
    high = len(li) - 1
    while low <= high:
        mid = (low + high) // 2
        if li[mid] == (mid + 1):
            # missing element in right side of array
            low = mid + 1
        else:
            high = mid - 1
    return low + 1


li = [1, 2, 3, 5, 6, 7, 8]
print(searchMissingElement(li))
