# Time Complexity: O(logN)
# Space Complexity: O(1)

# Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
# Output : 5
#
# Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
# Output : 7

def find_missing(arr):
    # First element is missing
    if arr[0] != 1:
        return 1
    if arr[-1] != len(arr) + 1:
        return len(arr) + 1

    l, r = 0, len(arr) - 1
    while l <= r:
        mid = l + (r - l) // 2
        if mid != arr[mid] - 1:
            return mid + 1
        else:
            l = mid + 1
    return -1

if __name__ == '__main__':
    print(find_missing([1, 2, 3, 4, 5, 6, 8, 9]))
    print(find_missing([2, 3, 4, 5, 6, 7, 8, 9]))
    print(find_missing([1,2, 3, 4, 5, 6, 7, 8, 9]))
