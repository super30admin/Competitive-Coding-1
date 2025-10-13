def find_missing_binary(arr):
    """
    Binary search for finding missing element in O(logn) time complexity
    """
    low, high = 0, len(arr) - 1
    start = arr[0]

    while low <= high:
        mid = (low + high) // 2
        # Difference between value and index should be constant (arr[i] - i = start)
        if arr[mid] - mid != start:
            high = mid - 1
        else:
            low = mid + 1

    return start + low

# Example
arr = [1, 2, 3, 4, 6, 7, 8]
print(find_missing_binary(arr))